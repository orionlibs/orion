package com.orion.math.geometry.point.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.Orientation;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.ANumber;

public class GetOrientationOf3PointsTask extends Orion
{
    public static Orientation run(Point p, Point q, Point r)
    {
        PointRules.areValid(p, q, r);
        ANumber val = (q.getY().subtractGET(p.getY())).multiplyGET(r.getX().subtractGET(q.getX()));
        val.subtract((q.getX().subtractGET(p.getX())).multiplyGET(r.getY().subtractGET(q.getY())));

        if(val.isZero())
        {
            return Orientation.Collinear;
        }
        else if(val.isPositive())
        {
            return Orientation.Clockwise;
        }
        else
        {
            return Orientation.Counterclockwise;
        }

    }
}