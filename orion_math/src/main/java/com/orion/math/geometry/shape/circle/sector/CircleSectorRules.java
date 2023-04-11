package com.orion.math.geometry.shape.circle.sector;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.circle.CircleRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class CircleSectorRules extends MathRule
{
    public static void isValid(Point center, ANumber radius, Point startPoint, Point endPoint, ANumber angleInRadians)
    {
        CircleRules.isValid(center, radius);
        PointRules.isValid(startPoint);
        Circle circle = Circle.of(center, radius);
        Assert.isFalse(circle.isPointNotOnCircle(startPoint), "Circle sector is invalid, because start point is not on the circle.");
        PointRules.isValid(endPoint);
        Assert.isFalse(circle.isPointNotOnCircle(endPoint), "Circle sector is invalid, because end point is not on the circle.");
        NumberRules.isNotNull(angleInRadians);
    }


    public static void isValid(Point center, ANumber radius, Point startPoint, Point endPoint)
    {
        CircleRules.isValid(center, radius);
        PointRules.isValid(startPoint);
        Circle circle = Circle.of(center, radius);
        Assert.isFalse(circle.isPointNotOnCircle(startPoint), "Circle sector is invalid, because start point is not on the circle.");
        PointRules.isValid(endPoint);
        Assert.isFalse(circle.isPointNotOnCircle(endPoint), "Circle sector is invalid, because end point is not on the circle.");
    }


    public static void isValid(Point center, ANumber radius, Point startPoint, ANumber angleInRadians)
    {
        CircleRules.isValid(center, radius);
        PointRules.isValid(startPoint);
        Circle circle = Circle.of(center, radius);
        Assert.isFalse(circle.isPointNotOnCircle(startPoint), "Circle sector is invalid, because start point is not on the circle.");
        NumberRules.isNotNull(angleInRadians);
    }


    public static void isValid(CircleSector circleSector)
    {
        Assert.notNull(circleSector, "The circleSector input cannot be null.");
        isValid(circleSector.getCenter(), circleSector.getRadius(), circleSector.getStartPoint(), circleSector.getEndPoint(), circleSector.getAngleInRadians());
    }


    public static void isValidIgnoringEndPoint(CircleSector circleSector)
    {
        Assert.notNull(circleSector, "The circleSector input cannot be null.");
        isValid(circleSector.getCenter(), circleSector.getRadius(), circleSector.getStartPoint(), circleSector.getAngleInRadians());
    }
}