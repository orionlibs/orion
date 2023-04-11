package com.orion.payment.stripe;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.core.document.json.JSONService;
import com.orion.core.uuid.UUIDSecurityService;
import com.orion.data.user.address.UserAddressService;
import com.orion.data.user.address.model.OrionUserAddressModel;
import com.orion.logger.LoggingService;
import com.orion.payment.PaymentErrorType;
import com.orion.payment.PaymentErrors;
import com.orion.payment.PaymentMethod;
import com.orion.payment.PaymentNotCompletedException;
import com.orion.payment.PaymentService;
import com.orion.payment.PaymentStatus;
import com.orion.payment.data_access.PaymentsDAO;
import com.orion.payment.model.PaymentModel;
import com.stripe.Stripe;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.RateLimitException;
import com.stripe.exception.StripeException;
import com.stripe.model.BalanceTransaction;
import com.stripe.model.Charge;
import com.stripe.model.Invoice;
import com.stripe.model.PaymentIntent;
import com.stripe.model.Refund;
import com.stripe.model.checkout.Session;
import com.stripe.net.RequestOptions;
import com.stripe.param.ChargeUpdateParams;
import com.stripe.param.InvoiceUpdateParams;
import com.stripe.param.PaymentIntentUpdateParams;
import com.stripe.param.RefundCreateParams;
import com.stripe.param.RefundCreateParams.Reason;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class StripePaymentBO extends Orion
{
    private static final String SucceededStatus = "succeeded";
    private String userID;
    private String stripeSessionID;
    private String stripeCustomerID;
    private String paymentMethodID;
    private String paymentDescription;
    private Long orderID;
    private RequestOptions requestOptions;
    private String currencyCode;
    private long amountToCharge;
    private boolean doesUserNotExist;


    public static StripePaymentBO of(String userID, String stripeSessionID, Long orderID, boolean doesUserNotExist, RequestOptions requestOptions, String currencyCode)
    {
        return StripePaymentBO.builder()
                        .userID(userID)
                        .stripeSessionID(stripeSessionID)
                        .orderID(orderID)
                        .requestOptions(requestOptions)
                        .currencyCode(currencyCode)
                        .doesUserNotExist(doesUserNotExist)
                        .build();
    }


    public static StripePaymentBO ofOrderID(Long orderID)
    {
        return StripePaymentBO.builder().orderID(orderID).build();
    }


    public static StripePaymentBO ofAmount(String stripeCustomerID, String paymentMethodID, long amountToCharge, String paymentDescription, RequestOptions requestOptions)
    {
        return StripePaymentBO.builder()
                        .stripeCustomerID(stripeCustomerID)
                        .amountToCharge(amountToCharge)
                        .paymentMethodID(paymentMethodID)
                        .paymentDescription(paymentDescription)
                        .requestOptions(requestOptions)
                        .build();
    }


    public static StripePaymentBO ofStripeSessionID(String stripeSessionID, RequestOptions requestOptions)
    {
        return StripePaymentBO.builder().stripeSessionID(stripeSessionID).requestOptions(requestOptions).build();
    }


    public boolean setAsSuccessful()
    {
        Stripe.apiKey = InMemoryConfigurationService.getProp("payment.stripe.api.key");

        try
        {
            Session session = Session.retrieve(stripeSessionID, requestOptions);
            StripePaymentResponseBean responseBean = (StripePaymentResponseBean)JSONService.convertJSONToObject(session.getLastResponse().body(), StripePaymentResponseBean.class);
            PaymentIntent payment = PaymentIntent.retrieve(responseBean.getPaymentIntent(), requestOptions);
            String paymentDescription = "OrderID: " + Long.toString(orderID) + " -- " + payment.getMetadata().get("description");
            Map<String, String> paymentMetadata = payment.getMetadata();
            paymentMetadata.put("orderID", Long.toString(orderID));
            paymentMetadata.put("description", paymentDescription);
            PaymentIntentUpdateParams updateParameters = PaymentIntentUpdateParams.builder()
                            .setDescription(paymentDescription)
                            .setMetadata(paymentMetadata)
                            .build();
            payment.update(updateParameters, requestOptions);
            boolean proceed = false;

            if(Orion.isTesting())
            {

                if(PaymentStatus.RequiresPaymentMethod.get().equals(payment.getStatus()))
                {
                    proceed = true;
                }

            }
            else if(PaymentStatus.RequiresCapture.get().equals(payment.getStatus()))
            {
                proceed = true;
            }

            if(proceed)
            {
                PaymentModel paymentModel;

                try
                {
                    paymentModel = createPaymentModel(userID, payment, responseBean, orderID, stripeSessionID, currencyCode, requestOptions);
                    PaymentService.savePayment(paymentModel);
                    updateStripeReceiptSummary(payment, orderID, paymentDescription, requestOptions);
                    return true;
                }
                catch(PaymentNotCompletedException e)
                {
                    return false;
                }

            }
            else
            {
                return false;
            }

        }
        catch(ApiConnectionException e)
        {
            LoggingService.logError(e, null,
                            userID,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripe);
            return false;
        }
        catch(ApiException e)
        {
            LoggingService.logError(e, null,
                            userID,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripe);
            return false;
        }
        catch(RateLimitException e)
        {
            LoggingService.logError(e, null,
                            userID,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripe);
            return false;
        }
        catch(StripeException e)
        {
            LoggingService.logError(e, null,
                            userID,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripe);
            return false;
        }

    }


    private static void updateStripeReceiptSummary(PaymentIntent payment, Long orderID, String paymentDescription, RequestOptions requestOptions)
    {

        if(Orion.isNotTesting())
        {
            Charge charge = payment.getCharges().getData().get(0);
            charge.setReceiptNumber(Long.toString(orderID));
            ChargeUpdateParams chargeUpdateParams = ChargeUpdateParams.builder()
                            .setDescription(paymentDescription)
                            .build();
            Map<String, Object> metadata = new HashMap<>();
            metadata.put("receipt_number", Long.toString(orderID));
            Map<String, Object> params = new HashMap<>();
            params.put("metadata", metadata);

            try
            {
                charge.update(chargeUpdateParams, requestOptions);
                charge.update(params, requestOptions);
            }
            catch(StripeException e)
            {
                LoggingService.logError(e.getMessage());
            }

            try
            {
                Invoice invoice = payment.getInvoiceObject();

                if(invoice == null)
                {
                    invoice = Invoice.retrieve(payment.getInvoice(), requestOptions);
                }

                if(invoice == null)
                {
                    invoice = charge.getInvoiceObject();
                }

                if(invoice != null)
                {
                    InvoiceUpdateParams invoiceUpdateParameters = InvoiceUpdateParams.builder()
                                    .setDescription(paymentDescription)
                                    .setStatementDescriptor("Onelivery - " + Long.toString(orderID))
                                    .build();
                    invoice.update(invoiceUpdateParameters, requestOptions);
                    invoice.finalizeInvoice(requestOptions);
                }

            }
            catch(StripeException e)
            {
                LoggingService.logError(e.getMessage());
            }

        }

    }


    private PaymentModel createPaymentModel(String userID, PaymentIntent payment, StripePaymentResponseBean responseBean, Long orderID, String stripeSessionID, String currencyCode, RequestOptions requestOptions) throws PaymentNotCompletedException
    {
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setUserID(userID);
        paymentModel.setOrderID(orderID);
        paymentModel.setStripeSessionID(stripeSessionID);
        paymentModel.setPaymentMethod(PaymentMethod.Card.get());
        paymentModel.setCurrencyCode(currencyCode);
        paymentModel.setIsMoneyCaptured(Boolean.FALSE);

        if(Orion.isTesting())
        {
            paymentModel.setTotalAmount(1L);
            paymentModel.setPaymentStatus(payment.getStatus());
            paymentModel.setPaymentSuccessful(Boolean.TRUE);
            paymentModel.setTransactionID("transactionID");
            paymentModel.setTransactionURL("transactionURL");
            paymentModel.setInvoiceURL("invoiceURL");
            paymentModel.setInvoiceStripeURL("invoiceStripeURL");
            paymentModel.setInvoiceNumber("invoiceNumber");
            paymentModel.setPaymentDateTime(CalendarService.getCurrentDatetimeAsSQLTimestamp());
            paymentModel.setProcessingFeeAmount(0L);
            paymentModel.setPaymentMethod("card");
            paymentModel.setAddressID("addressID");
            paymentModel.setFullName("fullName");
            paymentModel.setEmailAddress("emailAddress");
            paymentModel.setPhoneNumber("phoneNumber");
            return paymentModel;
        }
        else
        {
            Charge charge = payment.getCharges().getData().get(0);

            if(charge.getPaid())
            {

                if(userID == null || userID.isEmpty() || doesUserNotExist)
                {

                    if(charge.getBillingDetails() != null)
                    {
                        paymentModel.setFullName(charge.getBillingDetails().getName());
                        paymentModel.setEmailAddress(charge.getBillingDetails().getEmail());
                        paymentModel.setPhoneNumber(charge.getBillingDetails().getPhone());
                        String addressID = UUIDSecurityService.generateUUIDWithoutHyphens();
                        String postcode = "";

                        if(charge.getBillingDetails().getAddress().getPostalCode() != null)
                        {
                            postcode = charge.getBillingDetails().getAddress().getPostalCode().toUpperCase();
                        }

                        OrionUserAddressModel billingAddress = OrionUserAddressModel.builder()
                                        .addressID(addressID)
                                        .userID(userID)
                                        .houseNumber("")
                                        .houseName("")
                                        .houseAddressLine1(charge.getBillingDetails().getAddress().getLine1())
                                        .houseAddressLine2(charge.getBillingDetails().getAddress().getLine2())
                                        .city(charge.getBillingDetails().getAddress().getCity())
                                        .postcode(postcode)
                                        .countryCodeAlpha2(charge.getBillingDetails().getAddress().getCountry().toUpperCase())
                                        .isPrimaryAddress(Boolean.FALSE)
                                        .creationDateTime(CalendarService.getCurrentDatetimeAsSQLTimestamp())
                                        .isBillingAddress(Boolean.TRUE)
                                        .hideFromUserProfile(Boolean.TRUE)
                                        .build();
                        UserAddressService.normaliseAddress(billingAddress);
                        paymentModel.setAddressID(addressID);
                        UserAddressService.saveUserAddress(billingAddress);
                    }

                }

                String transactionID = responseBean.getPaymentIntent();
                String transactionURL = "https://dashboard.stripe.com/";

                if(!payment.getLivemode())
                {
                    transactionURL += "test/";
                }

                transactionURL += "payments/" + transactionID;

                if(charge.getPaymentMethodDetails() != null && charge.getPaymentMethodDetails().getCard() != null)
                {
                    paymentModel.setPaymentMethod(charge.getPaymentMethodDetails().getCard().getBrand());
                }

                DateTime datetimeOfPayment = CalendarService.convertEpochSecondsToDateTime(charge.getCreated());
                paymentModel.setTotalAmount(charge.getAmount());
                paymentModel.setPaymentStatus(payment.getStatus());
                paymentModel.setPaymentSuccessful(Boolean.TRUE);
                paymentModel.setTransactionID(transactionID);
                paymentModel.setTransactionURL(transactionURL);
                paymentModel.setInvoiceURL(charge.getReceiptUrl());
                paymentModel.setInvoiceStripeURL(charge.getReceiptUrl());
                paymentModel.setInvoiceNumber(charge.getReceiptNumber());
                paymentModel.setPaymentDateTime(datetimeOfPayment.toOrionSQLTimestamp());
                paymentModel.setProcessingFeeAmount(0L);
                return paymentModel;
            }
            else
            {
                PaymentNotCompletedException e = new PaymentNotCompletedException();
                LoggingService.logError(e, null,
                                paymentModel.getUserID(),
                                PaymentErrorType.Stripe.get(),
                                PaymentErrors.ErrorWithPaymentWithStripe);
                throw e;
            }

        }

    }


    public SQLTimestamp refund()
    {
        PaymentModel paymentModel = PaymentService.getPaymentByOrderID(orderID);

        if(PaymentStatus.RequiresCapture.get().equals(paymentModel.getPaymentStatus())
                        || PaymentStatus.Succeeded.get().equals(paymentModel.getPaymentStatus()))
        {
            SQLTimestamp refundDateTime = StripePaymentService.refundUser(paymentModel.getStripeSessionID());

            if(refundDateTime != null)
            {
                paymentModel.setRefundDateTime(refundDateTime);
                paymentModel.setRefundStatus(PaymentStatus.Succeeded.get());
                paymentModel.setRefundSuccessful(Boolean.TRUE);
                paymentModel.setPaymentStatus(PaymentStatus.Canceled.get());
                paymentModel.setPaymentSuccessful(Boolean.FALSE);
                //paymentModel.setRefundReceiptID(refund.getReceiptNumber());
                PaymentsDAO.update(paymentModel);
                return refundDateTime;
            }
            else
            {
                paymentModel.setError("refund failed");
                PaymentsDAO.update(paymentModel);
                return null;
            }

        }
        else
        {
            return null;
        }

    }


    public SQLTimestamp doPartialRefund(long amountToRefund)
    {
        PaymentModel paymentModel = PaymentService.getPaymentByOrderID(orderID);

        if(PaymentStatus.RequiresCapture.get().equals(paymentModel.getPaymentStatus())
                        || PaymentStatus.Succeeded.get().equals(paymentModel.getPaymentStatus()))
        {
            SQLTimestamp refundDateTime = StripePaymentService.doPartialRefundForUser(paymentModel.getStripeSessionID(), amountToRefund);

            if(refundDateTime != null)
            {
                return refundDateTime;
            }
            else
            {
                return null;
            }

        }
        else
        {
            return null;
        }

    }


    public SQLTimestamp refundBySession()
    {
        Stripe.apiKey = InMemoryConfigurationService.getProp("payment.stripe.api.key");
        StripePaymentResponseBean responseBean = null;

        try
        {
            Session session = Session.retrieve(stripeSessionID, requestOptions);
            responseBean = (StripePaymentResponseBean)JSONService.convertJSONToObject(session.getLastResponse().body(), StripePaymentResponseBean.class);
            PaymentIntent payment = PaymentIntent.retrieve(responseBean.getPaymentIntent(), requestOptions);
            PaymentIntent newPayment = null;

            try
            {
                newPayment = payment.cancel(requestOptions);
                return SQLTimestamp.ofEpochSeconds(newPayment.getCanceledAt());
            }
            catch(StripeException e1)
            {
                LoggingService.logError(e1.getMessage());

                if(!PaymentStatus.Canceled.get().equals(payment.getStatus()))
                {
                    Refund refund = null;

                    try
                    {
                        Charge charge = payment.getCharges().getData().get(0);
                        RefundCreateParams refundCreateParameters = RefundCreateParams.builder()
                                        .setCharge(charge.getId())
                                        .setReverseTransfer(false)
                                        .setReason(Reason.REQUESTED_BY_CUSTOMER)
                                        .build();
                        refund = Refund.create(refundCreateParameters);
                    }
                    catch(ApiConnectionException e)
                    {
                        LoggingService.logError(e, null,
                                        null,
                                        PaymentErrorType.Stripe.get(),
                                        PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
                        return null;
                    }
                    catch(ApiException e)
                    {
                        LoggingService.logError(e, null,
                                        null,
                                        PaymentErrorType.Stripe.get(),
                                        PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
                        return null;
                    }
                    catch(RateLimitException e)
                    {
                        LoggingService.logError(e, null,
                                        null,
                                        PaymentErrorType.Stripe.get(),
                                        PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
                        return null;
                    }
                    catch(StripeException e)
                    {
                        LoggingService.logError(e, null,
                                        null,
                                        PaymentErrorType.Stripe.get(),
                                        PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
                        return null;
                    }

                    if(refund != null && PaymentStatus.Succeeded.get().equals(refund.getStatus()))
                    {
                        return SQLTimestamp.ofEpochSeconds(refund.getCreated());
                    }
                    else
                    {
                        return null;
                    }

                }
                else
                {
                    return null;
                }

            }

        }
        catch(ApiConnectionException e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
            return null;
        }
        catch(ApiException e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
            return null;
        }
        catch(RateLimitException e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
            return null;
        }
        catch(StripeException e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
            return null;
        }

    }


    public SQLTimestamp doPartialRefundBySession(long amountToRefund)
    {
        Stripe.apiKey = InMemoryConfigurationService.getProp("payment.stripe.api.key");
        StripePaymentResponseBean responseBean = null;

        try
        {
            Session session = Session.retrieve(stripeSessionID, requestOptions);
            responseBean = (StripePaymentResponseBean)JSONService.convertJSONToObject(session.getLastResponse().body(), StripePaymentResponseBean.class);
            PaymentIntent payment = PaymentIntent.retrieve(responseBean.getPaymentIntent(), requestOptions);
            Refund refund = null;

            try
            {
                Charge charge = payment.getCharges().getData().get(0);
                RefundCreateParams refundCreateParameters = RefundCreateParams.builder()
                                .setAmount(amountToRefund)
                                .setCharge(charge.getId())
                                .setReverseTransfer(false)
                                .setReason(Reason.REQUESTED_BY_CUSTOMER)
                                .build();
                refund = Refund.create(refundCreateParameters, requestOptions);
                return CalendarService.getCurrentDatetimeAsSQLTimestamp();
            }
            catch(ApiConnectionException e)
            {
                LoggingService.logError(e, null,
                                null,
                                PaymentErrorType.Stripe.get(),
                                PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
                return null;
            }
            catch(ApiException e)
            {
                LoggingService.logError(e, null,
                                null,
                                PaymentErrorType.Stripe.get(),
                                PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
                return null;
            }
            catch(RateLimitException e)
            {
                LoggingService.logError(e, null,
                                null,
                                PaymentErrorType.Stripe.get(),
                                PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
                return null;
            }
            catch(StripeException e)
            {
                LoggingService.logError(e, null,
                                null,
                                PaymentErrorType.Stripe.get(),
                                PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
                return null;
            }

        }
        catch(ApiConnectionException e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
            return null;
        }
        catch(ApiException e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
            return null;
        }
        catch(RateLimitException e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
            return null;
        }
        catch(StripeException e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
            return null;
        }

    }


    public boolean captureMoney()
    {
        Stripe.apiKey = InMemoryConfigurationService.getProp("payment.stripe.api.key");

        try
        {
            Session session = Session.retrieve(stripeSessionID, requestOptions);
            StripePaymentResponseBean responseBean = (StripePaymentResponseBean)JSONService.convertJSONToObject(session.getLastResponse().body(), StripePaymentResponseBean.class);
            PaymentIntent payment = PaymentIntent.retrieve(responseBean.getPaymentIntent(), requestOptions);

            if(Orion.isNotTesting())
            {
                PaymentIntent paymentCapture = payment.capture(requestOptions);

                if(SucceededStatus.equals(paymentCapture.getStatus()))
                {
                    PaymentModel paymentModel = PaymentService.getPaymentByOrderID(Long.parseLong(payment.getMetadata().get("orderID")));
                    paymentModel.setIsMoneyCaptured(true);
                    paymentModel.setPaymentStatus(paymentCapture.getStatus());
                    paymentModel.setMoneyCaptureDateTime(CalendarService.getCurrentDatetimeAsSQLTimestamp());
                    paymentModel.setProcessingFeeAmount(0L);

                    try
                    {

                        if(paymentCapture.getCharges() != null && paymentCapture.getCharges().getData() != null)
                        {

                            for(Charge charge : paymentCapture.getCharges().getData())
                            {

                                if(charge != null)
                                {

                                    if(charge.getBalanceTransaction() != null)
                                    {
                                        BalanceTransaction balanceTransaction = BalanceTransaction.retrieve(charge.getBalanceTransaction(), requestOptions);
                                        paymentModel.setProcessingFeeAmount(balanceTransaction.getFee());
                                        break;
                                    }
                                    else if(charge.getBalanceTransactionObject() != null)
                                    {
                                        paymentModel.setProcessingFeeAmount(charge.getBalanceTransactionObject().getFee());
                                        break;
                                    }

                                }

                            }

                        }

                    }
                    catch(Exception e)
                    {
                        LoggingService.logError(e.getMessage());
                    }

                    PaymentService.updatePayment(paymentModel);
                    return true;
                }
                else
                {
                    return false;
                }

            }
            else
            {
                PaymentModel paymentModel = PaymentService.getPaymentByOrderID(Long.parseLong(payment.getMetadata().get("orderID")));
                paymentModel.setIsMoneyCaptured(true);
                paymentModel.setPaymentStatus("succeeded");
                paymentModel.setMoneyCaptureDateTime(CalendarService.getCurrentDatetimeAsSQLTimestamp());
                paymentModel.setProcessingFeeAmount(0L);
                PaymentService.updatePayment(paymentModel);
                return true;
            }

        }
        catch(ApiConnectionException e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
            return false;
        }
        catch(ApiException e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
            return false;
        }
        catch(RateLimitException e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
            return false;
        }
        catch(StripeException e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
            return false;
        }

    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public CustomerChargeResponseVO chargeCustomer()
    {
        Stripe.apiKey = InMemoryConfigurationService.getProp("payment.stripe.api.key");

        try
        {
            Map<String, Object> intentParams = new HashMap<String, Object>();
            List paymentMethodTypes = new ArrayList();
            paymentMethodTypes.add(PaymentMethod.BACSDirectDebit.get());
            intentParams.put("payment_method_types", paymentMethodTypes);
            intentParams.put("payment_method", paymentMethodID);
            intentParams.put("customer", stripeCustomerID);
            intentParams.put("confirm", true);
            intentParams.put("amount", amountToCharge);
            intentParams.put("currency", "GBP");
            intentParams.put("description", paymentDescription);
            intentParams.put("statement_descriptor", "Onelivery LTD");
            PaymentIntent payment = PaymentIntent.create(intentParams, requestOptions);

            if(!payment.getStatus().equals("canceled"))
            {
                List<Charge> charges = payment.getCharges().getData();

                if(charges != null && !charges.isEmpty())
                {
                    Charge charge = charges.get(0);

                    if(charge.getCaptured() != null && charge.getCaptured())
                    {
                        String transactionID = payment.getId();
                        String transactionURL = "https://dashboard.stripe.com/";

                        if(!payment.getLivemode())
                        {
                            transactionURL += "test/";
                        }

                        transactionURL += "payments/" + transactionID;
                        long processingFeeAmount = 0L;

                        if(charge.getBalanceTransaction() != null)
                        {
                            BalanceTransaction balanceTransaction = BalanceTransaction.retrieve(charge.getBalanceTransaction(), requestOptions);
                            processingFeeAmount = balanceTransaction.getFee();
                        }
                        else if(charge.getBalanceTransactionObject() != null)
                        {
                            processingFeeAmount = charge.getBalanceTransactionObject().getFee();
                        }

                        return CustomerChargeResponseVO.builder()
                                        .paymentTimestamp(CalendarService.convertEpochSecondsToDateTime(charge.getCreated()).toOrionSQLTimestamp())
                                        .transactionID(transactionID)
                                        .transactionURL(transactionURL)
                                        .invoiceStripeURL(charge.getReceiptUrl())
                                        .processingFeeAmount(processingFeeAmount)
                                        .build();
                    }
                    else
                    {
                        return null;
                    }

                }
                else
                {
                    return CustomerChargeResponseVO.builder()
                                    .paymentTimestamp(CalendarService.getCurrentDatetimeAsSQLTimestamp())
                                    .transactionID("")
                                    .transactionURL("")
                                    .invoiceStripeURL("")
                                    .processingFeeAmount(0L)
                                    .build();
                }

            }
            else
            {
                return null;
            }

        }
        catch(ApiConnectionException e)
        {
            LoggingService.logError(e, null,
                            "",
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripe);
            return null;
        }
        catch(ApiException e)
        {
            LoggingService.logError(e, null,
                            "",
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripe);
            return null;
        }
        catch(RateLimitException e)
        {
            LoggingService.logError(e, null,
                            "",
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripe);
            return null;
        }
        catch(StripeException e)
        {
            LoggingService.logError(e, null,
                            "",
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripe);
            return null;
        }

    }
}