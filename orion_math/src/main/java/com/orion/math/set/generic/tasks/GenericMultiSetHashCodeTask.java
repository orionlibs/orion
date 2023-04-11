package com.orion.math.set.generic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.type.OrionHashMultiSet;
import com.orion.math.set.generic.GenericMultiSet;

public class GenericMultiSetHashCodeTask extends Orion
{
    @SuppressWarnings("rawtypes")
    public static int run(GenericMultiSet set)
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + ((OrionHashMultiSet)set.getElements()).getElements().hashCode();
    }
}