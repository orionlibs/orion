package com.orion.math.linearalgebra.matrix.generic.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class IsGenericMatrixDiagonalTask extends Orion
{
    public static boolean run(GenericMatrix x)
    {
        GenericMatrixRules.isValidSquareMatrix(x);
        boolean areThereAnyNonZeroDiagonalElements = false;

        for(int i = 0; i < x.getNumberOfRows(); i++)
        {

            for(int j = 0; j < x.getNumberOfColumns(); j++)
            {

                if(i == j && x.get(i, j) != null)
                {
                    areThereAnyNonZeroDiagonalElements = true;
                }

                if(i != j && x.get(i, j) != null)
                {
                    return false;
                }

            }

        }

        return areThereAnyNonZeroDiagonalElements;
    }
}