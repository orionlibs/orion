package com.orion.math.linearalgebra.matrix.block.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.matrix.block.BlockMatrix;

public class BlockMatrixEqualsTask extends Orion
{
    public static boolean run(BlockMatrix x, Object y)
    {
        MatrixRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            BlockMatrix other = (BlockMatrix)y;
            return x.getElements().equals(other.getElements());
        }

    }
}