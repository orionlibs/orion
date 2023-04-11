package com.orion.finance.currency;

import com.orion.core.calendar.locale.LocaleService;
import com.orion.core.exception.Assert;
import com.orion.finance.currency.model.CurrencyModel;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Currency;
import java.util.Locale;
import java.util.stream.Collectors;

public class CurrencyBO
{
    public static Collection<CurrencyModel> getUniqueCurrencies()
    {
        return LocaleService.getFilteredLocaleStream().map(locale -> getCurrencyByLocale(locale))
                        .filter(curr -> !(curr == null))
                        .collect(Collectors.toMap(Currency::getCurrencyCode, CurrencyBO::createCurrency, (currency, duplicateCurrency) -> currency))
                        .values();
    }


    public static CurrencyModel createCurrency(Currency javaCurrency)
    {
        return CurrencyModel.builder()
                        .currencyCode(javaCurrency.getCurrencyCode())
                        .currencyDisplayName(javaCurrency.getDisplayName(Locale.UK)).build();
    }


    public static Currency getCurrencyByLocale(Locale locale)
    {

        try
        {
            return Currency.getInstance(locale);
        }
        catch(IllegalArgumentException e)
        {
            return null;
        }

    }


    public static int convertAmountToPence(BigDecimal amount) throws NumberFormatException
    {
        Assert.notNull(amount, "amount input cannot be null.");
        return amount.multiply(new BigDecimal("100")).intValue();
    }


    public static int convertFormattedAmountToPence(String amount) throws NumberFormatException
    {
        Assert.notEmpty(amount, "amount input cannot be null/empty.");
        String unformattedAmount = amount.substring(1);
        unformattedAmount = unformattedAmount.replace(",", "");
        BigDecimal amountAsDecimal = new BigDecimal(unformattedAmount);
        return amountAsDecimal.multiply(BigDecimal.valueOf(100)).intValue();
    }
}