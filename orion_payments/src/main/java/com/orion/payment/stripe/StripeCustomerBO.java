package com.orion.payment.stripe;

import com.orion.core.abstraction.Orion;
import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.logger.LoggingService;
import com.orion.payment.PaymentErrorType;
import com.orion.payment.PaymentErrors;
import com.stripe.Stripe;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.RateLimitException;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.net.RequestOptions;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.CustomerUpdateParams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class StripeCustomerBO extends Orion
{
    private String stripeCustomerID;
    private String userID;
    private String username;
    private String userFullNameOrBusinessName;
    private String userPhoneNumber;
    private RequestOptions requestOptions;


    public static StripeCustomerBO ofCustomerID(String stripeCustomerID, RequestOptions requestOptions)
    {
        return StripeCustomerBO.builder()
                        .stripeCustomerID(stripeCustomerID)
                        .requestOptions(requestOptions)
                        .build();
    }


    public static StripeCustomerBO ofUserDetails(String userID, String username, String userFullNameOrBusinessName, String userPhoneNumber, RequestOptions requestOptions)
    {
        return StripeCustomerBO.builder()
                        .userID(userID)
                        .username(username)
                        .userFullNameOrBusinessName(userFullNameOrBusinessName)
                        .userPhoneNumber(userPhoneNumber)
                        .requestOptions(requestOptions)
                        .build();
    }


    public static StripeCustomerBO ofUserIDAndUserDetails(String stripeCustomerID, String username, String userFullNameOrBusinessName, String userPhoneNumber, RequestOptions requestOptions)
    {
        return StripeCustomerBO.builder()
                        .stripeCustomerID(stripeCustomerID)
                        .username(username)
                        .userFullNameOrBusinessName(userFullNameOrBusinessName)
                        .userPhoneNumber(userPhoneNumber)
                        .requestOptions(requestOptions)
                        .build();
    }


    public boolean doesCustomerIDExist()
    {
        Stripe.apiKey = InMemoryConfigurationService.getProp("payment.stripe.api.key");

        try
        {
            Customer stripeCustomer = Customer.retrieve(stripeCustomerID, requestOptions);
            return stripeCustomer != null
                            && stripeCustomer.getName() != null
                            && !stripeCustomer.getName().isEmpty()
                            && stripeCustomer.getEmail() != null
                            && !stripeCustomer.getEmail().isEmpty();
        }
        catch(ApiConnectionException e)
        {
            return false;
        }
        catch(ApiException e)
        {
            return false;
        }
        catch(RateLimitException e)
        {
            return false;
        }
        catch(StripeException e)
        {
            return false;
        }

    }


    public String createStripeCustomer()
    {
        Stripe.apiKey = InMemoryConfigurationService.getProp("payment.stripe.api.key");

        try
        {
            CustomerCreateParams params = CustomerCreateParams
                            .builder()
                            .setEmail(username)
                            .setName(userFullNameOrBusinessName)
                            .setPhone(userPhoneNumber)
                            /*.setInvoiceSettings(
                                            CustomerCreateParams.InvoiceSettings
                                                            .builder()
                                                            .setDefaultPaymentMethod(PaymentMethod.BACSDirectDebit.get())
                                                            .build())*/
                            .build();
            return Customer.create(params).getId();
        }
        catch(ApiConnectionException e)
        {
            LoggingService.logError(e, null,
                            userID,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripe);
            return null;
        }
        catch(ApiException e)
        {
            LoggingService.logError(e, null,
                            userID,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripe);
            return null;
        }
        catch(RateLimitException e)
        {
            LoggingService.logError(e, null,
                            userID,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripe);
            return null;
        }
        catch(StripeException e)
        {
            LoggingService.logError(e, null,
                            userID,
                            PaymentErrorType.Stripe.get(),
                            PaymentErrors.ErrorWithPaymentWithStripe);
            return null;
        }

    }


    public boolean updateStripeCustomer()
    {
        Stripe.apiKey = InMemoryConfigurationService.getProp("payment.stripe.api.key");

        try
        {
            Customer stripeCustomer = Customer.retrieve(stripeCustomerID, requestOptions);

            if(stripeCustomer != null
                            && stripeCustomer.getName() != null
                            && !stripeCustomer.getName().isEmpty()
                            && stripeCustomer.getEmail() != null
                            && !stripeCustomer.getEmail().isEmpty())
            {
                CustomerUpdateParams params = CustomerUpdateParams
                                .builder()
                                .setEmail(username)
                                .setName(userFullNameOrBusinessName)
                                .setPhone(userPhoneNumber)
                                .build();
                stripeCustomer.update(params);
                return true;
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
}