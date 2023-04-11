package com.orion.math.geometry.shape.linesegment.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentRules;
import com.orion.math.geometry.shape.linesegment.LineSegments;

public class LineSegmentEqualsTask extends Orion
{
    public static boolean run(LineSegment x, Object y)
    {
        LineSegmentRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            LineSegment other = (LineSegment)y;

            if(!LineSegments.doLineSegmentSizesMatch(x, other))
            {
                return false;
            }

            return x.getStartPoint().equals(other.getStartPoint())
                            && x.getEndPoint().equals(other.getEndPoint());
        }

    }
}