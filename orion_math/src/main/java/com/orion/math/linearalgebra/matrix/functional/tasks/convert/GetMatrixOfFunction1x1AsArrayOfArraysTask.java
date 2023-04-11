package com.orion.math.linearalgebra.matrix.functional.tasks.convert;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class GetMatrixOfFunction1x1AsArrayOfArraysTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function1x1<ANumber, ANumber>[][] run(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        Function1x1<ANumber, ANumber>[][] result = new Function1x1[x.getNumberOfRows()][x.getNumberOfColumns()];
        x.forAllRowIndices(i -> result[i] = x.getRow(i).getAsArray());
        return result;
    }
}