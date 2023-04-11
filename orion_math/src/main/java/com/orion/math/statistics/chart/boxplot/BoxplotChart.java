package com.orion.math.statistics.chart.boxplot;

import com.orion.core.abstraction.Orion;
import com.orion.math.statistics.data.fivenumbersummary.FiveNumberSummary;

public class BoxplotChart extends Orion
{
    private FiveNumberSummary fiveNumberSummary;


    public BoxplotChart(FiveNumberSummary fiveNumberSummary)
    {
        BoxplotChartRules.isValid(fiveNumberSummary);
        this.fiveNumberSummary = fiveNumberSummary;
    }


    public static BoxplotChart of(FiveNumberSummary fiveNumberSummary)
    {
        return new BoxplotChart(fiveNumberSummary);
    }


    public FiveNumberSummary getFiveNumberSummary()
    {
        return this.fiveNumberSummary;
    }
}