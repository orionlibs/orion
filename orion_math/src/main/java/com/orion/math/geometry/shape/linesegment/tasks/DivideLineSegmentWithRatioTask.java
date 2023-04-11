package com.orion.math.geometry.shape.linesegment.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentRules;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class DivideLineSegmentWithRatioTask extends Orion
{
    public static Pair<LineSegment, LineSegment> run(LineSegment x, ANumber ratio)
    {
        LineSegmentRules.isValid(x);
        NumberRules.isPositive(ratio);
        Pair<Vector, Vector> vectors = Vector.of(x.getStartPoint(), x.getEndPoint()).divideVectorWithRatio(ratio);
        Vector vector1 = vectors.getFirst();
        Vector vector2 = vectors.getSecond();
        LineSegment lineSegment1 = LineSegment.of(vector1.getStartPoint(), vector1.getEndPoint());
        LineSegment lineSegment2 = LineSegment.of(vector2.getStartPoint(), vector2.getEndPoint());
        return Pair.of(lineSegment1, lineSegment2);
    }
}