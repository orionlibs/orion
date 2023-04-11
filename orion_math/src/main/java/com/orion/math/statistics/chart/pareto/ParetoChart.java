package com.orion.math.statistics.chart.pareto;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import java.util.List;
import java.util.Map;

public class ParetoChart extends Orion
{
    private List<Map.Entry<StatisticalClass, ANumber>> classValues;
    private List<ANumber> classCumulativeValues;


    public ParetoChart(List<Map.Entry<StatisticalClass, ANumber>> classValues, List<ANumber> classCumulativeValues)
    {
        ParetoChartRules.isValid(classValues, classCumulativeValues);
        this.classValues = classValues;
        this.classCumulativeValues = classCumulativeValues;
    }


    public static ParetoChart of(List<Map.Entry<StatisticalClass, ANumber>> classValues, List<ANumber> classCumulativeValues)
    {
        return new ParetoChart(classValues, classCumulativeValues);
    }


    public List<Map.Entry<StatisticalClass, ANumber>> getClassValues()
    {
        return this.classValues;
    }


    public List<ANumber> getClassCumulativeValues()
    {
        return this.classCumulativeValues;
    }
}