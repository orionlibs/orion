package com.orion.math.geometry.shape.circle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.circle.CircleRules;

public class CircleHashCodeTask extends Orion
{
    public static int run(Circle x)
    {
        CircleRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getCenter().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getRadius().hashCode();
    }
}