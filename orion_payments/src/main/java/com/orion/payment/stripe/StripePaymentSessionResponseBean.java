package com.orion.payment.stripe;

import com.orion.core.abstraction.OrionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class StripePaymentSessionResponseBean extends OrionResponse
{
    private String stripeSessionID;
    private String stripePublishableKey;
    private String orderStatusPageID;
    private String sessionCourierBasketID;
    private String sessionShoppingBasketID;
    private Boolean paymentSuccessful;
    private Boolean paymentCancellationSuccessful;
    private Boolean emptyBasket;
    private Boolean isStoreUnavailable;


    public static StripePaymentSessionResponseBean of()
    {
        return StripePaymentSessionResponseBean.builder().build();
    }


    public static StripePaymentSessionResponseBean of(String stripeSessionID)
    {
        return StripePaymentSessionResponseBean.builder().stripeSessionID(stripeSessionID).build();
    }
}