package com.orion.math.geometry.plane.tasks.distance;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.plane.Plane;
import com.orion.math.geometry.plane.PlaneRules;
import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.util.Arrays;

public class GetDistanceBetweenPointAndPlaneTask extends Orion
{
    public static ANumber run(Plane plane, Point point, int squareRootPrecision)
    {
        PlaneRules.isValid(plane);
        PlaneRules.doesPointHave3Dimensions(point);
        ANumber result = plane.getFormula().run(point.getX(), point.getY(), point.getZ());
        ANumber sumOfSquares = ArithmeticService.getSumOfSquares(Arrays.asList(plane.getA(), plane.getB(), plane.getC()));
        return result.getAbsoluteValue().divideGET(sumOfSquares.getSquareRoot(squareRootPrecision));
    }
}