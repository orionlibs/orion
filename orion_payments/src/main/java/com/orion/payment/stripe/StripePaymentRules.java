package com.orion.payment.stripe;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.util.Map;

public class StripePaymentRules<LABEL_TYPE> extends Orion
{
    public static <LABEL_TYPE> void isValid(Map<String, String[]> parameterMap, int amountInPence, String paymentDescription)
    {
        Assert.notEmpty(parameterMap, "parameterMap input cannot be null/empty.");
        Assert.isPositive(amountInPence, "amountInPence input has to be a natural number.");
        Assert.notEmpty(paymentDescription, "paymentDescription input cannot be null.");
    }
}