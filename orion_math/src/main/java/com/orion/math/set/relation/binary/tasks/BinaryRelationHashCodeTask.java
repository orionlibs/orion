package com.orion.math.set.relation.binary.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.relation.binary.BinaryRelation;

public class BinaryRelationHashCodeTask extends Orion
{
    public static int run(BinaryRelation binaryRelation)
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + binaryRelation.getElements().hashCode();
        hash = defaultPrimeNumberForHashing * hash + binaryRelation.getSetA().hashCode();
        return defaultPrimeNumberForHashing * hash + binaryRelation.getSetB().hashCode();
    }
}