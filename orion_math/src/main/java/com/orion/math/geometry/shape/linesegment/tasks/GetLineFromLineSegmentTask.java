package com.orion.math.geometry.shape.linesegment.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentRules;
import com.orion.math.number.ANumber;

public class GetLineFromLineSegmentTask extends Orion
{
    public static Line run(LineSegment x)
    {
        LineSegmentRules.isValid(x);
        ANumber[] abc = new ANumber[3];
        abc[0] = x.getStartPoint().getY().subtractGET(x.getEndPoint().getY());
        abc[1] = x.getEndPoint().getX().subtractGET(x.getStartPoint().getX());
        abc[2] = x.getStartPoint().getX().multiplyGET(x.getEndPoint().getY()).subtractGET(x.getStartPoint().getY().multiplyGET(x.getEndPoint().getX()));
        return Line.of(abc[0], abc[1], abc[2]);
    }
}