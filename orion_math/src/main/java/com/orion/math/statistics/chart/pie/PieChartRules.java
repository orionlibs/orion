package com.orion.math.statistics.chart.pie;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import java.util.List;
import java.util.Map;

public class PieChartRules extends MathRule
{
    public static void isValid(List<Map.Entry<StatisticalClass, ANumber>> classValues)
    {
        Assert.notEmpty(classValues, "The classValues input cannot be null/empty.");
    }


    public static void isValid(PieChart pieChart)
    {
        Assert.notNull(pieChart, "The pieChart input cannot be null.");
        isValid(pieChart.getClassValues());
    }
}