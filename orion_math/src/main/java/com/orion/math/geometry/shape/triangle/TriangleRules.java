package com.orion.math.geometry.shape.triangle;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.point.PointService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class TriangleRules extends MathRule
{
    public static void isValid(ANumber lengthOfA, ANumber lengthOfB, ANumber lengthOfC)
    {
        Assert.isFalse(lengthOfA.addGET(lengthOfB).isLessThanOrEqual(lengthOfC)
                        || lengthOfA.addGET(lengthOfC).isLessThanOrEqual(lengthOfB)
                        || lengthOfB.addGET(lengthOfC).isLessThanOrEqual(lengthOfA), "Triangle is invalid, because the lengths have the wrong magnitudes.");
    }


    public static void isValid(ANumber area, ANumber hypotenuse)
    {
        NumberRules.areAllPositive(Arrays.asList(area, hypotenuse));
    }


    public static void isValid(Point pointA, Point pointB, Point pointC)
    {
        PointRules.areValid(pointA, pointB, pointC);
        Assert.isFalse(PointService.areCollinear(pointA, pointB, pointC), "Triangle is invalid, because the points are collinear.");
    }


    public static void isValid(Triangle triangle)
    {
        Assert.notNull(triangle, "The triangle input cannot be null.");
        isValid(triangle.getLengthOfA(), triangle.getLengthOfB(), triangle.getLengthOfC());
        isValid(triangle.getPointA(), triangle.getPointB(), triangle.getPointC());
    }


    public static void isValidIgnoringPoints(Triangle triangle)
    {
        Assert.notNull(triangle, "The triangle input cannot be null.");
        isValid(triangle.getLengthOfA(), triangle.getLengthOfB(), triangle.getLengthOfC());
    }


    public static void areValid(Triangle... triangles)
    {
        Assert.notEmpty(triangles, "The triangles input cannot be null/empty.");
        Arrays.stream(triangles).forEach(t -> isValid(t));
    }
}