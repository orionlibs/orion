package com.orion.math.statistics.chart.sidebyside;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import java.util.List;
import java.util.Map;

public class SideBySideChart extends Orion
{
    private Map<String, List<Map.Entry<StatisticalClass, ANumber>>> perspectiveAndClassValuesMapper;


    public SideBySideChart(Map<String, List<Map.Entry<StatisticalClass, ANumber>>> perspectiveAndClassValuesMapper)
    {
        SideBySideChartRules.isValid(perspectiveAndClassValuesMapper);
        this.perspectiveAndClassValuesMapper = perspectiveAndClassValuesMapper;
    }


    public static SideBySideChart of(Map<String, List<Map.Entry<StatisticalClass, ANumber>>> perspectiveAndClassValuesMapper)
    {
        return new SideBySideChart(perspectiveAndClassValuesMapper);
    }


    public Map<String, List<Map.Entry<StatisticalClass, ANumber>>> getPerspectiveAndClassValuesMapper()
    {
        return this.perspectiveAndClassValuesMapper;
    }
}