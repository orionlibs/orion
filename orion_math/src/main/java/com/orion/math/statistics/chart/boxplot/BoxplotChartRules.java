package com.orion.math.statistics.chart.boxplot;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.statistics.data.fivenumbersummary.FiveNumberSummary;
import com.orion.math.statistics.data.fivenumbersummary.FiveNumberSummaryRules;

public class BoxplotChartRules extends MathRule
{
    public static void isValid(FiveNumberSummary fiveNumberSummary)
    {
        FiveNumberSummaryRules.isValid(fiveNumberSummary);
    }


    public static void isValid(BoxplotChart boxplotChart)
    {
        Assert.notNull(boxplotChart, "The boxplotChart input cannot be null.");
        isValid(boxplotChart.getFiveNumberSummary());
    }
}