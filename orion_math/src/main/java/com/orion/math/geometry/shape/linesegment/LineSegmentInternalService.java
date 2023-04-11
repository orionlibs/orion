package com.orion.math.geometry.shape.linesegment;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.linesegment.tasks.LineSegmentCompareToTask;
import com.orion.math.geometry.shape.linesegment.tasks.LineSegmentEqualsTask;
import com.orion.math.geometry.shape.linesegment.tasks.LineSegmentHashCodeTask;

class LineSegmentInternalService implements MathObject
{
    static boolean equals(LineSegment x, Object y)
    {
        return LineSegmentEqualsTask.run(x, y);
    }


    static int hashCode(LineSegment x)
    {
        return LineSegmentHashCodeTask.run(x);
    }


    static int compareTo(LineSegment x, LineSegment y)
    {
        return LineSegmentCompareToTask.run(x, y);
    }
}