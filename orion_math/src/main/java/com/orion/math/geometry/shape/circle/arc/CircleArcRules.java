package com.orion.math.geometry.shape.circle.arc;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.circle.CircleRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class CircleArcRules extends MathRule
{
    public static void isValid(Point center, ANumber radius, Point startPoint, Point endPoint, ANumber angleInRadians)
    {
        CircleRules.isValid(center, radius);
        PointRules.isValid(startPoint);
        Circle circle = Circle.of(center, radius);
        Assert.isTrue(circle.isPointOnCircle(startPoint), "Circle arc is invalid, because start point is not on the circle.");
        PointRules.isValid(endPoint);
        Assert.isTrue(circle.isPointOnCircle(endPoint), "Circle arc is invalid, because end point is not on the circle.");
        NumberRules.isNotNull(angleInRadians);
    }


    public static void isValid(Point center, ANumber radius, Point startPoint, Point endPoint)
    {
        CircleRules.isValid(center, radius);
        PointRules.isValid(startPoint);
        Circle circle = Circle.of(center, radius);
        Assert.isTrue(circle.isPointOnCircle(startPoint), "Circle arc is invalid, because start point is not on the circle.");
        PointRules.isValid(endPoint);
        Assert.isTrue(circle.isPointOnCircle(endPoint), "Circle arc is invalid, because end point is not on the circle.");
    }


    public static void isValid(Point center, ANumber radius, Point startPoint, ANumber angleInRadians)
    {
        CircleRules.isValid(center, radius);
        PointRules.isValid(startPoint);
        Circle circle = Circle.of(center, radius);
        Assert.isTrue(circle.isPointOnCircle(startPoint), "Circle arc is invalid, because start point is not on the circle.");
        NumberRules.isNotNull(angleInRadians);
    }


    public static void isValid(CircleArc circleArc)
    {
        Assert.notNull(circleArc, "The circleArc input cannot be null.");
        isValid(circleArc.getCenter(), circleArc.getRadius(), circleArc.getStartPoint(), circleArc.getEndPoint(), circleArc.getAngleInRadians());
    }


    public static void isValidIgnoringEndPoint(CircleArc circleArc)
    {
        Assert.notNull(circleArc, "The circleArc input cannot be null.");
        isValid(circleArc.getCenter(), circleArc.getRadius(), circleArc.getStartPoint(), circleArc.getAngleInRadians());
    }
}