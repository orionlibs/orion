package com.orion.math.geometry.shape.cylinder.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.cylinder.Cylinder;
import com.orion.math.geometry.shape.cylinder.CylinderRules;

public class CylinderHashCodeTask extends Orion
{
    public static int run(Cylinder x)
    {
        CylinderRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getRadius().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getHeight().hashCode();
    }
}