package com.orion.math.geometry.shape.circle.arc.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.circle.arc.CircleArc;
import com.orion.math.geometry.shape.circle.arc.CircleArcRules;

public class CircleArcHashCodeTask extends Orion
{
    public static int run(CircleArc x)
    {
        CircleArcRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getCircle().hashCode();
        hash = defaultPrimeNumberForHashing * hash + x.getStartPoint().hashCode();
        hash = defaultPrimeNumberForHashing * hash + x.getEndPoint().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getAngleInRadians().hashCode();
    }
}