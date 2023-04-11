package com.orion.math.linearalgebra.matrix.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class GetDifferencesBetweenSuccessiveMatrixOfFunction1x1ColumnElementsTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValid(x);

        if(x.getNumberOfColumns() == 1)
        {
            Function1x1<ANumber, ANumber>[][] newElements = new Function1x1[x.getNumberOfRows()][1];
            x.forAllRowIndices(i -> newElements[i][0] = x.get(i, 0));
            return MatrixOfFunction1x1.of(newElements);
        }
        else
        {
            MatrixOfFunction1x1 newMatrix = MatrixOfFunction1x1.of(x.getNumberOfRows(), x.getNumberOfColumns() - 1);
            newMatrix.forAll((i, j) -> newMatrix.set(i, j, x.get(i, j + 1).subtract(x.get(i, j))));
            return newMatrix;
        }

    }
}