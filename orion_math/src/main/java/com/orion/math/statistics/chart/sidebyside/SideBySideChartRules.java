package com.orion.math.statistics.chart.sidebyside;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import java.util.List;
import java.util.Map;

public class SideBySideChartRules extends MathRule
{
    public static void isValid(Map<String, List<Map.Entry<StatisticalClass, ANumber>>> perspectiveAndClassValuesMapper)
    {
        Assert.notEmpty(perspectiveAndClassValuesMapper, "The perspectiveAndClassValuesMapper input cannot be null/empty.");
        perspectiveAndClassValuesMapper.values().forEach(v -> isValid(v));
    }


    public static void isValid(List<Map.Entry<StatisticalClass, ANumber>> classValues)
    {
        Assert.notEmpty(classValues, "The classValues input cannot be null/empty.");
    }


    public static void isValid(SideBySideChart sideBySideChart)
    {
        Assert.notNull(sideBySideChart, "The sideBySideChart input cannot be null.");
        isValid(sideBySideChart.getPerspectiveAndClassValuesMapper());
    }
}