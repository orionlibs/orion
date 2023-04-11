package com.orion.math.geometry.shape.circle;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.constant.Constants;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.point.polar.PolarPoint;
import com.orion.math.geometry.point.polar.PolarPointRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;
import java.util.Arrays;

public class CircleRules extends MathRule
{
    public static void isPointOnCircle(Circle circle, Point point)
    {
        isValid(circle);
        PointRules.isValid(point);
        Assert.isFalse(circle.isPointNotOnCircle(point), "Point is not on the circle.");
    }


    public static void isValid(Point center, ANumber radius)
    {
        PointRules.isValid(center);
        PointRules.doDimensionsMatch(2, center);
        Assert.isFalse(Numbers.isNonPositive(radius), "Circle is invalid, because the radius is not positive.");
    }


    public static void isValid(PolarPoint centerPolar, ANumber angleWithXAxis, ANumber radius)
    {
        PolarPointRules.isValid(centerPolar);
        isValid(centerPolar.getAsPoint(), radius);
        Assert.isFalse(Numbers.isNotBetween(angleWithXAxis, 0, Constants.twoPI), "Circle is invalid, because the angle with the X axis is not between 0 and 2PI.");
    }


    public static void isValid(Point diameterStartPoint, Point diameterEndPoint)
    {
        PointRules.areValid(diameterStartPoint, diameterEndPoint);
        PointRules.doDimensionsMatch(2, diameterStartPoint, diameterEndPoint);
    }


    public static void isValid(Point point1, Point point2, Point point3)
    {
        PointRules.areNotCollinear(point1, point2, point3);
    }


    public static void isValid(Circle circle)
    {
        Assert.notNull(circle, "The circle input cannot be null.");
        isValid(circle.getCenter(), circle.getRadius());
    }


    public static void areValid(Circle... circles)
    {
        Assert.notEmpty(circles, "The circles input cannot be null/empty.");
        Arrays.stream(circles).forEach(c -> isValid(c));
    }
}