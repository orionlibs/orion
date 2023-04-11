package com.orion.math.geometry.shape.linesegment.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.linesegment.LineSegment;

public class LineSegmentCompareToTask extends Orion
{
    public static int run(LineSegment x, LineSegment y)
    {

        if(y == null)
        {
            return 0;
        }
        else
        {

            if(x.getStartPoint().getX().isLessThan(y.getStartPoint().getX()))
            {
                return -1;
            }
            else if(x.getStartPoint().getX().isGreaterThan(y.getStartPoint().getX()))
            {
                return 1;
            }
            else
            {

                if(x.getStartPoint().getY().isLessThan(y.getStartPoint().getY()))
                {
                    return -1;
                }
                else if(x.getStartPoint().getY().isGreaterThan(y.getStartPoint().getY()))
                {
                    return 1;
                }
                else
                {
                    return 0;
                }

            }

        }

    }
}