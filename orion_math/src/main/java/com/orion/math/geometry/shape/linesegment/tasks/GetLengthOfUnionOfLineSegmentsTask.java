package com.orion.math.geometry.shape.linesegment.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentRules;
import com.orion.math.number.ANumber;
import java.util.Arrays;

public class GetLengthOfUnionOfLineSegmentsTask extends Orion
{
    public static ANumber run(LineSegment[] lineSegments, int precision)
    {
        LineSegmentRules.areValid(lineSegments);
        ANumber result = lineSegments[0].getLength();
        Arrays.sort(lineSegments);
        int indexOfCurrentlyMaximumEndPoint = 0;

        for(int i = 1; i < lineSegments.length; i++)
        {

            if(lineSegments[i].getStartPoint().getX().isLessThan(lineSegments[indexOfCurrentlyMaximumEndPoint].getEndPoint().getX())
                            && lineSegments[i].getEndPoint().getX().isGreaterThan(lineSegments[indexOfCurrentlyMaximumEndPoint].getEndPoint().getX()))
            {
                LineSegment temp = LineSegment.of(lineSegments[indexOfCurrentlyMaximumEndPoint].getEndPoint(), lineSegments[i].getEndPoint());
                result.add(temp.getLength(precision));
                indexOfCurrentlyMaximumEndPoint = i;
            }
            else if(lineSegments[i].getStartPoint().getX().isGreaterThanOrEqual(lineSegments[indexOfCurrentlyMaximumEndPoint].getEndPoint().getX()))
            {
                result.add(lineSegments[i].getLength(precision));
                indexOfCurrentlyMaximumEndPoint = i;
            }

        }

        return result;
    }
}