package com.orion.math.linearalgebra.matrix.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class GetMatrixOfFunction1x1RowExceptDiagonalElementTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static VectorOfFunction1x1 run(MatrixOfFunction1x1 x, int rowIndex)
    {
        MatrixOfFunction1x1Rules.isValidSquareMatrix(x);
        MatrixOfFunction1x1Rules.isValidRowIndex(x, rowIndex);
        Function1x1<ANumber, ANumber>[] rowVector = new Function1x1[x.getNumberOfColumns() - 1];
        boolean foundDiagonalElement = false;

        for(int j = 0; j < x.getNumberOfColumns(); j++)
        {

            if(j != rowIndex)
            {

                if(foundDiagonalElement)
                {
                    rowVector[j - 1] = x.get(rowIndex, j);
                }
                else
                {
                    rowVector[j] = x.get(rowIndex, j);
                }

            }
            else
            {
                foundDiagonalElement = true;
            }

        }

        return VectorOfFunction1x1.of(rowVector);
    }
}