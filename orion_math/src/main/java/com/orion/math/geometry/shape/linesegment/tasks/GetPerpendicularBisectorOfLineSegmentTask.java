package com.orion.math.geometry.shape.linesegment.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentRules;
import com.orion.math.number.ANumber;

public class GetPerpendicularBisectorOfLineSegmentTask extends Orion
{
    public static Line run(LineSegment x)
    {
        LineSegmentRules.isValid(x);
        Point midpoint = x.getMidpoint();
        Line line = x.getLine();

        if(line.getB().isZero())
        {
            return Line.ofParallelToXAxis(midpoint.getY());
        }
        else if(line.getA().isZero())
        {
            return Line.ofParallelToYAxis(midpoint.getX());
        }
        else
        {
            ANumber slope = line.getB().divideGET(line.getA());
            ANumber constant = midpoint.getY().subtractGET(line.getB().multiplyGET(midpoint.getX()).divideGET(line.getA()));

            if(constant.hasInfiniteValue())
            {
                constant = midpoint.getX();
            }

            return Line.of(slope, constant);
        }

    }
}