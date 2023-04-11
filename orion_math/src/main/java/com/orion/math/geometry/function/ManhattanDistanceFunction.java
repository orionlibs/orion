package com.orion.math.geometry.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.geometry.GeometryService;
import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;

public class ManhattanDistanceFunction extends Orion
{
    private static Function2x1<Point, Point, ANumber> formula;
    static
    {
        Function2x1IF<Point, Point, ANumber> f = (Point p1, Point p2) -> (GeometryService.getManhattanDistance(p1, p2));
        formula = Function2x1.of(f);
    }


    public static ANumber run(Point point1, Point point2)
    {
        return formula.run(point1, point2);
    }
}