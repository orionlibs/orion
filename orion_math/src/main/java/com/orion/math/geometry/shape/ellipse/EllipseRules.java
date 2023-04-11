package com.orion.math.geometry.shape.ellipse;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;

public class EllipseRules extends MathRule
{
    public static void isValid(Point focalPoint1, Point focalPoint2, ANumber radiusOfMinorAxis, ANumber radiusOfMajorAxis)
    {
        PointRules.areValid(focalPoint1, focalPoint2);
        PointRules.doDimensionsMatch(2, focalPoint1, focalPoint2);
        Assert.isFalse(focalPoint1.equals(focalPoint2), "The focal points are the same which creates a circle.");
        Assert.isFalse(Numbers.isNonPositive(radiusOfMinorAxis), "Ellipse is invalid, because the radius is not positive.");
        Assert.isFalse(Numbers.isNonPositive(radiusOfMajorAxis), "Ellipse is invalid, because the radius is not positive.");
        Assert.isFalse(radiusOfMinorAxis.isGreaterThanOrEqual(radiusOfMajorAxis), "Ellipse is invalid, because the minor radius is not less than the radius of the major axis.");
    }


    public static void isValid(Point center, ANumber a, ANumber b)
    {
        PointRules.isValid(center);
        NumberRules.areNotNull(a, b);
        Assert.isFalse(a.equals(b) && a.isOne(), "a = b creates a circle.");
    }


    public static void isValid(Ellipse ellipse)
    {
        Assert.notNull(ellipse, "The ellipse input cannot be null.");
        isValid(ellipse.getFocalPoint1(), ellipse.getFocalPoint2(), ellipse.getRadiusOfMinorAxis(), ellipse.getRadiusOfMajorAxis());
    }
}