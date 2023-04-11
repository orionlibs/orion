package com.orion.math.statistics.chart.timeseriesplot;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import java.util.List;
import java.util.Map;

public class TimeseriesPlotChart extends Orion
{
    private Map<ANumber, String> valuesAndTimeMapper;
    private List<String> timeValuesToPlot;


    public TimeseriesPlotChart(Map<ANumber, String> valuesAndTimeMapper, List<String> timeValuesToPlot)
    {
        TimeseriesPlotChartRules.isValid(valuesAndTimeMapper, timeValuesToPlot);
        this.valuesAndTimeMapper = valuesAndTimeMapper;
        this.timeValuesToPlot = timeValuesToPlot;
    }


    public static TimeseriesPlotChart of(Map<ANumber, String> valuesAndTimeMapper, List<String> timeValuesToPlot)
    {
        return new TimeseriesPlotChart(valuesAndTimeMapper, timeValuesToPlot);
    }


    public Map<ANumber, String> getValuesAndTimeMapper()
    {
        return this.valuesAndTimeMapper;
    }


    public List<String> getTimeValuesToPlot()
    {
        return this.timeValuesToPlot;
    }
}