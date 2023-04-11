package com.orion.math.statistics.chart.pareto;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import java.util.List;
import java.util.Map;

public class ParetoChartRules extends MathRule
{
    public static void isValid(List<Map.Entry<StatisticalClass, ANumber>> classValues, List<ANumber> classCumulativeValues)
    {
        Assert.notEmpty(classValues, "The classValues input cannot be null/empty.");
        Assert.notNull(classCumulativeValues, "The classCumulativeValues input cannot be null.");
        Assert.areEqual(classCumulativeValues.size(), classValues.size(), "classCumulativeValues size does not match number of statistical classes.");
    }


    public static void isValid(ParetoChart paretoChart)
    {
        Assert.notNull(paretoChart, "The paretoChart input cannot be null.");
        isValid(paretoChart.getClassValues(), paretoChart.getClassCumulativeValues());
    }
}