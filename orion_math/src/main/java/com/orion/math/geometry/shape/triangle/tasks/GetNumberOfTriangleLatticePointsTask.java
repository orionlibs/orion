package com.orion.math.geometry.shape.triangle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.triangle.Triangle;
import com.orion.math.geometry.shape.triangle.TriangleRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.util.HashSet;
import java.util.Set;

public class GetNumberOfTriangleLatticePointsTask extends Orion
{
    public static ANumber run(Triangle x)
    {
        TriangleRules.isValid(x);
        ANumber count = ANumber.of(0);
        ANumber[] xOrdinates = new ANumber[]
        {x.getPointA().getX(), x.getPointB().getX(), x.getPointC().getX()};
        ANumber[] yAbscissas = new ANumber[]
        {x.getPointA().getY(), x.getPointB().getY(), x.getPointC().getY()};
        ANumber mininumX = ArithmeticService.getMinimum(xOrdinates).getFloor();
        ANumber maxinumX = ArithmeticService.getMaximum(xOrdinates).getFloor();
        ANumber mininumY = ArithmeticService.getMinimum(yAbscissas).getFloor();
        ANumber maxinumY = ArithmeticService.getMaximum(yAbscissas).getFloor();
        Set<Point> pointsToConsider = new HashSet<>();

        for(int i = mininumX.getAsInt(); i <= maxinumX.getAsInt(); i++)
        {

            for(int j = mininumY.getAsInt(); j <= maxinumY.getAsInt(); j++)
            {
                Point point = Point.of(i, j);

                if(!pointsToConsider.contains(point) && x.isPointInsideOrOnTriangle(point))
                {
                    pointsToConsider.add(point);
                    count.addOne();
                }

            }

        }

        return count;
    }
}