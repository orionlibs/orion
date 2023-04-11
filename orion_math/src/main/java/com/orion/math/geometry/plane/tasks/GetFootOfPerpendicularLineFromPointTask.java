package com.orion.math.geometry.plane.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.plane.Plane;
import com.orion.math.geometry.plane.PlaneRules;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.util.Arrays;

public class GetFootOfPerpendicularLineFromPointTask extends Orion
{
    public static Point run(Plane x, Point point)
    {
        PlaneRules.isValid(x);
        PointRules.isValid(point);
        ANumber sumOfSquares = ArithmeticService.getSumOfSquares(Arrays.asList(x.getA(), x.getB(), x.getC()));
        ANumber k = x.getA().negateGET().multiplyGET(point.getX());
        k = k.subtractGET(x.getB().multiplyGET(point.getY()));
        k = k.subtractGET(x.getC().multiplyGET(point.getZ())).subtractGET(x.getD());
        k.divide(sumOfSquares);
        ANumber x2 = x.getA().multiplyGET(k).addGET(point.getX());
        ANumber y2 = x.getB().multiplyGET(k).addGET(point.getY());
        ANumber z2 = x.getC().multiplyGET(k).addGET(point.getZ());
        return Point.of(x2, y2, z2);
    }
}