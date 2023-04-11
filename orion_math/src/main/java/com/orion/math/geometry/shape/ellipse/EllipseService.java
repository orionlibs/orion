package com.orion.math.geometry.shape.ellipse;

import com.orion.core.abstraction.OrionService;
import com.orion.math.constant.Constants;
import com.orion.math.geometry.shape.ellipse.tasks.GetEllipseCircumferenceTask;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class EllipseService extends OrionService
{
    public static boolean isMajorAxisParallelToXAxis(Ellipse x)
    {
        EllipseRules.isValid(x);
        return x.getMajorAxisLine().isParallelToXAxis();
    }


    public static ANumber getArea(Ellipse x)
    {
        EllipseRules.isValid(x);
        return x.getRadiusOfMinorAxis().multiplyGET(x.getRadiusOfMajorAxis()).multiplyGET(Constants.PI.getValue());
    }


    public static ANumber getCircumference(Ellipse x)
    {
        return GetEllipseCircumferenceTask.run(x, Precision.precision);
    }


    public static ANumber getCircumference(Ellipse x, int precision)
    {
        return GetEllipseCircumferenceTask.run(x, precision);
    }
}