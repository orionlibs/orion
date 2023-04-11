package com.orion.math.linearalgebra.matrix.functional.tasks.cumulativity;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class GetCumulativeSumForRowsOfMatrixOfFunction1x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        Function1x1<ANumber, ANumber>[][] newElements = new Function1x1[x.getNumberOfRows()][x.getNumberOfColumns()];
        x.forAllRowIndices(i ->
        {
            Function1x1<ANumber, ANumber>[] sum = new Function1x1[1];
            sum[0] = Function1x1.Zero;
            x.forAllColumnIndices(j ->
            {
                sum[0] = sum[0].add(x.get(i, j));
                newElements[i][j] = sum[0];
            });
        });
        return MatrixOfFunction1x1.of(newElements);
    }
}