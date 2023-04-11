package com.orion.math.geometry.shape.polygon;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.polygon.tasks.GetConvexHullbasedOnPointsTask;
import com.orion.math.geometry.shape.polygon.tasks.GetMinimumCostOfTriangulationOfPolygonTask;
import com.orion.math.geometry.shape.polygon.tasks.GetPolygonAreaTask;
import com.orion.math.geometry.shape.polygon.tasks.GetPolygonPerimeterTask;
import com.orion.math.geometry.shape.polygon.tasks.IsPointInsidePolygonTask;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class PolygonService extends OrionService
{
    public static boolean isPointInsidePolygon(Polygon polygon, Point point)
    {
        return IsPointInsidePolygonTask.run(polygon, point);
    }


    public static Polygon getConvexHull(Point[] points)
    {
        return GetConvexHullbasedOnPointsTask.run(points);
    }


    public static ANumber getMinimumCostOfTriangulation(Polygon polygon)
    {
        return GetMinimumCostOfTriangulationOfPolygonTask.run(polygon, Precision.precision);
    }


    public static ANumber getMinimumCostOfTriangulation(Polygon polygon, int precision)
    {
        return GetMinimumCostOfTriangulationOfPolygonTask.run(polygon, precision);
    }


    public static ANumber getPerimeter(Polygon polygon)
    {
        return GetPolygonPerimeterTask.run(polygon);
    }


    public static ANumber getArea(Polygon polygon)
    {
        return GetPolygonAreaTask.run(polygon);
    }
}