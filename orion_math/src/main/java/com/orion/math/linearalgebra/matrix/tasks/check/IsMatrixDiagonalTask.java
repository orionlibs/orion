package com.orion.math.linearalgebra.matrix.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class IsMatrixDiagonalTask extends Orion
{
    public static boolean run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        boolean areThereAnyNonZeroDiagonalElements = false;

        for(int i = 0; i < x.getNumberOfRows(); i++)
        {

            for(int j = 0; j < x.getNumberOfColumns(); j++)
            {

                if(i == j && x.get(i, j).isNotZero())
                {
                    areThereAnyNonZeroDiagonalElements = true;
                }

                if(i != j && x.get(i, j).isNotZero())
                {
                    return false;
                }

            }

        }

        return areThereAnyNonZeroDiagonalElements;
    }
}