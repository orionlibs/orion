package com.orion.math.linearalgebra.matrix.block;

import com.orion.math.MathObject;
import com.orion.math.linearalgebra.matrix.block.tasks.BlockMatrixEqualsTask;
import com.orion.math.linearalgebra.matrix.block.tasks.BlockMatrixHashCodeTask;

class BlockMatrixInternalService implements MathObject
{
    static boolean equals(BlockMatrix x, Object y)
    {
        return BlockMatrixEqualsTask.run(x, y);
    }


    static int hashCode(BlockMatrix x)
    {
        return BlockMatrixHashCodeTask.run(x);
    }
}