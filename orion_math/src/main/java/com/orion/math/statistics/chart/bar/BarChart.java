package com.orion.math.statistics.chart.bar;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import java.util.List;
import java.util.Map;

public class BarChart extends Orion
{
    private List<Map.Entry<StatisticalClass, ANumber>> classValues;


    public BarChart(List<Map.Entry<StatisticalClass, ANumber>> classValues)
    {
        BarChartRules.isValid(classValues);
        this.classValues = classValues;
    }


    public static BarChart of(List<Map.Entry<StatisticalClass, ANumber>> classValues)
    {
        return new BarChart(classValues);
    }


    public List<Map.Entry<StatisticalClass, ANumber>> getClassValues()
    {
        return this.classValues;
    }
}