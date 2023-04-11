package com.orion.math.linearalgebra.matrix.functional.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;

public class IsMatrixOfFunction1x1DiagonalTask extends Orion
{
    public static boolean run(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValidSquareMatrix(x);
        boolean areThereAnyNonZeroDiagonalElements = false;

        for(int i = 0; i < x.getNumberOfRows(); i++)
        {

            for(int j = 0; j < x.getNumberOfColumns(); j++)
            {

                if(i == j && x.get(i, j).isNotZeroFunction())
                {
                    areThereAnyNonZeroDiagonalElements = true;
                }

                if(i != j && x.get(i, j).isNotZeroFunction())
                {
                    return false;
                }

            }

        }

        return areThereAnyNonZeroDiagonalElements;
    }
}