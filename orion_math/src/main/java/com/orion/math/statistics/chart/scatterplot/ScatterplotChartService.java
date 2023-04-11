package com.orion.math.statistics.chart.scatterplot;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.statistics.chart.scatterplot.tasks.CalculateRegressionLineSegmentFroScatterplotChartTask;

public class ScatterplotChartService extends OrionService
{
    public static LineSegment calculateRegressionLineSegment(ScatterplotChart scatterplotChart)
    {
        return CalculateRegressionLineSegmentFroScatterplotChartTask.run(scatterplotChart);
    }
}