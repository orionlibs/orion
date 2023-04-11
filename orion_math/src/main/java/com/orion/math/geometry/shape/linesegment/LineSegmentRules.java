package com.orion.math.geometry.shape.linesegment;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import java.util.Arrays;

public class LineSegmentRules extends MathRule
{
    public static void isValid(Point startPoint, Point endPoint)
    {
        Assert.notNull(startPoint, "Line segment points are empty or sizes do not match.");
        Assert.notEmpty(startPoint.getCoordinates(), "Line segment points are empty or sizes do not match.");
        Assert.notNull(endPoint, "Line segment points are empty or sizes do not match.");
        Assert.notEmpty(endPoint.getCoordinates(), "Line segment points are empty or sizes do not match.");
    }


    public static void isValid(LineSegment lineSegment)
    {
        Assert.notNull(lineSegment, "The lineSegment input cannot be null.");
        isValid(lineSegment.getStartPoint(), lineSegment.getEndPoint());
    }


    public static void areValid(LineSegment... lineSegments)
    {
        Assert.notEmpty(lineSegments, "The lineSegments input cannot be null/empty.");
        Arrays.stream(lineSegments).forEach(line -> isValid(line));
    }
}