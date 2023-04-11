package com.orion.math.geometry.shape.triangle.threed;

import com.orion.core.abstraction.OrionService;
import com.orion.core.tuple.Triple;
import com.orion.math.geometry.shape.triangle.threed.tasks.GetAreaOfTriangle3DTask;
import com.orion.math.geometry.shape.triangle.threed.tasks.GetTriangle3DAnglesAsRadiansTask;
import com.orion.math.geometry.shape.triangle.threed.tasks.IsTriangle3DSimilarToAnotherTask;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class Triangle3DService extends OrionService
{
    public static ANumber getPerimeter(Triangle3D x)
    {
        Triangle3DRules.isValid(x);
        return x.getLengthOfA().addGET(x.getLengthOfB()).addGET(x.getLengthOfC());
    }


    public static ANumber getHalfPerimeter(Triangle3D x)
    {
        return getPerimeter(x).halfGET();
    }


    public static ANumber getArea(Triangle3D x)
    {
        return GetAreaOfTriangle3DTask.run(x, Precision.precision);
    }


    public static ANumber getArea(Triangle3D x, int precision)
    {
        return GetAreaOfTriangle3DTask.run(x, precision);
    }


    public static boolean isSimilarTo(Triangle3D x, Triangle3D other)
    {
        return IsTriangle3DSimilarToAnotherTask.run(x, other);
    }


    public static Triple<ANumber, ANumber, ANumber> getAnglesAsRadians(Triangle3D x)
    {
        return GetTriangle3DAnglesAsRadiansTask.run(x, Precision.precision);
    }


    public static Triple<ANumber, ANumber, ANumber> getAnglesAsRadians(Triangle3D x, int precision)
    {
        return GetTriangle3DAnglesAsRadiansTask.run(x, precision);
    }


    public static Triple<ANumber, ANumber, ANumber> getAnglesAsDegrees(Triangle3D x)
    {
        Triangle3DRules.isValid(x);
        return Triple.of(x.getAngleAAsDegrees(), x.getAngleBAsDegrees(), x.getAngleCAsDegrees());
    }
}