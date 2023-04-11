package com.orion.math.product.analytic;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.function.Functions;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;

public class ProductWithAnalyticFormRules extends MathRule
{
    public static void isValid(Function1x1IF<ANumber, ANumber> expression)
    {
        Assert.isFalse(Functions.isNotValid(expression), "Product analytic function is empty.");
    }


    public static void isValid(ProductWithAnalyticForm productWithAnalyticForm)
    {
        Assert.notNull(productWithAnalyticForm, "The productWithAnalyticForm input cannot be null.");
        isValid(productWithAnalyticForm.getExpression());
    }
}