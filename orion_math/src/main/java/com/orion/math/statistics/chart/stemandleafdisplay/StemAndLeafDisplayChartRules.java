package com.orion.math.statistics.chart.stemandleafdisplay;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;

public class StemAndLeafDisplayChartRules extends MathRule
{
    public static void isValid(Vector values)
    {
        VectorRules.isValid(values);
    }


    public static void isValid(StemAndLeafDisplayChart stemAndLeafDisplayChart)
    {
        Assert.notNull(stemAndLeafDisplayChart, "The stemAndLeafDisplayChart input cannot be null.");
        isValid(stemAndLeafDisplayChart.getValues());
    }
}