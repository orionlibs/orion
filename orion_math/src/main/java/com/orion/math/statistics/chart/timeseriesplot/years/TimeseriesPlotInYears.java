package com.orion.math.statistics.chart.timeseriesplot.years;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import java.util.List;
import java.util.Map;

public class TimeseriesPlotInYears extends Orion
{
    private Map<ANumber, Integer> valuesAndYearsMapper;
    private int startYear;
    private int endYear;
    private int timeStepInYearsForChart;
    private List<Integer> yearsToPlot;


    public TimeseriesPlotInYears(Map<ANumber, Integer> valuesAndYearsMapper, int startYear, int endYear, int timeStepInYearsForChart)
    {
        TimeseriesPlotInYearsRules.isValid(valuesAndYearsMapper, startYear, endYear, timeStepInYearsForChart);
        this.valuesAndYearsMapper = valuesAndYearsMapper;
        this.startYear = startYear;
        this.endYear = endYear;
        this.timeStepInYearsForChart = timeStepInYearsForChart;
        this.yearsToPlot = TimeseriesPlotInYearsService.calculateYearsToPlot(this);
    }


    public static TimeseriesPlotInYears of(Map<ANumber, Integer> valuesAndYearsMapper, int startYear, int endYear, int timeStepInYearsForChart)
    {
        return new TimeseriesPlotInYears(valuesAndYearsMapper, startYear, endYear, timeStepInYearsForChart);
    }


    public Map<ANumber, Integer> getValuesAndYearsMapper()
    {
        return this.valuesAndYearsMapper;
    }


    public int getStartYear()
    {
        return this.startYear;
    }


    public int getEndYear()
    {
        return this.endYear;
    }


    public int getTimeStepInYearsForChart()
    {
        return this.timeStepInYearsForChart;
    }


    public List<Integer> getYearsToPlot()
    {
        return this.yearsToPlot;
    }
}