package com.orion.math.geometry.point.tasks.distance;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.ANumber;

public class GetHammeredDistanceBetweenPointsTask extends Orion
{
    public static ANumber run(Point... points)
    {
        PointRules.areValid(points);
        ANumber distance = ANumber.of(0);

        for(int i = 0; i < points.length - 1; i++)
        {

            for(int j = i + 1; j < points.length; j++)
            {
                ANumber a = points[i].getX().subtractGET(points[j].getX()).squareGET();
                ANumber b = points[i].getY().subtractGET(points[j].getY()).squareGET();
                distance.add(a);
                distance.add(b);
            }

        }

        return distance;
    }
}