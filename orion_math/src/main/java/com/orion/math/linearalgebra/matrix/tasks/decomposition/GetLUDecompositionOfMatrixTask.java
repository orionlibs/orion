package com.orion.math.linearalgebra.matrix.tasks.decomposition;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixIsSingularException;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.matrix.decomposition.LUDecomposition;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;
import java.util.stream.IntStream;

public class GetLUDecompositionOfMatrixTask extends Orion
{
    public static LUDecomposition run(Matrix x, int precision) throws MatrixIsSingularException
    {
        MatrixRules.isValidSquareMatrix(x);
        precision = Precision.getValidPrecision(precision);
        int n = x.getNumberOfRows();
        ANumber[][] lower = new ANumber[n][n];
        ANumber[][] upper = new ANumber[n][n];
        ANumber[][] lu = x.getAsArrayOfArraysCopy();
        int[] pivot = new int[n];
        ANumber errorTolerance = ANumber.of(Precision.getEPS(precision));
        IntStream.range(0, n).forEach(i -> pivot[i] = i);

        for(int j = 0; j < n; j++)
        {

            for(int i = 0; i < j; i++)
            {
                ANumber[] luRow = lu[i];
                ANumber sum = luRow[j];

                for(int k = 0; k < i; k++)
                {
                    sum.subtract(luRow[k].multiplyGET(lu[k][j]));
                }

                luRow[j] = sum;
            }

            int max = j;
            ANumber largest = errorTolerance;

            for(int i = j; i < n; i++)
            {
                ANumber[] luRow = lu[i];
                ANumber sum = luRow[j];

                for(int k = 0; k < j; k++)
                {
                    sum.subtract(luRow[k].multiplyGET(lu[k][j]));
                }

                luRow[j] = sum;

                if(sum.getAbsoluteValue().isGreaterThan(largest))
                {
                    largest = sum.getAbsoluteValue();
                    max = i;
                }

            }

            if(lu[max][j].getAbsoluteValue().isLessThan(errorTolerance))
            {
                throw new MatrixIsSingularException("Matrix is singular.");
            }

            if(max != j)
            {
                ANumber tmp = ANumber.of(0);
                ANumber[] luMax = lu[max];
                ANumber[] luCol = lu[j];

                for(int k = 0; k < n; k++)
                {
                    tmp = luMax[k];
                    luMax[k] = luCol[k];
                    luCol[k] = tmp;
                }

                int temp = pivot[max];
                pivot[max] = pivot[j];
                pivot[j] = temp;
            }

            ANumber luDiag = lu[j][j];

            for(int i = j + 1; i < n; i++)
            {
                lu[i][j] = lu[i][j].divideGET(luDiag);
            }

        }

        x.forAll((i, j) ->
        {

            if(i < j)
            {
                lower[i][j] = ANumber.of(0);
                upper[i][j] = lu[i][j];
            }
            else if(i == j)
            {
                lower[i][j] = ANumber.of(1);
                upper[i][j] = lu[i][j];
            }
            else
            {
                lower[i][j] = lu[i][j];
                upper[i][j] = ANumber.of(0);
            }

        });
        ANumber[] pivots = new ANumber[pivot.length];
        IntStream.range(0, pivot.length).forEach(i -> pivots[i] = ANumber.of(pivot[i]));
        return LUDecomposition.of(Matrix.of(lower), Matrix.of(upper), Vector.of(pivots));
    }
}