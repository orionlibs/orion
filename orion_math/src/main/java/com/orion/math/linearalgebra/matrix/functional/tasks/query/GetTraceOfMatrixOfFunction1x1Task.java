package com.orion.math.linearalgebra.matrix.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class GetTraceOfMatrixOfFunction1x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function1x1<ANumber, ANumber> run(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValidSquareMatrix(x);
        Function1x1<ANumber, ANumber>[] sum = new Function1x1[1];
        sum[0] = Function1x1.Zero;
        x.forAllRowAndColumnIndices((i, j) -> i == j, (i, j) -> sum[0] = sum[0].add(x.get(i, j)));
        return sum[0];
    }
}