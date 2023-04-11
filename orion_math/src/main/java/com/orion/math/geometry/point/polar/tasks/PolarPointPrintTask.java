package com.orion.math.geometry.point.polar.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.polar.PolarPoint;
import com.orion.math.geometry.point.polar.PolarPointRules;

public class PolarPointPrintTask extends Orion
{
    public static String run(PolarPoint point)
    {
        PolarPointRules.isValid(point);
        return "(" + point.getDistanceFromPointOfOrigin() + ", " + point.getAngleWithXAxis() + ")";
    }
}