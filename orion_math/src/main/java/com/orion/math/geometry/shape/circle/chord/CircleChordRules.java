package com.orion.math.geometry.shape.circle.chord;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.circle.CircleRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class CircleChordRules extends MathRule
{
    public static void isValid(Point center, ANumber radius, Point startPoint, Point endPoint)
    {
        CircleRules.isValid(center, radius);
        PointRules.isValid(startPoint);
        Circle circle = Circle.of(center, radius);
        Assert.isTrue(circle.isPointOnCircle(startPoint), "Circle chord is invalid, because start point is not on the circle.");
        PointRules.isValid(endPoint);
        Assert.isTrue(circle.isPointOnCircle(startPoint), "Circle chord is invalid, because end point is not on the circle.");
    }


    public static void isValid(Point center, ANumber radius, Point startPoint, ANumber angleInRadians)
    {
        CircleRules.isValid(center, radius);
        PointRules.isValid(startPoint);
        Circle circle = Circle.of(center, radius);
        Assert.isTrue(circle.isPointOnCircle(startPoint), "Circle chord is invalid, because start point is not on the circle.");
        NumberRules.isNotNull(angleInRadians);
    }


    public static void isValid(CircleChord circleChord)
    {
        Assert.notNull(circleChord, "The circleChord input cannot be null.");
        isValid(circleChord.getCenter(), circleChord.getRadius(), circleChord.getStartPoint(), circleChord.getEndPoint());
    }
}