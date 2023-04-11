package com.orion.math.set.relation.binary.tasks.oneset.diagonal;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.relation.binary.oneset.diagonal.DiagonalBinaryRelationOnOneSet;

public class DiagonalBinaryRelationOnOneSetHashCodeTask extends Orion
{
    public static int run(DiagonalBinaryRelationOnOneSet relation)
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + relation.getElements().hashCode();
        return defaultPrimeNumberForHashing * hash + relation.getSet().hashCode();
    }
}