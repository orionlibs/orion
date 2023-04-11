package com.orion.math.geometry.shape.square.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Quadruple;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.rectangle.RectangleService;
import com.orion.math.geometry.vector.Vector;

public class DoLineSegmentsFormSquareTask extends Orion
{
    public static boolean run(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4, int precision)
    {
        Quadruple<Point, Point, Point, Point> cornerPoints = RectangleService.getRectangleCornerPointsUsing4LineSegments(s1, s2, s3, s4, precision);
        boolean doTheyFormRectangle = RectangleService.doLineSegmentsFormRectangle(s1, s2, s3, s4, precision);

        if(doTheyFormRectangle)
        {
            Vector vector1 = Vector.of(cornerPoints.getFirst(), cornerPoints.getSecond());
            Vector vector2 = Vector.of(cornerPoints.getSecond(), cornerPoints.getFourth());
            Vector vector3 = Vector.of(cornerPoints.getFourth(), cornerPoints.getThird());
            Vector vector4 = Vector.of(cornerPoints.getThird(), cornerPoints.getFirst());
            return vector1.getMagnitude().equal(vector2.getMagnitude())
                            && vector2.getMagnitude().equal(vector3.getMagnitude())
                            && vector3.getMagnitude().equal(vector4.getMagnitude());
        }
        else
        {
            return false;
        }

    }
}