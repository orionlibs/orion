package com.orion.math.linearalgebra.matrix.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class GetDifferencesBetweenSuccessiveMatrixOfFunction1x1RowElementsTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValid(x);

        if(x.getNumberOfRows() == 1)
        {
            Function1x1<ANumber, ANumber>[][] newElements = new Function1x1[1][x.getNumberOfColumns()];
            x.forAllColumnIndices(j -> newElements[0][j] = x.get(0, j));
            return MatrixOfFunction1x1.of(newElements);
        }
        else
        {
            MatrixOfFunction1x1 newMatrix = MatrixOfFunction1x1.of(x.getNumberOfRows() - 1, x.getNumberOfColumns());
            newMatrix.forAllColumnAndRowIndices((j, i) -> newMatrix.set(i, j, x.get(i + 1, j).subtract(x.get(i, j))));
            return newMatrix;
        }

    }
}