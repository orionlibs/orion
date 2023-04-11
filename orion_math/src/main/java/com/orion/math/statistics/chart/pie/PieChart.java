package com.orion.math.statistics.chart.pie;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import java.util.List;
import java.util.Map;

public class PieChart extends Orion
{
    private List<Map.Entry<StatisticalClass, ANumber>> classValues;


    public PieChart(List<Map.Entry<StatisticalClass, ANumber>> classValues)
    {
        PieChartRules.isValid(classValues);
        this.classValues = classValues;
    }


    public static PieChart of(List<Map.Entry<StatisticalClass, ANumber>> classValues)
    {
        return new PieChart(classValues);
    }


    public List<Map.Entry<StatisticalClass, ANumber>> getClassValues()
    {
        return this.classValues;
    }
}