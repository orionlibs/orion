package com.orion.math.geometry.shape.linesegment.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentRules;

public class AreLineSegmentsColinearTask extends Orion
{
    public static boolean run(LineSegment... lineSegments)
    {
        LineSegmentRules.areValid(lineSegments);

        for(int i = 0; i < lineSegments.length - 1; i++)
        {

            if(lineSegments[i].isNotCollinearTo(lineSegments[i + 1]))
            {
                return false;
            }

        }

        return true;
    }
}