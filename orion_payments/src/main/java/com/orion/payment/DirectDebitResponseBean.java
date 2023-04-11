package com.orion.payment;

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
public class DirectDebitResponseBean extends OrionResponse
{
    private String stripeBACSDirectDebitSessionURL;


    public static DirectDebitResponseBean of()
    {
        return DirectDebitResponseBean.builder().build();
    }
}