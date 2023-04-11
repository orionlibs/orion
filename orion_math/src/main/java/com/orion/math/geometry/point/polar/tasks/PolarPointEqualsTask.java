package com.orion.math.geometry.point.polar.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.polar.PolarPoint;
import com.orion.math.geometry.point.polar.PolarPointRules;

public class PolarPointEqualsTask extends Orion
{
    public static boolean run(PolarPoint x, Object y)
    {
        PolarPointRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            PolarPoint other = (PolarPoint)y;
            return x.getDistanceFromPointOfOrigin() == other.getDistanceFromPointOfOrigin() && x.getAngleWithXAxis() == other.getAngleWithXAxis();
        }

    }
}