package com.orion.math.geometry.shape.circle.sector.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.circle.sector.CircleSector;
import com.orion.math.geometry.shape.circle.sector.CircleSectorRules;

public class CircleSectorHashCodeTask extends Orion
{
    public static int run(CircleSector x)
    {
        CircleSectorRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getCircle().hashCode();
        hash = defaultPrimeNumberForHashing * hash + x.getStartPoint().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getAngleInRadians().hashCode();
    }
}