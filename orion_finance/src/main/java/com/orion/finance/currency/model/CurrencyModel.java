package com.orion.finance.currency.model;

import java.io.Serializable;
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
public class CurrencyModel implements Serializable
{
    private String currencyCode;
    private String currencyDisplayName;


    public static CurrencyModel of()
    {
        return CurrencyModel.builder().build();
    }


    public static CurrencyModel of(String currencyCode)
    {
        return CurrencyModel.builder().currencyCode(currencyCode).build();
    }
}