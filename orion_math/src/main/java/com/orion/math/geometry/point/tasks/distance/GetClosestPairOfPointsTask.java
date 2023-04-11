package com.orion.math.geometry.point.tasks.distance;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class GetClosestPairOfPointsTask extends Orion
{
    public static Pair<Point, Point> run(Point[] points, int precision)
    {
        PointRules.areValid(points);
        precision = Precision.getValidPrecision(precision);
        Point point1 = null;
        Point point2 = null;
        ANumber minimumDistance = ANumber.ofMax();

        for(int i = 0; i < points.length - 1; i++)
        {

            for(int j = i + 1; j < points.length; j++)
            {
                ANumber distance = points[i].getDistanceFromPoint(points[j], precision);

                if(distance.isLessThan(minimumDistance))
                {
                    minimumDistance = distance;
                    point1 = points[i];
                    point2 = points[j];
                }

            }

        }

        return Pair.of(point1, point2);
    }
}