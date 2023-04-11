package com.orion.payment.stripe;

import com.orion.core.abstraction.Orion;
import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.core.document.json.JSONService;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.logger.LoggingService;
import com.orion.payment.OrderDetailsRequestBean;
import com.orion.payment.PaymentErrorType;
import com.orion.payment.PaymentErrors;
import com.orion.payment.model.PaymentProductsModel;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.net.RequestOptions;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.LineItem;
import com.stripe.param.checkout.SessionCreateParams.LineItem.PriceData;
import com.stripe.param.checkout.SessionCreateParams.LineItem.PriceData.ProductData;
import com.stripe.param.checkout.SessionCreateParams.PaymentIntentData;
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
public class StripeSessionBO extends Orion
{
    private OrderDetailsRequestBean requestBean;
    private RequestOptions requestOptions;


    public static StripeSessionBO of(OrderDetailsRequestBean requestBean, RequestOptions requestOptions)
    {
        return StripeSessionBO.builder().requestBean(requestBean).requestOptions(requestOptions).build();
    }


    public String createNewSession()
    {
        Stripe.apiKey = InMemoryConfigurationService.getProp("payment.stripe.api.key");
        String description = requestBean.getOrderName();
        PaymentIntentData paymentIntentData = SessionCreateParams.PaymentIntentData.builder()
                        .setCaptureMethod(SessionCreateParams.PaymentIntentData.CaptureMethod.MANUAL)
                        .setDescription(description)
                        .putMetadata("sessionBasketID", requestBean.getSessionBasketID())
                        .putMetadata("description", description)
                        .putMetadata("merchantID", requestBean.getMerchantID())
                        //.setReceiptEmail(requestBean.getEmailAddress())
                        .setStatementDescriptor("Onelivery")
                        //.setTransferData(null)
                        .build();
        ProductData productData = null;
        PriceData priceData = null;
        LineItem lineItem = null;
        List<LineItem> lineItems = new ArrayList<>();

        if(requestBean.getProducts() != null)
        {

            for(PaymentProductsModel.ProductModel product : requestBean.getProducts().getProducts())
            {
                productData = SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                .setName(product.getName())
                                .build();
                priceData = SessionCreateParams.LineItem.PriceData.builder()
                                .setTaxBehavior(SessionCreateParams.LineItem.PriceData.TaxBehavior.EXCLUSIVE)
                                .setCurrency(requestBean.getCurrencyCode())
                                .setUnitAmount(product.getBasePrice())
                                .setProductData(productData)
                                .build();
                lineItem = SessionCreateParams.LineItem.builder()
                                .setQuantity(product.getQuantity())
                                .setPriceData(priceData)
                                .build();
                lineItems.add(lineItem);
            }

        }
        else
        {
            productData = SessionCreateParams.LineItem.PriceData.ProductData.builder()
                            .setName(requestBean.getOrderName())
                            .build();
            priceData = SessionCreateParams.LineItem.PriceData.builder()
                            .setTaxBehavior(SessionCreateParams.LineItem.PriceData.TaxBehavior.EXCLUSIVE)
                            .setCurrency(requestBean.getCurrencyCode())
                            .setUnitAmount(requestBean.getGrandTotalPriceAmount())
                            .setProductData(productData)
                            .build();
            lineItem = SessionCreateParams.LineItem.builder()
                            .setQuantity(requestBean.getQuantity())
                            .setPriceData(priceData)
                            .build();
            lineItems.add(lineItem);
        }

        String successURL = "";
        String cancellationURL = "";

        if(requestBean.getIsCourierOrder())
        {
            successURL = ConfigurationService.getProp("payment.stripe.success.url.for.courier");
            cancellationURL = ConfigurationService.getProp("payment.stripe.cancel.url.for.courier");
        }
        else
        {
            successURL = ConfigurationService.getProp("payment.stripe.success.url.for.shopping");
            cancellationURL = ConfigurationService.getProp("payment.stripe.cancel.url.for.shopping");
        }

        successURL += requestBean.getSessionBasketID();
        cancellationURL += requestBean.getSessionBasketID();
        SessionCreateParams sessionParameters = SessionCreateParams.builder()
                        .putMetadata("sessionBasketID", requestBean.getSessionBasketID())
                        .putMetadata("description", description)
                        .putMetadata("merchantID", requestBean.getMerchantID())
                        .setPaymentIntentData(paymentIntentData)
                        .setClientReferenceId(requestBean.getUserID())
                        .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                        //.setClientReferenceId(requestBean.getUserID())
                        .setBillingAddressCollection(SessionCreateParams.BillingAddressCollection.REQUIRED)
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl(successURL)
                        .setCancelUrl(cancellationURL)
                        .addAllLineItem(lineItems)
                        .build();

        try
        {
            Session session = Session.create(sessionParameters, requestOptions);
            Map<String, String> responseData = new HashMap<>();
            responseData.put("id", session.getId());
            return JSONService.convertJSONMapToString(responseData);
        }
        catch(StripeException e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
        }
        catch(Exception e)
        {
            LoggingService.logError(e, null,
                            null,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripeSessionIDGeneration);
        }

        return null;
    }
}