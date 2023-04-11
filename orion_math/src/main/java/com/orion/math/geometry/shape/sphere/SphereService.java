package com.orion.math.geometry.shape.sphere;

import com.orion.core.abstraction.OrionService;
import com.orion.math.constant.Constants;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class SphereService extends OrionService
{
    public static ANumber getArea(Sphere x)
    {
        SphereRules.isValid(x);
        return ANumber.of(4).multiplyGET(x.getRadius().squareGET()).multiplyGET(Constants.PI.getValue());
    }


    public static ANumber getVolume(Sphere x)
    {
        SphereRules.isValid(x);
        return ANumber.of(4).multiplyGET(x.getRadius().exponentiateGET(3)).multiplyGET(Constants.PI.getValue()).divideGET(3);
    }


    public static boolean isPointInsideSphere(Sphere x, Point point)
    {
        return isPointInsideSphere(x, point, Precision.precision);
    }


    public static boolean isPointInsideSphere(Sphere x, Point point, int precision)
    {
        SphereRules.isValid(x);
        PointRules.doDimensionsMatch(3, point);
        return x.getCenter().getDistanceFromPoint(point, precision).isLessThan(x.getRadius().squareGET());
    }


    public static boolean isPointOnSphere(Sphere x, Point point)
    {
        return isPointOnSphere(x, point, Precision.precision);
    }


    public static boolean isPointOnSphere(Sphere x, Point point, int precision)
    {
        SphereRules.isValid(x);
        PointRules.doDimensionsMatch(3, point);
        return x.getCenter().getDistanceFromPoint(point, precision).equal(x.getRadius().squareGET());
    }


    public static boolean isPointInsideOrOnSphere(Sphere x, Point point)
    {
        return isPointInsideSphere(x, point) || isPointOnSphere(x, point);
    }


    public static boolean isPointInsideOrOnSphere(Sphere x, Point point, int precision)
    {
        return isPointInsideSphere(x, point, precision) || isPointOnSphere(x, point, precision);
    }
}