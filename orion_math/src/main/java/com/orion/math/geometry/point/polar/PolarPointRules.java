package com.orion.math.geometry.point.polar;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;

public class PolarPointRules extends MathRule
{
    public static void isValid(PolarPoint point)
    {
        Assert.notNull(point, "Point with polar coordinates is null.");
        isValid(point.getDistanceFromPointOfOrigin(), point.getAngleWithXAxis());
    }


    public static void isValid(ANumber length, ANumber angle)
    {
        Assert.isFalse(Numbers.areNull(length, angle), "Point with polar coordinates has null coordinates.");
    }


    public static void isValidDimensionsForPolarCoordinates(int dimensions)
    {
        Assert.isFalse(dimensions != 2, "Point has to have 2 dimensions to be converted to polar coordinates.");
    }
}