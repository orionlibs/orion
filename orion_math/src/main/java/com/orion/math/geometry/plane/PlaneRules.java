package com.orion.math.geometry.plane;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class PlaneRules extends MathRule
{
    public static void doesPointHave3Dimensions(Point point)
    {
        PointRules.isValid(point);
        Assert.isFalse(point.getDimensions() != 3, "Point dimensions have to be 3.");
    }


    public static void isValid(Point point1, Point point2, Point point3)
    {
        PointRules.doDimensionsMatch(3, point1, point2, point3);
    }


    public static void isValid(Plane plane)
    {
        Assert.notNull(plane, "The plane input cannot be null.");
        NumberRules.isNotNull(plane.getA());
        NumberRules.isNotNull(plane.getB());
        NumberRules.isNotNull(plane.getC());
        NumberRules.isNotNull(plane.getD());
    }


    public static void areValid(Plane... planes)
    {
        Assert.notEmpty(planes, "The plane input cannot be null/empty.");
        Arrays.stream(planes).forEach(plane -> isValid(plane));
    }


    public static void areParallel(Plane plane1, Plane plane2)
    {
        areValid(plane1, plane2);
        Assert.isFalse(plane1.isNotParallelTo(plane2), "Planes are not parallel.");
    }
}