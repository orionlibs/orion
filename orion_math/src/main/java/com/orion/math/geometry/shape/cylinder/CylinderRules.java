package com.orion.math.geometry.shape.cylinder;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class CylinderRules extends MathRule
{
    public static void isValid(ANumber radius, ANumber height)
    {
        NumberRules.isPositive(radius);
        NumberRules.isPositive(height);
    }


    public static void isValid(Cylinder cylinder)
    {
        Assert.notNull(cylinder, "The cylinder input cannot be null.");
        isValid(cylinder.getRadius(), cylinder.getHeight());
    }
}