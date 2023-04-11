package com.orion.math.geometry.vector.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;

public class VectorHashCodeTask extends Orion
{
    public static int run(Vector x)
    {
        VectorRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getElements().hashCode();
    }
}