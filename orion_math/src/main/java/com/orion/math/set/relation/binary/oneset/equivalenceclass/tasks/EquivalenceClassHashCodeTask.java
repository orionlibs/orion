package com.orion.math.set.relation.binary.oneset.equivalenceclass.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.relation.binary.oneset.equivalenceclass.EquivalenceClass;

public class EquivalenceClassHashCodeTask extends Orion
{
    public static int run(EquivalenceClass equivalenceClass)
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + equivalenceClass.getRepresentativeElement().hashCode();
        return defaultPrimeNumberForHashing * hash + equivalenceClass.getSet().hashCode();
    }
}