package com.orion.math.geometry.vector.generic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.geometry.vector.generic.GenericVectorRules;

public class GenericVectorHashCodeTask extends Orion
{
    public static int run(GenericVector x)
    {
        GenericVectorRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getElements().hashCode();
    }
}