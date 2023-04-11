package com.orion.math.geometry.point.tasks.relocation;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.plane.Plane;
import com.orion.math.geometry.plane.PlaneRules;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.util.Arrays;

public class ReflectPointAboutAPlaneTask extends Orion
{
    public static Point run(Point point, Plane plane)
    {
        PointRules.isValid(point);
        PlaneRules.isValid(plane);
        ANumber sumOfSquares = ArithmeticService.getSumOfSquares(Arrays.asList(plane.getA(), plane.getB(), plane.getC()));
        ANumber k = plane.getA().negateGET().multiplyGET(point.getX());
        k.subtract(plane.getB().multiplyGET(point.getY()));
        k.subtract(plane.getC().multiplyGET(point.getZ()));
        k.subtract(plane.getD());
        k.divide(sumOfSquares);
        ANumber twoX2 = plane.getA().multiplyGET(k).addGET(point.getX()).doubleGET();
        ANumber twoY2 = plane.getB().multiplyGET(k).addGET(point.getY()).doubleGET();
        ANumber twoZ2 = plane.getC().multiplyGET(k).addGET(point.getZ()).doubleGET();
        ANumber x3 = twoX2.subtractGET(point.getX());
        ANumber y3 = twoY2.subtractGET(point.getY());
        ANumber z3 = twoZ2.subtractGET(point.getZ());
        return Point.of(x3, y3, z3);
    }
}