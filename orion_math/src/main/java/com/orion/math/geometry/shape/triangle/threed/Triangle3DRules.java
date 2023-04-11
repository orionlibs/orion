package com.orion.math.geometry.shape.triangle.threed;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.point.PointService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class Triangle3DRules extends MathRule
{
    public static void isValid(ANumber lengthOfA, ANumber lengthOfB, ANumber lengthOfC)
    {
        Assert.isFalse(lengthOfA.addGET(lengthOfB).isLessThanOrEqual(lengthOfC)
                        || lengthOfA.addGET(lengthOfC).isLessThanOrEqual(lengthOfB)
                        || lengthOfB.addGET(lengthOfC).isLessThanOrEqual(lengthOfA), "Triangle3D is invalid, because the lengths have the wrong magnitudes.");
    }


    public static void isValid(ANumber area, ANumber hypotenuse)
    {
        NumberRules.areAllPositive(Arrays.asList(area, hypotenuse));
    }


    public static void isValid(Point pointA, Point pointB, Point pointC)
    {
        PointRules.areValid(pointA, pointB, pointC);
        Assert.isFalse(PointService.areCollinear(pointA, pointB, pointC), "Triangle3D is invalid, because the points are collinear.");
    }


    public static void isValid(Triangle3D triangle3D)
    {
        Assert.notNull(triangle3D, "The triangle3D input cannot be null.");
        isValid(triangle3D.getLengthOfA(), triangle3D.getLengthOfB(), triangle3D.getLengthOfC());
        isValid(triangle3D.getPointC(), triangle3D.getPointB(), triangle3D.getPointC());
    }


    public static void areValid(Triangle3D... triangles)
    {
        Assert.notEmpty(triangles, "The triangles input cannot be null/empty.");
        Arrays.stream(triangles).forEach(t -> isValid(t));
    }
}