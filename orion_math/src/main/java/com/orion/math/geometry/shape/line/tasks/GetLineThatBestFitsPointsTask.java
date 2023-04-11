package com.orion.math.geometry.shape.line.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.number.ANumber;
import java.util.List;

public class GetLineThatBestFitsPointsTask extends Orion
{
    public static Line run(Point... points)
    {
        PointRules.areValid(points);

        if(points.length >= 2)
        {
            ANumber n = ANumber.of(points.length);
            ANumber slope = ANumber.of(0);
            ANumber constant = ANumber.of(0);
            ANumber sumOfX = ANumber.of(0);
            ANumber sumOfY = ANumber.of(0);
            ANumber sumOfXY = ANumber.of(0);
            ANumber sumOfX2 = ANumber.of(0);

            for(int i = 0; i < points.length; i++)
            {
                sumOfX.add(points[i].getX());
                sumOfY.add(points[i].getY());
                sumOfXY.add(points[i].getX().multiplyGET(points[i].getY()));
                sumOfX2.add(points[i].getX().squareGET());
            }

            slope = sumOfXY.multiplyGET(n).subtractGET(sumOfX.multiplyGET(sumOfY)).divideGET(n.multiplyGET(sumOfX2).subtractGET(sumOfX.squareGET()));
            constant = sumOfY.subtractGET(slope.multiplyGET(sumOfX)).divideGET(n);
            return Line.of(slope, constant);
        }
        else
        {
            return Line.of((ANumber)null, (ANumber)null, (ANumber)null);
        }

    }


    public static Line run(List<Point> points)
    {

        if(points != null && !points.isEmpty())
        {
            return run(points.toArray(new Point[0]));
        }
        else
        {
            return Line.of((ANumber)null, (ANumber)null, (ANumber)null);
        }

    }
}