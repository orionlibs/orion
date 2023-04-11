package com.orion.math.statistics.chart.scatterplot.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.statistics.chart.scatterplot.ScatterplotChart;

public class CalculateRegressionLineSegmentFroScatterplotChartTask extends Orion
{
    public static LineSegment run(ScatterplotChart scatterplotChart)
    {
        int indexOfMinimumX = scatterplotChart.getValuesForXAxis().indexOf(ArithmeticService.getMinimum(scatterplotChart.getValuesForXAxis()));
        int indexOfMaximumX = scatterplotChart.getValuesForXAxis().indexOf(ArithmeticService.getMaximum(scatterplotChart.getValuesForXAxis()));
        Point startPoint = Point.of(scatterplotChart.getValuesForXAxis().get(indexOfMinimumX), scatterplotChart.getValuesForYAxis().get(indexOfMinimumX));
        Point endPoint = Point.of(scatterplotChart.getValuesForXAxis().get(indexOfMaximumX), scatterplotChart.getValuesForYAxis().get(indexOfMaximumX));
        return LineSegment.of(startPoint, endPoint);
    }
}