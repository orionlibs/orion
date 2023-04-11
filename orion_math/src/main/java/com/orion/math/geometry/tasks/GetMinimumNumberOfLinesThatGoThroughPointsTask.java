package com.orion.math.geometry.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.services.NumberService;
import java.util.HashSet;
import java.util.Set;

public class GetMinimumNumberOfLinesThatGoThroughPointsTask extends Orion
{
    public static ANumber run(Point pointAllLinesToPassThrough, Point[] points)
    {
        PointRules.isValid(pointAllLinesToPassThrough);
        PointRules.areValid(points);
        Set<Point> slopePoints = new HashSet<Point>();
        Point temp = null;
        int minLines = 0;

        for(int i = 0; i < points.length; i++)
        {
            ANumber curX = points[i].getX();
            ANumber curY = points[i].getY();
            temp = getReducedForm(curY.subtractGET(pointAllLinesToPassThrough.getY()), curX.subtractGET(pointAllLinesToPassThrough.getX()));

            if(!slopePoints.contains(temp))
            {
                slopePoints.add(temp);
                minLines++;
            }

        }

        return ANumber.of(minLines);
    }


    private static Point getReducedForm(ANumber dy, ANumber dx)
    {
        ANumber gcd = NumberService.getGreatestCommonDivisor(dy.getAbsoluteValue().getFloor(), dx.getAbsoluteValue().getFloor());
        boolean sign = (dy.isNegative()) ^ (dx.isNegative());
        ANumber newX = dx.getAbsoluteValue();
        ANumber newY = dy.getAbsoluteValue().divideGET(gcd);
        newX = (sign) ? newX.negateGET().divideGET(gcd) : newX.divideGET(gcd);
        return Point.of(newY, newX);
    }
}