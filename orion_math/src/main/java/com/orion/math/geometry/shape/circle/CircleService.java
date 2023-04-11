package com.orion.math.geometry.shape.circle;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.constant.Constants;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.circle.chord.CircleChord;
import com.orion.math.geometry.shape.circle.tasks.check.DoCirclesIntersectTask;
import com.orion.math.geometry.shape.circle.tasks.check.IsPointInsideCircleTask;
import com.orion.math.geometry.shape.circle.tasks.check.IsPointOnCircleTask;
import com.orion.math.geometry.shape.circle.tasks.query.GetAngleAsRadiansBetween2PointsOnCircleTask;
import com.orion.math.geometry.shape.circle.tasks.query.GetAreaOfMinorSegmentOfCircleTask;
import com.orion.math.geometry.shape.circle.tasks.query.GetCirclePointBasedOnPointAndAngleTask;
import com.orion.math.geometry.shape.circle.tasks.query.GetCircleThatEnclosesPointsTask;
import com.orion.math.geometry.shape.circle.tasks.query.GetNumberOfCircleLatticePointsTask;
import com.orion.math.geometry.shape.circle.tasks.query.GetTangentLineOfCircleOnPointTask;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.line.LineRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;

public class CircleService extends OrionService
{
    public static ANumber getCircumference(Circle x)
    {
        CircleRules.isValid(x);
        return Constants.twoPI.multiplyGET(x.getRadius());
    }


    public static ANumber getArea(Circle x)
    {
        CircleRules.isValid(x);
        return Constants.PI.getValue().multiplyGET(x.getRadius().squareGET());
    }


    public static boolean isPointInsideCircle(Circle x, Point other)
    {
        return IsPointInsideCircleTask.run(x, other, Precision.precision);
    }


    public static boolean isPointInsideCircle(Circle x, Point other, int precision)
    {
        return IsPointInsideCircleTask.run(x, other, precision);
    }


    public static boolean isPointOnCircle(Circle x, Point other)
    {
        return IsPointOnCircleTask.run(x, other, Precision.precision);
    }


    public static boolean isPointOnCircle(Circle x, Point other, int precision)
    {
        return IsPointOnCircleTask.run(x, other, precision);
    }


    public static boolean isPointInsideOrOnCircle(Circle x, Point other)
    {
        return isPointInsideCircle(x, other) || isPointOnCircle(x, other);
    }


    public static boolean isPointInsideOrOnCircle(Circle x, Point other, int precision)
    {
        return isPointInsideCircle(x, other, precision) || isPointOnCircle(x, other, precision);
    }


    public static boolean isPointNotOnCircle(Circle x, Point other)
    {
        return !isPointOnCircle(x, other);
    }


    public static boolean isPointNotOnCircle(Circle x, Point other, int precision)
    {
        return !isPointOnCircle(x, other, precision);
    }


    public static ANumber getNumberOfLatticePoints(Circle x)
    {
        return GetNumberOfCircleLatticePointsTask.run(x, Precision.precision);
    }


    public static ANumber getNumberOfLatticePoints(Circle x, int precision)
    {
        return GetNumberOfCircleLatticePointsTask.run(x, precision);
    }


    public static ANumber getPositiveYBasedOnX(Circle circle, ANumber x)
    {
        return getPositiveYBasedOnX(circle, x, Precision.precision);
    }


    public static ANumber getPositiveYBasedOnX(Circle circle, ANumber x, int precision)
    {
        CircleRules.isValid(circle);
        NumberRules.isNotNull(x);
        precision = Precision.getValidPrecision(precision);
        return circle.getRadius().squareGET().subtractGET(x.squareGET()).getSquareRoot(precision);
    }


    public static ANumber getNegativeYBasedOnX(Circle circle, ANumber x)
    {
        return getNegativeYBasedOnX(circle, x, Precision.precision);
    }


    public static ANumber getNegativeYBasedOnX(Circle circle, ANumber x, int precision)
    {
        CircleRules.isValid(circle);
        NumberRules.isNotNull(x);
        precision = Precision.getValidPrecision(precision);
        return circle.getRadius().squareGET().subtractGET(x.squareGET()).getSquareRoot(precision).negateGET();
    }


    public static ANumber getAngleAsRadiansBetween(Circle x, Point startPoint, Point endPoint)
    {
        return GetAngleAsRadiansBetween2PointsOnCircleTask.run(x, startPoint, endPoint, Precision.precision);
    }


    public static ANumber getAngleAsRadiansBetween(Circle x, Point startPoint, Point endPoint, int precision)
    {
        return GetAngleAsRadiansBetween2PointsOnCircleTask.run(x, startPoint, endPoint, precision);
    }


    public static Point getCirclePointBasedOn(Circle x, Point startPoint, ANumber angle)
    {
        return GetCirclePointBasedOnPointAndAngleTask.run(x, startPoint, angle, Precision.precision);
    }


    public static Point getCirclePointBasedOn(Circle x, Point startPoint, ANumber angle, int trigPrecision)
    {
        return GetCirclePointBasedOnPointAndAngleTask.run(x, startPoint, angle, trigPrecision);
    }


    public static ANumber getNumberOfAreasBasedOnNumberOfCuts(ANumber cuts)
    {
        NumberRules.isPositive(cuts);
        return cuts.multiplyGET(cuts.addOneGET()).halfGET().addOneGET();
    }


    public static boolean isLineTangentToCircle(Circle x, Line line)
    {
        CircleRules.isValid(x);
        LineRules.isValid(line);
        return line.isLineTangentToCircle(x);
    }


    public static boolean isLineTangentToCircle(Circle x, Line line, int precision)
    {
        CircleRules.isValid(x);
        LineRules.isValid(line);
        return line.isLineTangentToCircle(x, precision);
    }


    public static boolean doesLineIntersectCircle(Circle x, Line line)
    {
        CircleRules.isValid(x);
        LineRules.isValid(line);
        return line.doesLineIntersectCircle(x);
    }


    public static boolean doesLineIntersectCircle(Circle x, Line line, int precision)
    {
        CircleRules.isValid(x);
        LineRules.isValid(line);
        return line.doesLineIntersectCircle(x, precision);
    }


    public static boolean isTangent(Circle x, Line line)
    {
        CircleRules.isValid(x);
        LineRules.isValid(line);
        return line.isLineTangentToCircle(x);
    }


    public static boolean isTangent(Circle x, Line line, int precision)
    {
        CircleRules.isValid(x);
        LineRules.isValid(line);
        return line.isLineTangentToCircle(x, precision);
    }


    public static boolean isSecant(Circle x, Line line)
    {
        return doesLineIntersectCircle(x, line);
    }


    public static boolean isSecant(Circle x, Line line, int precision)
    {
        return doesLineIntersectCircle(x, line, precision);
    }


    public static ANumber getAreaOfMinorSegment(Circle x, CircleChord chord)
    {
        return GetAreaOfMinorSegmentOfCircleTask.run(x, chord, Precision.precision);
    }


    public static ANumber getAreaOfMinorSegment(Circle x, CircleChord chord, int precision)
    {
        return GetAreaOfMinorSegmentOfCircleTask.run(x, chord, precision);
    }


    public static ANumber getAreaOfMajorSegment(Circle x, CircleChord chord)
    {
        CircleRules.isValid(x);
        return x.getArea().subtractGET(getAreaOfMinorSegment(x, chord));
    }


    public static ANumber getAreaOfMajorSegment(Circle x, CircleChord chord, int precision)
    {
        CircleRules.isValid(x);
        return x.getArea().subtractGET(getAreaOfMinorSegment(x, chord, precision));
    }


    public static boolean doCirclesIntersect(Circle x, Circle other)
    {
        return DoCirclesIntersectTask.run(x, other);
    }


    public static Line getTangentLineOnPoint(Circle x, Point point)
    {
        return GetTangentLineOfCircleOnPointTask.run(x, point);
    }


    public static Circle getCircleThatEnclosesPoints(OrionList<Point> points)
    {
        return GetCircleThatEnclosesPointsTask.run(points);
    }
}