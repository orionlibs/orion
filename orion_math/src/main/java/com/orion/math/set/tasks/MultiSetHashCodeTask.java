package com.orion.math.set.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.type.OrionHashMultiSet;
import com.orion.math.set.MultiSet;

public class MultiSetHashCodeTask extends Orion
{
    @SuppressWarnings("rawtypes")
    public static int run(MultiSet set)
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + ((OrionHashMultiSet)set.getElements()).getElements().hashCode();
    }
}