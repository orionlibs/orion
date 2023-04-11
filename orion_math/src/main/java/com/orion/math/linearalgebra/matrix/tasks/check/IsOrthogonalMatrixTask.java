package com.orion.math.linearalgebra.matrix.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class IsOrthogonalMatrixTask extends Orion
{
    public static boolean run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        Matrix transpose = x.transpose();
        Matrix transposeTimesX = transpose.multiply(x);
        Matrix xTimesTranspose = x.multiply(transpose);
        Matrix identityMatrix = Matrix.ofIdentity(x.getNumberOfRows());
        return transposeTimesX.equals(xTimesTranspose) && transposeTimesX.equals(identityMatrix);
    }
}