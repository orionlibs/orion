package com.orion.math.product.analytic;

import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.series.Series;

public class ProductWithAnalyticForm extends Series
{
    public ProductWithAnalyticForm(Function1x1IF<ANumber, ANumber> expression)
    {
        ProductWithAnalyticFormRules.isValid(expression);
        setExpression(expression);
    }


    public static ProductWithAnalyticForm of(Function1x1IF<ANumber, ANumber> expression)
    {
        return new ProductWithAnalyticForm(expression);
    }


    public ANumber getProduct(ANumber variableValue)
    {
        return getExpression().run(variableValue);
    }
}