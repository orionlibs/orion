package com.orion.math.statistics.chart.histogram;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import java.util.List;
import java.util.Map;

public class HistogramChart extends Orion
{
    private List<Map.Entry<StatisticalClass, ANumber>> classValues;


    public HistogramChart(List<Map.Entry<StatisticalClass, ANumber>> classValues)
    {
        HistogramChartRules.isValid(classValues);
        this.classValues = classValues;
    }


    public static HistogramChart of(List<Map.Entry<StatisticalClass, ANumber>> classValues)
    {
        return new HistogramChart(classValues);
    }


    public List<Map.Entry<StatisticalClass, ANumber>> getClassValues()
    {
        return this.classValues;
    }
}