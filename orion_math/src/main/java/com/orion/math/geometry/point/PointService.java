package com.orion.math.geometry.point;

import com.orion.core.abstraction.OrionService;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.Orientation;
import com.orion.math.geometry.plane.Plane;
import com.orion.math.geometry.point.tasks.GetNumberOfLatticePointsBetween2PointsTask;
import com.orion.math.geometry.point.tasks.GetOrientationOf3PointsTask;
import com.orion.math.geometry.point.tasks.PointPrintTask;
import com.orion.math.geometry.point.tasks.check.ArePointsCollinearTask;
import com.orion.math.geometry.point.tasks.check.ArePointsCoplanarTask;
import com.orion.math.geometry.point.tasks.distance.GetClosestPairOfPointsTask;
import com.orion.math.geometry.point.tasks.distance.GetFarthestPairOfPointsTask;
import com.orion.math.geometry.point.tasks.distance.GetHammeredDistanceBetweenPointsTask;
import com.orion.math.geometry.point.tasks.relocation.ReflectPointAboutAPlaneTask;
import com.orion.math.geometry.point.tasks.relocation.ReflectPointAboutLineTask;
import com.orion.math.geometry.point.tasks.relocation.TranslatePointTask;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.line.LineRules;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class PointService extends OrionService
{
    public static String print(Point point)
    {
        return PointPrintTask.run(point);
    }


    public static boolean areCollinear(Point... points)
    {
        return areCollinear(Precision.precision, points);
    }


    public static boolean areCollinear(int precision, Point... points)
    {
        return ArePointsCollinearTask.run(precision, points);
    }


    public static boolean areCoplanar(Point... points)
    {
        return areCoplanar(Precision.precision, points);
    }


    public static boolean areCoplanar(int precision, Point... points)
    {
        return ArePointsCoplanarTask.run(precision, points);
    }


    public static Pair<Point, Point> getClosestPairOfPoints(Point[] points)
    {
        return GetClosestPairOfPointsTask.run(points, Precision.precision);
    }


    public static Pair<Point, Point> getClosestPairOfPoints(Point[] points, int precision)
    {
        return GetClosestPairOfPointsTask.run(points, precision);
    }


    public static ANumber getDistanceOfClosestPairOfPoints(Point[] points)
    {
        Pair<Point, Point> pair = getClosestPairOfPoints(points, Precision.precision);
        return pair.getFirst().getDistanceFromPoint(pair.getSecond());
    }


    public static ANumber getDistanceOfClosestPairOfPoints(Point[] points, int precision)
    {
        Pair<Point, Point> pair = getClosestPairOfPoints(points, precision);
        return pair.getFirst().getDistanceFromPoint(pair.getSecond());
    }


    public static Pair<Point, Point> getFarthestPairOfPoints(Point[] points)
    {
        return GetFarthestPairOfPointsTask.run(points, Precision.precision);
    }


    public static Pair<Point, Point> getFarthestPairOfPoints(Point[] points, int precision)
    {
        return GetFarthestPairOfPointsTask.run(points, precision);
    }


    public static Orientation getOrientation(Point p, Point q, Point r)
    {
        return GetOrientationOf3PointsTask.run(p, q, r);
    }


    public static ANumber getNumberOfLatticePointsBetween(Point p, Point other)
    {
        return GetNumberOfLatticePointsBetween2PointsTask.run(p, other, false);
    }


    public static ANumber getNumberOfLatticePointsBetweenIncludingGivenPoints(Point p, Point other)
    {
        return GetNumberOfLatticePointsBetween2PointsTask.run(p, other, true);
    }


    public static ANumber getNumberOfIntegralPointsBetween(Point p, Point other)
    {
        return getNumberOfLatticePointsBetween(p, other);
    }


    public static ANumber getNumberOfIntegralPointsBetweenIncludingGivenPoints(Point p, Point other)
    {
        return getNumberOfLatticePointsBetweenIncludingGivenPoints(p, other);
    }


    public static Point reflectAboutALineSegment(Point p, LineSegment lineSegment)
    {
        return reflectAboutALine(p, lineSegment.getLine());
    }


    public static Point reflectAboutALine(Point p, Line line)
    {
        return ReflectPointAboutLineTask.run(p, line);
    }


    public static Point translate(Point p, ANumber x)
    {
        return TranslatePointTask.run(p, x);
    }


    public static ANumber getDistanceFromLine(Point p, Line line)
    {
        return getDistanceFromLine(p, line, Precision.precision);
    }


    public static ANumber getDistanceFromLine(Point p, Line line, int precision)
    {
        PointRules.isValid(p);
        LineRules.isValid(line);
        precision = Precision.getValidPrecision(precision);
        ANumber denominator = line.getA().squareGET().addGET(line.getB().squareGET()).getSquareRoot(precision);
        return line.getFormula().run(p.getX(), p.getY()).getAbsoluteValue().divideGET(denominator);
    }


    public static boolean doesPointLieOnTheLeftOfLineSegment(Point point, LineSegment lineSegment)
    {
        LineSegmentRules.isValid(lineSegment);
        return lineSegment.doesPointLieOnTheLeft(point);
    }


    public static boolean doesPointLieOnTheRightOfLineSegment(Point point, LineSegment lineSegment)
    {
        LineSegmentRules.isValid(lineSegment);
        return lineSegment.doesPointLieOnTheRight(point);
    }


    public static Point reflectAboutAPlane(Point point, Plane plane)
    {
        return ReflectPointAboutAPlaneTask.run(point, plane);
    }


    public static ANumber getHammeredDistanceBetweenPoints(Point... points)
    {
        return GetHammeredDistanceBetweenPointsTask.run(points);
    }
}