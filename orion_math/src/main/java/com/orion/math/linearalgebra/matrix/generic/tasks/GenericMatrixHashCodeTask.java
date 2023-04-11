package com.orion.math.linearalgebra.matrix.generic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class GenericMatrixHashCodeTask extends Orion
{
    public static int run(GenericMatrix x)
    {
        GenericMatrixRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getElements().hashCode();
    }
}