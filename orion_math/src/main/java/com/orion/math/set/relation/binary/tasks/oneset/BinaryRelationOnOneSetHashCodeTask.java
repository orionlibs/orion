package com.orion.math.set.relation.binary.tasks.oneset;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSet;

public class BinaryRelationOnOneSetHashCodeTask extends Orion
{
    public static int run(BinaryRelationOnOneSet binaryRelationOnOneSet)
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + binaryRelationOnOneSet.getElements().hashCode();
        return defaultPrimeNumberForHashing * hash + binaryRelationOnOneSet.getSet().hashCode();
    }
}