package com.orion.payment.stripe;

import com.orion.core.abstraction.OrionRequest;
import com.orion.core.data.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PaymentWithStripeSessionRequestBean extends OrionRequest implements Validator
{
    private String sessionBasketID;
    private String sessionCourierBasketID;
    private String sessionShoppingBasketID;
    private String stripeCustomerID;
    private String stripeBACSDirectDebitSessionID;


    public static PaymentWithStripeSessionRequestBean of()
    {
        return PaymentWithStripeSessionRequestBean.builder().build();
    }
}