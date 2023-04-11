package com.orion.math.geometry.plane;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.plane.tasks.GetAngleWithPlaneTask;
import com.orion.math.geometry.plane.tasks.GetFootOfPerpendicularLineFromPointTask;
import com.orion.math.geometry.plane.tasks.IsPlaneParallelToAnotherTask;
import com.orion.math.geometry.plane.tasks.distance.GetDistanceBetween2ParallelPlanesTask;
import com.orion.math.geometry.plane.tasks.distance.GetDistanceBetweenPointAndPlaneTask;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointService;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class PlaneService extends OrionService
{
    public static ANumber getDistanceFromPoint(Plane plane, Point point)
    {
        return GetDistanceBetweenPointAndPlaneTask.run(plane, point, Precision.precision);
    }


    public static ANumber getDistanceFromPoint(Plane plane, Point point, int squareRootPrecision)
    {
        return GetDistanceBetweenPointAndPlaneTask.run(plane, point, squareRootPrecision);
    }


    public static ANumber getAngleWithPlane(Plane x, Plane other)
    {
        return GetAngleWithPlaneTask.run(x, other, Precision.precision);
    }


    public static ANumber getAngleWithPlane(Plane x, Plane other, int precision)
    {
        return GetAngleWithPlaneTask.run(x, other, precision);
    }


    public static boolean isParallelTo(Plane x, Plane other)
    {
        return IsPlaneParallelToAnotherTask.run(x, other);
    }


    public static boolean isNotParallelTo(Plane x, Plane other)
    {
        return !isParallelTo(x, other);
    }


    public static ANumber getDistanceFromParallelPlane(Plane x, Plane other)
    {
        return GetDistanceBetween2ParallelPlanesTask.run(x, other, Precision.precision);
    }


    public static ANumber getDistanceFromParallelPlane(Plane x, Plane other, int precision)
    {
        return GetDistanceBetween2ParallelPlanesTask.run(x, other, precision);
    }


    public static boolean areCoplanar(Point... points)
    {
        return PointService.areCoplanar(points);
    }


    public static boolean areCoplanar(int precision, Point... points)
    {
        return PointService.areCoplanar(precision, points);
    }


    public static Point getFootOfPerpendicularLineFromPoint(Plane x, Point point)
    {
        return GetFootOfPerpendicularLineFromPointTask.run(x, point);
    }
}