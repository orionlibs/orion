package com.orion.math.statistics.chart.timeseriesplot.years;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;
import java.util.Map;

public class TimeseriesPlotInYearsRules extends MathRule
{
    public static void isValid(Map<ANumber, Integer> valuesAndYearsMapper, int startYear, int endYear, int timeStepInYearsForChart)
    {
        Assert.notEmpty(valuesAndYearsMapper, "The valuesAndYearsMapper input cannot be null/empty.");
        Assert.isFalse(Numbers.hasNotNaturalNumberValue(startYear), "startYear should be a natural number.");
        Assert.isFalse(Numbers.hasNotNaturalNumberValue(endYear), "endYear should be a natural number.");
        Assert.isLessThanOrEqualTo(startYear, endYear, "startYear should not be greater than the endYear.");
        Assert.isFalse(Numbers.hasNotNaturalNumberValue(timeStepInYearsForChart), "timeStepInYearsForChart should be a natural number.");
        Assert.isFalse(Numbers.isNonPositive(timeStepInYearsForChart), "timeStepInYearsForChart should be a natural number.");
        Assert.isLessThanOrEqualTo(timeStepInYearsForChart, (endYear - startYear), "timeStepInYearsForChart should be <= (endYear - startYear).");
    }


    public static void isValid(TimeseriesPlotInYears timeseriesPlotInYears)
    {
        Assert.notNull(timeseriesPlotInYears, "The timeseriesPlotInYears input cannot be null.");
        isValid(timeseriesPlotInYears.getValuesAndYearsMapper(), timeseriesPlotInYears.getStartYear(), timeseriesPlotInYears.getEndYear(), timeseriesPlotInYears.getTimeStepInYearsForChart());
    }
}