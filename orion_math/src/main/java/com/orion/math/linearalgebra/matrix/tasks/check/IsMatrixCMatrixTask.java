package com.orion.math.linearalgebra.matrix.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class IsMatrixCMatrixTask extends Orion
{
    public static boolean run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);

        if((x.isSymmetric() || x.isAntiSymmetric()))
        {

            if(x.findAny((i, j) -> (i == j && x.get(i, j).isNotZero())
                            || x.get(i, j).isNotOne() && x.get(i, j).isNotMinusOne()))
            {
                return false;
            }

        }
        else
        {
            return false;
        }

        Matrix xTimesXTranspose = x.multiply(x.transpose());
        Matrix nMinus1TimesIdentityMatrix = Matrix.ofIdentity(x.getNumberOfRows()).multiply(x.getNumberOfRows() - 1);
        return xTimesXTranspose.equals(nMinus1TimesIdentityMatrix);
    }
}