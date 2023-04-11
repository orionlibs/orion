package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetRankOfMatrixTask extends Orion
{
    public static ANumber run(Matrix x)
    {
        MatrixRules.isValid(x);

        if(x.isSquareMatrix() && x.isUpperTriangular())
        {
            return x.getNumberOfNonZeroDiagonalElements();
        }
        else
        {
            return x.getQRDecomposition().getRank();
        }

    }
}