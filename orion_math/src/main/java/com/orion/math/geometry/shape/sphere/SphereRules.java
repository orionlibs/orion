package com.orion.math.geometry.shape.sphere;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;

public class SphereRules extends MathRule
{
    public static void isValid(Point center, ANumber radius)
    {
        PointRules.isValid(center);
        PointRules.doDimensionsMatch(3, center);
        Assert.isFalse(Numbers.isNonPositive(radius), "Sphere is invalid, because the radius is not positive.");
    }


    public static void isValid(Sphere sphere)
    {
        Assert.notNull(sphere, "The sphere input cannot be null.");
        isValid(sphere.getCenter(), sphere.getRadius());
    }
}