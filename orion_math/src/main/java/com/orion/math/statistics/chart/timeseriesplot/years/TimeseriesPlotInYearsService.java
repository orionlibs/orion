package com.orion.math.statistics.chart.timeseriesplot.years;

import com.orion.core.abstraction.OrionService;
import com.orion.math.statistics.chart.timeseriesplot.years.tasks.CalculateYearsToPlotInTimeSeriesPlotTask;
import java.util.List;

public class TimeseriesPlotInYearsService extends OrionService
{
    public static List<Integer> calculateYearsToPlot(TimeseriesPlotInYears timeseriesPlotInYears)
    {
        return CalculateYearsToPlotInTimeSeriesPlotTask.run(timeseriesPlotInYears);
    }
}