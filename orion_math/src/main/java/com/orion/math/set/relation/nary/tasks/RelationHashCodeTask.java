package com.orion.math.set.relation.nary.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.relation.nary.NAryRelation;

public class RelationHashCodeTask extends Orion
{
    public static int run(NAryRelation nAryRelation)
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + nAryRelation.getElements().hashCode();
        return defaultPrimeNumberForHashing * hash + nAryRelation.getSets().hashCode();
    }
}