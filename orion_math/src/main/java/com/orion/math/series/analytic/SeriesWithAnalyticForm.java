package com.orion.math.series.analytic;

import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.series.Series;

public class SeriesWithAnalyticForm extends Series
{
    public SeriesWithAnalyticForm(Function1x1IF<ANumber, ANumber> expression)
    {
        SeriesWithAnalyticFormRules.isValid(expression);
        setExpression(expression);
    }


    public static SeriesWithAnalyticForm of(Function1x1IF<ANumber, ANumber> expression)
    {
        return new SeriesWithAnalyticForm(expression);
    }


    public ANumber getSum(ANumber variableValue)
    {
        return getExpression().run(variableValue);
    }
}