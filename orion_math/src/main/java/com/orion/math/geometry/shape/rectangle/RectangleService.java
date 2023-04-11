package com.orion.math.geometry.shape.rectangle;

import com.orion.core.abstraction.OrionService;
import com.orion.core.tuple.Quadruple;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.rectangle.tasks.GetRectangleCornerPointsUsing4LineSegmentsTask;
import com.orion.math.geometry.shape.rectangle.tasks.check.DoesRectangleOverlapWithAnotherTask;
import com.orion.math.geometry.shape.rectangle.tasks.check.IsPointInsideRectangleTask;
import com.orion.math.geometry.shape.rectangle.tasks.check.IsPointOnRectangleTask;
import com.orion.math.geometry.shape.rectangle.tasks.check.IsValidRectangleTask;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class RectangleService extends OrionService
{
    public static boolean isValid(Point topLeftPoint, Point topRightPoint, Point bottomLeftPoint, Point bottomRightPoint)
    {
        return IsValidRectangleTask.run(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);
    }


    public static ANumber getPerimeter(Rectangle x)
    {
        RectangleRules.isValid(x);
        return x.getLengthOfSideFromTopLeftToTopRight().doubleGET().addGET(x.getLengthOfSideFromTopLeftToBottomLeft().doubleGET());
    }


    public static ANumber getArea(Rectangle x)
    {
        RectangleRules.isValid(x);
        return x.getLengthOfSideFromTopLeftToTopRight().multiplyGET(x.getLengthOfSideFromTopLeftToBottomLeft());
    }


    public static boolean isPointInsideRectangle(Rectangle x, Point other)
    {
        return IsPointInsideRectangleTask.run(x, other);
    }


    public static boolean isPointOnRectangle(Rectangle x, Point other)
    {
        return IsPointOnRectangleTask.run(x, other);
    }


    public static boolean isPointInsideOrOnRectangle(Rectangle x, Point other)
    {
        return isPointInsideRectangle(x, other) || isPointOnRectangle(x, other);
    }


    public static boolean doesOverlapWith(Rectangle x, Rectangle other)
    {
        return DoesRectangleOverlapWithAnotherTask.run(x, other);
    }


    public static Quadruple<Point, Point, Point, Point> getRectangleCornerPointsUsing4LineSegments(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4)
    {
        return GetRectangleCornerPointsUsing4LineSegmentsTask.run(s1, s2, s3, s4, Precision.precision);
    }


    public static Quadruple<Point, Point, Point, Point> getRectangleCornerPointsUsing4LineSegments(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4, int precision)
    {
        return GetRectangleCornerPointsUsing4LineSegmentsTask.run(s1, s2, s3, s4, precision);
    }


    public static boolean doLineSegmentsFormRectangle(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4)
    {
        Quadruple<Point, Point, Point, Point> cornerPoints = getRectangleCornerPointsUsing4LineSegments(s1, s2, s3, s4);
        return isValid(cornerPoints.getFirst(), cornerPoints.getSecond(), cornerPoints.getThird(), cornerPoints.getFourth());
    }


    public static boolean doLineSegmentsFormRectangle(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4, int precision)
    {
        Quadruple<Point, Point, Point, Point> cornerPoints = getRectangleCornerPointsUsing4LineSegments(s1, s2, s3, s4, precision);
        return isValid(cornerPoints.getFirst(), cornerPoints.getSecond(), cornerPoints.getThird(), cornerPoints.getFourth());
    }


    public static ANumber getLengthOfDiagonal(Rectangle x)
    {
        return getLengthOfDiagonal(x, Precision.precision);
    }


    public static ANumber getLengthOfDiagonal(Rectangle x, int precision)
    {
        RectangleRules.isValid(x);
        return x.getLengthOfSideFromTopLeftToTopRight().squareGET().addGET(x.getLengthOfSideFromTopLeftToBottomLeft().squareGET()).getSquareRoot(precision);
    }


    public static ANumber getCircumradius(Rectangle x)
    {
        return getLengthOfDiagonal(x).halfGET();
    }


    public static ANumber getCircumradius(Rectangle x, int precision)
    {
        return getLengthOfDiagonal(x, precision).halfGET();
    }


    public static LineSegment getLeftDiagonal(Rectangle x)
    {
        RectangleRules.isValid(x);
        return LineSegment.of(x.getTopLeftPoint(), x.getBottomRightPoint());
    }


    public static LineSegment getRightDiagonal(Rectangle x)
    {
        RectangleRules.isValid(x);
        return LineSegment.of(x.getBottomLeftPoint(), x.getTopRightPoint());
    }
}