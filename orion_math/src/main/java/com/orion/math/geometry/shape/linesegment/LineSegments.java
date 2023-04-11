package com.orion.math.geometry.shape.linesegment;

import com.orion.math.MathObject;
import com.orion.math.geometry.point.Point;

public class LineSegments implements MathObject
{
    public static boolean doLineSegmentSizesMatch(LineSegment x, LineSegment y)
    {
        return isValid(x) && isValid(y) && x.getDimensions() == y.getDimensions();
    }


    public static boolean isValid(LineSegment lineSegment)
    {
        return lineSegment != null && isValid(lineSegment.getStartPoint(), lineSegment.getEndPoint());
    }


    public static boolean isValid(Point startPoint, Point endPoint)
    {
        return startPoint != null && startPoint.getCoordinates() != null
                        && startPoint.getCoordinates().length > 0 && endPoint != null
                        && endPoint.getCoordinates() != null && endPoint.getCoordinates().length > 0
                        && startPoint.getCoordinates().length == endPoint.getCoordinates().length;
    }
}