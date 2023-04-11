package com.orion.math.geometry.shape.line.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.line.LineRules;
import com.orion.math.number.ANumber;

public class GetIntersectionPointOfLinesTask extends Orion
{
    public static Point run(Line x, Line other)
    {
        LineRules.areValid(x, other);

        if(x.getSlope().equal(other.getSlope()))
        {
            return null;
        }
        else
        {

            if(x.getSlope().hasInfiniteValue())
            {

                if(other.getSlope().hasInfiniteValue())
                {
                    return null;
                }
                else
                {
                    ANumber intersectionPointX = x.getInterceptForSlopeForm();
                    ANumber intersectionPointY = other.getSlope().multiplyGET(intersectionPointX).addGET(other.getInterceptForSlopeForm());
                    return Point.of(intersectionPointX, intersectionPointY);
                }

            }
            else if(other.getSlope().hasInfiniteValue())
            {

                if(x.getSlope().hasInfiniteValue())
                {
                    return null;
                }
                else
                {
                    ANumber intersectionPointX = other.getInterceptForSlopeForm();
                    ANumber intersectionPointY = x.getSlope().multiplyGET(intersectionPointX).addGET(x.getInterceptForSlopeForm());
                    return Point.of(intersectionPointX, intersectionPointY);
                }

            }
            else
            {
                ANumber slopeOfXMinusSlopeOfOther = x.getSlope().subtractGET(other.getSlope());
                ANumber intersectionPointX = other.getInterceptForSlopeForm().subtractGET(x.getInterceptForSlopeForm()).divideGET(slopeOfXMinusSlopeOfOther);
                ANumber intersectionPointY = x.getSlope().multiplyGET(other.getInterceptForSlopeForm()).subtractGET(other.getSlope().multiplyGET(x.getInterceptForSlopeForm()));
                intersectionPointY = intersectionPointY.divideGET(slopeOfXMinusSlopeOfOther);
                return Point.of(intersectionPointX, intersectionPointY);
            }

        }

    }
}