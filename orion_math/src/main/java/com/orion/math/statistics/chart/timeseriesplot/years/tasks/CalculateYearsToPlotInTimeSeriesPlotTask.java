package com.orion.math.statistics.chart.timeseriesplot.years.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.statistics.chart.timeseriesplot.years.TimeseriesPlotInYears;
import java.util.ArrayList;
import java.util.List;

public class CalculateYearsToPlotInTimeSeriesPlotTask extends Orion
{
    public static List<Integer> run(TimeseriesPlotInYears timeseriesPlotInYears)
    {
        List<Integer> temp = new ArrayList<Integer>();
        int startYear = timeseriesPlotInYears.getStartYear();
        int endYear = timeseriesPlotInYears.getEndYear();
        int timeStepInYearsForChart = timeseriesPlotInYears.getTimeStepInYearsForChart();
        temp.add(startYear);
        int tempYear = startYear;

        for(int i = 0; i < (endYear - startYear) / timeStepInYearsForChart; i++)
        {

            if(tempYear + timeStepInYearsForChart > endYear)
            {
                temp.add(endYear);
                break;
            }
            else
            {
                temp.add(tempYear + timeStepInYearsForChart);
                tempYear += timeStepInYearsForChart;
            }

        }

        return temp;
    }
}