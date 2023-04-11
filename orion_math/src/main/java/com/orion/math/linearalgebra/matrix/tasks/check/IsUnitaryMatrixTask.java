package com.orion.math.linearalgebra.matrix.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class IsUnitaryMatrixTask extends Orion
{
    public static boolean run(Matrix x, boolean isNormalMatrix)
    {
        MatrixRules.isValidSquareMatrix(x);
        Matrix conjugateTranspose = x.getConjugateTranspose();
        Matrix conjugateTransposeTimesX = conjugateTranspose.multiply(x);
        Matrix identityMatrix = Matrix.ofIdentity(x.getNumberOfRows());
        return isNormalMatrix && conjugateTransposeTimesX.equals(identityMatrix);
    }
}