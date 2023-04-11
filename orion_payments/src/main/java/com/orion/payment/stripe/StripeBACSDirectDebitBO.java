package com.orion.payment.stripe;

import com.orion.core.abstraction.Orion;
import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.logger.LoggingService;
import com.orion.payment.PaymentErrorType;
import com.orion.payment.PaymentErrors;
import com.orion.payment.PaymentMethod;
import com.stripe.Stripe;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.RateLimitException;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.net.RequestOptions;
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
public class StripeBACSDirectDebitBO extends Orion
{
    private String stripeCustomerID;
    private String paymentMethodID;
    private RequestOptions requestOptions;


    public static StripeBACSDirectDebitBO of(String stripeCustomerID, RequestOptions requestOptions)
    {
        return StripeBACSDirectDebitBO.builder()
                        .stripeCustomerID(stripeCustomerID)
                        .requestOptions(requestOptions)
                        .build();
    }


    public static StripeBACSDirectDebitBO ofPaymentMethodID(String stripeCustomerID, String paymentMethodID, RequestOptions requestOptions)
    {
        return StripeBACSDirectDebitBO.builder()
                        .stripeCustomerID(stripeCustomerID)
                        .paymentMethodID(paymentMethodID)
                        .requestOptions(requestOptions)
                        .build();
    }


    public String createNewStripeSessionForBACSDirectDebitMandateSetup()
    {
        Stripe.apiKey = InMemoryConfigurationService.getProp("payment.stripe.api.key");

        try
        {
            String successURL = ConfigurationService.getProp("payment.stripe.success.url.for.bacs.direct.debit.setup");
            successURL += stripeCustomerID + "?session_id={CHECKOUT_SESSION_ID}";
            String cancellationURL = ConfigurationService.getProp("payment.stripe.cancel.url.for.bacs.direct.debit.setup");
            cancellationURL += stripeCustomerID;
            Map<String, Object> params = new HashMap<String, Object>();
            List<String> paymentMethodTypes = new ArrayList<>();
            paymentMethodTypes.add(PaymentMethod.BACSDirectDebit.get());
            params.put("payment_method_types", paymentMethodTypes);
            params.put("mode", "setup");
            params.put("customer", stripeCustomerID);
            params.put("success_url", successURL);
            params.put("cancel_url", cancellationURL);
            return Session.create(params).getUrl();
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