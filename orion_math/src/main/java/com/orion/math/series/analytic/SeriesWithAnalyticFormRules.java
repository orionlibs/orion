package com.orion.math.series.analytic;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.function.Functions;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;

public class SeriesWithAnalyticFormRules extends MathRule
{
    public static void isValid(Function1x1IF<ANumber, ANumber> expression)
    {
        Assert.isFalse(Functions.isNotValid(expression), "Series analytic function is empty.");
    }


    public static void isValid(SeriesWithAnalyticForm seriesWithAnalyticForm)
    {
        Assert.notNull(seriesWithAnalyticForm, "The seriesWithAnalyticForm input cannot be null.");
        isValid(seriesWithAnalyticForm.getExpression());
    }
}