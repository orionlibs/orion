package com.orion.math.geometry;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.tasks.GetMinimumDistanceBetweenLineAndPointIn3DTask;
import com.orion.math.geometry.tasks.GetMinimumNumberOfLinesThatGoThroughPointsTask;
import com.orion.math.geometry.tasks.GetNumberOfHorizontalOrVerticalLineSegmentsToConnectPointsTask;
import com.orion.math.geometry.tasks.GetNumberOfParallelogramsFormedByPointsTask;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class GeometryService extends OrionService
{
    public static ANumber getNumberOfParallelogramsFormedByPoints(Point[] points)
    {
        return GetNumberOfParallelogramsFormedByPointsTask.run(points);
    }


    public static ANumber getMinimumNumberOfLinesThatGoThroughPoints(Point pointAllLinesToPassThrough, Point[] points)
    {
        return GetMinimumNumberOfLinesThatGoThroughPointsTask.run(pointAllLinesToPassThrough, points);
    }


    public static ANumber getManhattanDistance(Point point1, Point point2)
    {
        PointRules.areValid(point1, point2);
        return point1.getX().subtractGET(point2.getX()).getAbsoluteValue().addGET(point1.getY().subtractGET(point2.getY()).getAbsoluteValue());
    }


    public static ANumber getNumberOfHorizontalOrVerticalLineSegmentsToConnectPoints(Point point1, Point point2, Point point3)
    {
        return GetNumberOfHorizontalOrVerticalLineSegmentsToConnectPointsTask.run(point1, point2, point3);
    }


    public static ANumber getMinimumDistanceBetweenLineAndPointIn3D(Point linePoint1, Point linePoint2, Point point)
    {
        return GetMinimumDistanceBetweenLineAndPointIn3DTask.run(linePoint1, linePoint2, point, Precision.precision);
    }


    public static ANumber getMinimumDistanceBetweenLineAndPointIn3D(Point linePoint1, Point linePoint2, Point point, int precision)
    {
        return GetMinimumDistanceBetweenLineAndPointIn3DTask.run(linePoint1, linePoint2, point, precision);
    }


    public static ANumber getAreaOfParallelogramGiven2AdjacentSides(Vector x, Vector y)
    {
        VectorRules.areValid(x, y);
        VectorRules.doVectorSizesMatch(x, y, 3);
        return x.getCrossProductMagnitude(y);
    }


    public static ANumber getAreaOfParallelogramGiven2AdjacentSides(Vector x, Vector y, int precision)
    {
        VectorRules.areValid(x, y);
        VectorRules.doVectorSizesMatch(x, y, 3);
        return x.getCrossProductMagnitude(y, precision);
    }
}