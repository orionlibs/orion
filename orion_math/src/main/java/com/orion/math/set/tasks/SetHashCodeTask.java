package com.orion.math.set.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.Set;

public class SetHashCodeTask extends Orion
{
    public static int run(Set set)
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + set.getElements().hashCode();
    }
}