package com.orion.math.geometry.shape.linesegment.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.RelativePosition;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentRules;
import com.orion.math.number.ANumber;

public class GetPositionOfPointRelativeToLineSegmentTask extends Orion
{
    public static RelativePosition run(LineSegment x, Point point)
    {
        LineSegmentRules.isValid(x);
        PointRules.isValid(point);
        ANumber lineSegmentEndPointX = x.getEndPoint().getX().subtractGET(x.getStartPoint().getX());
        ANumber lineSegmentEndPointY = x.getEndPoint().getY().subtractGET(x.getStartPoint().getY());
        ANumber pointX = point.getX().subtractGET(x.getStartPoint().getX());
        ANumber pointY = point.getY().subtractGET(x.getStartPoint().getY());
        ANumber dotProduct = lineSegmentEndPointX.multiplyGET(pointY).subtractGET(lineSegmentEndPointY.multiplyGET(pointX));

        if(dotProduct.isPositive())
        {
            return RelativePosition.Left;
        }
        else if(dotProduct.isNegative())
        {
            return RelativePosition.Right;
        }
        else
        {
            return RelativePosition.On;
        }

    }
}