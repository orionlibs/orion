package com.orion.math.linearalgebra.matrix.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;

public class GetColumnOfMatrixOfFunction1x1Task extends Orion
{
    public static VectorOfFunction1x1 run(MatrixOfFunction1x1 x, int columnIndex)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        MatrixOfFunction1x1Rules.isValidColumnIndex(x, columnIndex);
        VectorOfFunction1x1 columnVector = VectorOfFunction1x1.of(x.getNumberOfRows());
        x.forAllRowIndices(i -> columnVector.set(i, x.get(i, columnIndex)));
        return columnVector;
    }
}