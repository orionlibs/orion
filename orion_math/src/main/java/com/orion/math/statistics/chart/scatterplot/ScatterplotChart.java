package com.orion.math.statistics.chart.scatterplot;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.number.ANumber;
import java.util.List;

public class ScatterplotChart extends Orion
{
    private List<ANumber> valuesForXAxis;
    private List<ANumber> valuesForYAxis;
    private LineSegment regressionLineSegment;


    public ScatterplotChart(List<ANumber> valuesForXAxis, List<ANumber> valuesForYAxis)
    {
        ScatterplotChartRules.isValid(valuesForXAxis, valuesForYAxis);
        this.valuesForXAxis = valuesForXAxis;
        this.valuesForYAxis = valuesForYAxis;
        this.regressionLineSegment = ScatterplotChartService.calculateRegressionLineSegment(this);
    }


    public static ScatterplotChart of(List<ANumber> valuesForXAxis, List<ANumber> valuesForYAxis)
    {
        return new ScatterplotChart(valuesForXAxis, valuesForYAxis);
    }


    public List<ANumber> getValuesForXAxis()
    {
        return this.valuesForXAxis;
    }


    public List<ANumber> getValuesForYAxis()
    {
        return this.valuesForYAxis;
    }


    public LineSegment getRegressionLineSegment()
    {
        return this.regressionLineSegment;
    }
}