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
public class StripeDirectDebitResponseBean extends OrionResponse
{
    private Boolean directDebitSetupSuccessful;


    public static StripeDirectDebitResponseBean of()
    {
        return StripeDirectDebitResponseBean.builder().build();
    }
}