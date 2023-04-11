package com.orion.math.geometry.shape.polygon.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.Orientation;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.polygon.Polygon;
import java.util.ArrayList;
import java.util.List;

public class GetConvexHullbasedOnPointsTask extends Orion
{
    public static Polygon run(Point[] points)
    {
        PointRules.areValidForConvexHull(points);
        List<Point> convexHullPoints = new ArrayList<Point>();
        int j = 0;

        for(int i = 1; i < points.length; i++)
        {

            if(points[i].getX().isLessThan(points[j].getX()))
            {
                j = i;
            }

        }

        int p = j;
        int q = 0;

        do
        {
            convexHullPoints.add(points[p]);
            q = (p + 1) % points.length;

            for(int i = 0; i < points.length; i++)
            {

                if(points[p].getOrientation(points[i], points[q]).is(Orientation.Counterclockwise))
                {
                    q = i;
                }

            }

            p = q;
        }
        while(p != j);

        return Polygon.of(convexHullPoints.toArray(new Point[] {}));
    }
}