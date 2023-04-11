package com.orion.math.geometry.shape.square;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.rectangle.Rectangle;
import com.orion.math.geometry.shape.rectangle.RectangleService;
import com.orion.math.geometry.shape.square.tasks.DoLineSegmentsFormSquareTask;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class SquareService extends OrionService
{
    public static ANumber getPerimeter(Square x)
    {
        SquareRules.isValid(x);
        return x.getLengthOfSide().multiplyGET(4);
    }


    public static ANumber getArea(Square x)
    {
        SquareRules.isValid(x);
        return x.getLengthOfSide().squareGET();
    }


    public static boolean isPointInsideSquare(Square x, Point other)
    {
        return RectangleService.isPointInsideRectangle(x, other);
    }


    public static boolean isPointOnSquare(Square x, Point other)
    {
        return RectangleService.isPointOnRectangle(x, other);
    }


    public static boolean doLineSegmentsFormSquare(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4)
    {
        return DoLineSegmentsFormSquareTask.run(s1, s2, s3, s4, Precision.precision);
    }


    public static boolean doLineSegmentsFormSquare(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4, int precision)
    {
        return DoLineSegmentsFormSquareTask.run(s1, s2, s3, s4, precision);
    }


    public static boolean doesOverlapWith(Square x, Square other)
    {
        return RectangleService.doesOverlapWith(x, other);
    }


    public static ANumber getLengthOfDiagonal(Rectangle x)
    {
        return RectangleService.getLengthOfDiagonal(x);
    }


    public static ANumber getLengthOfDiagonal(Rectangle x, int precision)
    {
        return RectangleService.getLengthOfDiagonal(x, precision);
    }


    public static ANumber getCircumradius(Rectangle x)
    {
        return RectangleService.getCircumradius(x);
    }


    public static ANumber getCircumradius(Rectangle x, int precision)
    {
        return RectangleService.getCircumradius(x, precision);
    }


    public static LineSegment getLeftDiagonal(Rectangle x)
    {
        return RectangleService.getLeftDiagonal(x);
    }


    public static LineSegment getRightDiagonal(Rectangle x)
    {
        return RectangleService.getRightDiagonal(x);
    }
}