package com.orion.math.statistics.chart.stemandleafdisplay;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import java.util.List;
import java.util.Map;

public class StemAndLeafDisplayChart extends Orion
{
    private Vector values;
    private Map<ANumber, List<ANumber>> stems;


    public StemAndLeafDisplayChart(Vector values)
    {
        StemAndLeafDisplayChartRules.isValid(values);
        this.values = values.sortGET();
        this.stems = StemAndLeafDisplayChartService.calculateStems(values);
    }


    public static StemAndLeafDisplayChart of(Vector values)
    {
        return new StemAndLeafDisplayChart(values);
    }


    public Vector getValues()
    {
        return this.values;
    }


    public Map<ANumber, List<ANumber>> getStems()
    {
        return this.stems;
    }
}