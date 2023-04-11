package com.orion.math.geometry.shape.circle.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.circle.CircleRules;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.number.ANumber;

public class GetTangentLineOfCircleOnPointTask extends Orion
{
    public static Line run(Circle x, Point point)
    {
        CircleRules.isPointOnCircle(x, point);
        ANumber temp1 = point.getY().subtractGET(x.getCenter().getY());
        ANumber temp2 = point.getX().subtractGET(x.getCenter().getX());
        ANumber slopeOfCenterAndPointLine = temp1.divideGET(temp2);
        ANumber slopeOfTangentLine = ANumber.of(-1).divideGET(slopeOfCenterAndPointLine);

        if(slopeOfTangentLine.hasInfiniteValue())
        {
            return Line.of(ANumber.of(1), ANumber.of(0), point.getX().negateGET());
        }
        else
        {
            ANumber intercept = point.getY().subtractGET(slopeOfTangentLine.multiplyGET(point.getX()));
            return Line.of(slopeOfTangentLine, intercept);
        }

    }
}