package com.orion.math.geometry.point.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.precision.Precision;

public class ArePointsCollinearTask extends Orion
{
    public static boolean run(int precision, Point... points)
    {

        if(points != null && points.length > 2)
        {
            precision = Precision.getValidPrecision(precision);
            PointRules.doDimensionsMatch(points);

            if(points[0].getDimensions() == 2)
            {
                Line lineOfPoint1And2 = LineSegment.of(points[0], points[1]).getLine();

                for(int i = 2; i < points.length; i++)
                {

                    if(lineOfPoint1And2.doesPointNotBelongToLine(points[i]))
                    {
                        return false;
                    }

                }

                return true;
            }
            else if(points[0].getDimensions() > 2)
            {
                Vector vectorAB = Vector.of(points[0], points[1]);

                for(int i = 2; i < points.length; i++)
                {

                    if(vectorAB.isNotParallelTo(Vector.of(points[0], points[i]), precision))
                    {
                        return false;
                    }

                }

                return true;
            }

        }

        return false;
    }
}