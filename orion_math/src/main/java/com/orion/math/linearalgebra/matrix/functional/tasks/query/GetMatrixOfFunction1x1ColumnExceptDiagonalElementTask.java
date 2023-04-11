package com.orion.math.linearalgebra.matrix.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class GetMatrixOfFunction1x1ColumnExceptDiagonalElementTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static VectorOfFunction1x1 run(MatrixOfFunction1x1 x, int columnIndex)
    {
        MatrixOfFunction1x1Rules.isValidSquareMatrix(x);
        MatrixOfFunction1x1Rules.isValidColumnIndex(x, columnIndex);
        Function1x1<ANumber, ANumber>[] columnVector = new Function1x1[x.getNumberOfRows() - 1];
        boolean foundDiagonalElement = false;

        for(int i = 0; i < x.getNumberOfRows(); i++)
        {

            if(i != columnIndex)
            {

                if(foundDiagonalElement)
                {
                    columnVector[i - 1] = x.get(i, columnIndex);
                }
                else
                {
                    columnVector[i] = x.get(i, columnIndex);
                }

            }
            else
            {
                foundDiagonalElement = true;
            }

        }

        return VectorOfFunction1x1.of(columnVector);
    }
}