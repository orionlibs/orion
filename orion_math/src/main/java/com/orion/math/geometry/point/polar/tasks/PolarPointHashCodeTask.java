package com.orion.math.geometry.point.polar.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.polar.PolarPoint;
import com.orion.math.geometry.point.polar.PolarPointRules;

public class PolarPointHashCodeTask extends Orion
{
    public static int run(PolarPoint x)
    {
        PolarPointRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getDistanceFromPointOfOrigin().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getAngleWithXAxis().hashCode();
    }
}