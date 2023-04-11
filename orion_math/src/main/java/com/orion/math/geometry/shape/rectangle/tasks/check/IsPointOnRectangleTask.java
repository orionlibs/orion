package com.orion.math.geometry.shape.rectangle.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.rectangle.Rectangle;
import com.orion.math.geometry.shape.rectangle.RectangleRules;

public class IsPointOnRectangleTask extends Orion
{
    public static boolean run(Rectangle x, Point other)
    {
        RectangleRules.isValid(x);
        PointRules.isValid(other);
        PointRules.doDimensionsMatch(x.getTopLeftPoint(), other);
        boolean a = isPointOnLineSegment(x.getBottomLeftPoint(), x.getBottomRightPoint(), other);
        boolean b = isPointOnLineSegment(x.getBottomRightPoint(), x.getTopRightPoint(), other);
        boolean c = isPointOnLineSegment(x.getTopRightPoint(), x.getTopLeftPoint(), other);
        boolean d = isPointOnLineSegment(x.getTopLeftPoint(), x.getBottomLeftPoint(), other);
        return a || b || c || d;
    }


    private static boolean isPointOnLineSegment(Point lineSegmentStartPoint, Point lineSegmentEndPoint, Point other)
    {
        return LineSegment.of(lineSegmentStartPoint, lineSegmentEndPoint).isPointOnLineSegment(other);
    }
}