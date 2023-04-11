package com.orion.math.geometry.shape.linesegment.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;
import com.orion.math.number.arithmetic.ArithmeticService;

public class IsPointOnLineSegmentTask extends Orion
{
    public static boolean run(LineSegment x, Point point)
    {

        if(x.getLine().getDistanceFromPoint(point).isZero())
        {
            ANumber minimumX = ArithmeticService.getMinimum(x.getStartPoint().getX(), x.getEndPoint().getX());
            ANumber maximumX = ArithmeticService.getMaximum(x.getStartPoint().getX(), x.getEndPoint().getX());
            ANumber minimumY = ArithmeticService.getMinimum(x.getStartPoint().getY(), x.getEndPoint().getY());
            ANumber maximumY = ArithmeticService.getMaximum(x.getStartPoint().getY(), x.getEndPoint().getY());
            return Numbers.isBetween(point.getX(), minimumX, maximumX) && Numbers.isBetween(point.getY(), minimumY, maximumY);
        }
        else
        {
            return false;
        }

    }
}