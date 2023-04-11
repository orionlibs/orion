package com.orion.math.statistics.chart.scatterplot;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import java.util.List;

public class ScatterplotChartRules extends MathRule
{
    public static void isValid(List<ANumber> valuesForXAxis, List<ANumber> valuesForYAxis)
    {
        Assert.notEmpty(valuesForXAxis, "The pieChart input cannot be null/empty.");
        Assert.notEmpty(valuesForYAxis, "The pieChart input cannot be null/empty.");
        Assert.areEqual(valuesForXAxis.size(), valuesForYAxis.size(), "valuesForXAxis size does not match size of valuesForYAxis.");
    }


    public static void isValid(ScatterplotChart scatterplotChart)
    {
        Assert.notNull(scatterplotChart, "The scatterplotChart input cannot be null.");
        isValid(scatterplotChart.getValuesForXAxis(), scatterplotChart.getValuesForYAxis());
    }
}