package com.orion.math.geometry.shape.sphere.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.sphere.Sphere;
import com.orion.math.geometry.shape.sphere.SphereRules;

public class SphereHashCodeTask extends Orion
{
    public static int run(Sphere x)
    {
        SphereRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getCenter().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getRadius().hashCode();
    }
}