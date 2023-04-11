package com.orion.math.geometry.vector.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class GetDisplacementVectorOf2PointsTask extends Orion
{
    public static Vector run(Point point1, Point point2)
    {
        PointRules.areValid(point1, point2);
        PointRules.doDimensionsMatch(point1, point2);
        ANumber[] coordinates = new ANumber[point1.getDimensions()];
        IntStream.range(0, point1.getDimensions())
                        .forEach(i -> coordinates[i] = point2.get(i).subtractGET(point1.get(i)));
        return Vector.of(coordinates);
    }
}