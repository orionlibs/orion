package com.orion.math.set.generic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.generic.GenericSet;

public class GenericSetHashCodeTask extends Orion
{
    public static int run(GenericSet set)
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + set.getElements().hashCode();
    }
}