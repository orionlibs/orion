package com.orion.math.geometry.shape.line;

import com.orion.core.abstraction.OrionService;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.circle.CircleRules;
import com.orion.math.geometry.shape.line.tasks.GetDistanceBetweenPointAndLineTask;
import com.orion.math.geometry.shape.line.tasks.GetIntersectionPointOfLinesTask;
import com.orion.math.geometry.shape.line.tasks.GetLineThatBestFitsPointsTask;
import com.orion.math.geometry.shape.line.tasks.GetPointThatMinimisesSumOfdistancesFromPointsToLineTask;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;
import java.util.List;

public class LineService extends OrionService
{
    public static ANumber getDistanceFromPoint(Line line, Point point)
    {
        return GetDistanceBetweenPointAndLineTask.run(line, point, Precision.precision);
    }


    public static ANumber getDistanceFromPoint(Line line, Point point, int precision)
    {
        return GetDistanceBetweenPointAndLineTask.run(line, point, precision);
    }


    public static boolean doesIntersect(Line x, Line other)
    {
        return getIntersectionPoint(x, other) != null;
    }


    public static Point getIntersectionPoint(Line x, Line other)
    {
        return GetIntersectionPointOfLinesTask.run(x, other);
    }


    public static Pair<Point, ANumber> getPointThatMinimisesSumOfdistancesFromPointsToLine(Line x, Point[] points)
    {
        return GetPointThatMinimisesSumOfdistancesFromPointsToLineTask.run(x, points, Precision.precision);
    }


    public static Pair<Point, ANumber> getPointThatMinimisesSumOfdistancesFromPointsToLine(Line x, Point[] points, int precision)
    {
        return GetPointThatMinimisesSumOfdistancesFromPointsToLineTask.run(x, points, precision);
    }


    public static Line getLineThatBestFitsPoints(Point... points)
    {
        return GetLineThatBestFitsPointsTask.run(points);
    }


    public static Line getLineThatBestFitsPoints(List<Point> points)
    {
        return GetLineThatBestFitsPointsTask.run(points);
    }


    public static boolean isParallelTo(Line x, Line other)
    {
        LineRules.areValid(x, other);

        if(x.getSlope().equal(other.getSlope()))
        {
            return true;
        }
        else
        {
            return x.getA().negateGET().divideGET(x.getB()).equal(other.getA().negateGET().divideGET(other.getB()));
        }

    }


    public static boolean isParallelTo(Line x, Line other, int precision)
    {
        LineRules.areValid(x, other);

        if(x.getSlope(precision).equal(other.getSlope(precision)))
        {
            return true;
        }
        else
        {
            return x.getA().negateGET().divideGET(x.getB()).equal(other.getA().negateGET().divideGET(other.getB()));
        }

    }


    public static boolean isNotParallelTo(Line x, Line other)
    {
        return !isParallelTo(x, other);
    }


    public static boolean isNotParallelTo(Line x, Line other, int precision)
    {
        return !isParallelTo(x, other, precision);
    }


    public static boolean isVerticalTo(Line x, Line other)
    {
        LineRules.areValid(x, other);

        if(x.getSlope().multiplyGET(other.getSlope()).isMinusOne())
        {
            return true;
        }
        else
        {
            return x.getA().negateGET().divideGET(x.getB()).multiplyGET(other.getA().negateGET().divideGET(other.getB())).isMinusOne();
        }

    }


    public static boolean isVerticalTo(Line x, Line other, int precision)
    {
        LineRules.areValid(x, other);

        if(x.getSlope(precision).multiplyGET(other.getSlope(precision)).isMinusOne())
        {
            return true;
        }
        else
        {
            return x.getA().negateGET().divideGET(x.getB()).multiplyGET(other.getA().negateGET().divideGET(other.getB())).isMinusOne();
        }

    }


    public static boolean isNotVerticalTo(Line x, Line other)
    {
        return !isVerticalTo(x, other);
    }


    public static boolean isNotVerticalTo(Line x, Line other, int precision)
    {
        return !isVerticalTo(x, other, precision);
    }


    public static boolean isLineTangentToCircle(Line x, Circle circle)
    {
        return isLineTangentToCircle(x, circle, Precision.precision);
    }


    public static boolean isLineTangentToCircle(Line x, Circle circle, int precision)
    {
        LineRules.isValid(x);
        CircleRules.isValid(circle);
        return x.getDistanceFromPoint(circle.getCenter(), precision).equal(circle.getRadius());
    }


    public static boolean doesLineIntersectCircle(Line x, Circle circle)
    {
        return doesLineIntersectCircle(x, circle, Precision.precision);
    }


    public static boolean doesLineIntersectCircle(Line x, Circle circle, int precision)
    {
        LineRules.isValid(x);
        CircleRules.isValid(circle);
        return x.getDistanceFromPoint(circle.getCenter(), precision).isLessThan(circle.getRadius());
    }
}