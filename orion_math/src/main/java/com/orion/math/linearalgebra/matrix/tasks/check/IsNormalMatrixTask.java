package com.orion.math.linearalgebra.matrix.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class IsNormalMatrixTask extends Orion
{
    public static boolean run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        Matrix conjugateTranspose = x.getConjugateTranspose();
        Matrix conjugateTransposeTimesX = conjugateTranspose.multiply(x);
        Matrix xTimesConjugateTranspose = x.multiply(conjugateTranspose);
        return conjugateTransposeTimesX.equals(xTimesConjugateTranspose);
    }
}