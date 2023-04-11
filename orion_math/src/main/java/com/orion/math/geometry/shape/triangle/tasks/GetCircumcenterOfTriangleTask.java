package com.orion.math.geometry.shape.triangle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentService;
import com.orion.math.geometry.shape.triangle.Triangle;
import com.orion.math.geometry.shape.triangle.TriangleRules;

public class GetCircumcenterOfTriangleTask extends Orion
{
    public static Point run(Triangle x)
    {
        TriangleRules.isValid(x);
        Line perpendicularBisector1 = LineSegmentService.getPerpendicularBisector(LineSegment.of(x.getPointA(), x.getPointB()));
        Line perpendicularBisector2 = LineSegmentService.getPerpendicularBisector(LineSegment.of(x.getPointB(), x.getPointC()));

        if(perpendicularBisector1.isParallelTo(perpendicularBisector2))
        {
            throw new InvalidArgumentException("The perpendicular bisectors are parallel and cannot form a triange.");
        }
        else
        {
            return perpendicularBisector1.getIntersectionPoint(perpendicularBisector2);
        }

    }
}