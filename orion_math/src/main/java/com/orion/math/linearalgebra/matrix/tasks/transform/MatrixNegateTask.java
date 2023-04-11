package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class MatrixNegateTask extends Orion
{
    public static Matrix run(Matrix x)
    {
        MatrixRules.isValid(x);
        Matrix newMatrix = x.getCopy();
        newMatrix.forAll((i, j) -> newMatrix.get(i, j).negate());
        return newMatrix;
    }
}