package com.orion.math.statistics.chart.timeseriesplot;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import java.util.List;
import java.util.Map;

public class TimeseriesPlotChartRules extends MathRule
{
    public static void isValid(Map<ANumber, String> valuesAndTimeMapper, List<String> timeValuesToPlot)
    {
        Assert.notEmpty(valuesAndTimeMapper, "The valuesAndTimeMapper input cannot be null/empty.");
        Assert.notEmpty(timeValuesToPlot, "The timeValuesToPlot input cannot be null/empty.");
    }


    public static void isValid(TimeseriesPlotChart timeseriesPlotChart)
    {
        Assert.notNull(timeseriesPlotChart, "The timeseriesPlotChart input cannot be null.");
        isValid(timeseriesPlotChart.getValuesAndTimeMapper(), timeseriesPlotChart.getTimeValuesToPlot());
    }
}