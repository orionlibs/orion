package com.orion.math.statistics.classes.aclass;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class StatisticalClassRules extends MathRule
{
    public static void isValid(Vector values, ANumber classIntervalWidth)
    {
        VectorRules.isValid(values);
        NumberRules.isPositive(classIntervalWidth);
    }


    public static void isValid(StatisticalClass statisticalClass)
    {
        Assert.notNull(statisticalClass, "The statisticalClass input cannot be null.");
        isValid(statisticalClass.getValues(), statisticalClass.getClassIntervalWidth());
    }
}