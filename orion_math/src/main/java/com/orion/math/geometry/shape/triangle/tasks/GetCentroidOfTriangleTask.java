package com.orion.math.geometry.shape.triangle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.triangle.Triangle;
import com.orion.math.geometry.shape.triangle.TriangleRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.average.function.ArithmeticAverageFunction;
import java.util.Arrays;

public class GetCentroidOfTriangleTask extends Orion
{
    public static Point run(Triangle x)
    {
        TriangleRules.isValid(x);
        ANumber newX = ArithmeticAverageFunction.run(Arrays.asList(x.getPointA().getX(), x.getPointB().getX(), x.getPointC().getX()));
        ANumber newY = ArithmeticAverageFunction.run(Arrays.asList(x.getPointA().getY(), x.getPointB().getY(), x.getPointC().getY()));
        return Point.of(newX, newY);
    }
}