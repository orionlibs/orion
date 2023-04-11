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
import com.stripe.model.SetupIntent;
import com.stripe.model.checkout.Session;
import com.stripe.net.RequestOptions;
import com.stripe.param.checkout.SessionRetrieveParams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class StripePaymentMethodBO extends Orion
{
    private String stripeCustomerID;
    private String directDebitSetupSessionID;
    private RequestOptions requestOptions;


    public static StripePaymentMethodBO of(String stripeCustomerID, RequestOptions requestOptions)
    {
        return StripePaymentMethodBO.builder()
                        .stripeCustomerID(stripeCustomerID)
                        .requestOptions(requestOptions)
                        .build();
    }


    public static StripePaymentMethodBO ofDirectDebitSetupSessionID(String directDebitSetupSessionID, RequestOptions requestOptions)
    {
        return StripePaymentMethodBO.builder()
                        .directDebitSetupSessionID(directDebitSetupSessionID)
                        .requestOptions(requestOptions)
                        .build();
    }


    public String getPaymentMethodID()
    {
        Stripe.apiKey = InMemoryConfigurationService.getProp("payment.stripe.api.key");

        //Expected a string but was BEGIN_OBJECT at line 40 column 20 path $.setup_intent
        try
        {
            SessionRetrieveParams params = SessionRetrieveParams.builder()
                            .addExpand("setup_intent")
                            .build();
            //Session session = Session.retrieve("{{SESSION_ID}}", params, null);
            Session session = Session.retrieve(directDebitSetupSessionID, params, null);
            //StripePaymentResponseBean responseBean = (StripePaymentResponseBean)JSONService.convertJSONToObject(session.getLastResponse().body(), StripePaymentResponseBean.class);
            SetupIntent setupIntent = SetupIntent.retrieve(session.getSetupIntent());
            //setupIntent.getMandateObject().getPaymentMethodObject().getBacsDebit().
            //setupIntent.getPaymentMethodObject().getBacsDebit().
            return setupIntent.getPaymentMethod();
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