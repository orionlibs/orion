package com.orion.math.linearalgebra.matrix.tasks.decomposition;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixIsNotPositiveDefiniteException;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.matrix.decomposition.CholeskyDecomposition;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;
import com.orion.math.streams.NumberArrayStream;

public class GetCholeskyDecompositionOfMatrixTask extends Orion
{
    public static CholeskyDecomposition run(Matrix x, int precision) throws MatrixIsNotPositiveDefiniteException
    {
        MatrixRules.isValidSquareMatrix(x);
        MatrixRules.isSymmetric(x);
        precision = Precision.getValidPrecision(precision);
        int n = x.getNumberOfRows();
        ANumber[][] elements = x.getAsArrayOfArraysCopy();
        ANumber[][] L = new ANumber[n][n];
        NumberArrayStream.setZeroValue(L);

        for(int i = 0; i < n; i++)
        {

            for(int j = 0; j <= i; j++)
            {
                ANumber sum = ANumber.of(0);

                for(int k = 0; k < j; k++)
                {
                    sum.add(L[i][k].multiplyGET(L[j][k]));
                }

                if(i == j)
                {
                    L[i][i] = elements[i][i].subtractGET(sum).getSquareRoot(precision);
                }
                else
                {
                    L[i][j] = L[j][j].reciprocateGET().multiplyGET(elements[i][j].subtractGET(sum));
                }

            }

            if(L[i][i].isNonPositive())
            {
                throw new MatrixIsNotPositiveDefiniteException("Matrix is not positive definite.");
            }

        }

        return CholeskyDecomposition.of(Matrix.of(L), Matrix.of(L).transpose());
    }
}