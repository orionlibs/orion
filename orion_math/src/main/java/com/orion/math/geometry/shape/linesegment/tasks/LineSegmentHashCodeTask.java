package com.orion.math.geometry.shape.linesegment.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentRules;

public class LineSegmentHashCodeTask extends Orion
{
    public static int run(LineSegment x)
    {
        LineSegmentRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getStartPoint().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getEndPoint().hashCode();
    }
}