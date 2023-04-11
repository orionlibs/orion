package com.orion.math.linearalgebra.matrix.block.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.matrix.block.BlockMatrix;

public class BlockMatrixHashCodeTask extends Orion
{
    public static int run(BlockMatrix x)
    {
        MatrixRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getElements().hashCode();
    }
}