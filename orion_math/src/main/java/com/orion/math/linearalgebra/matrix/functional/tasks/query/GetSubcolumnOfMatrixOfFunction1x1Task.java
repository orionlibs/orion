package com.orion.math.linearalgebra.matrix.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;

public class GetSubcolumnOfMatrixOfFunction1x1Task extends Orion
{
    public static VectorOfFunction1x1 run(MatrixOfFunction1x1 x, int fromRow, int toRow, int columnIndex)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        MatrixOfFunction1x1Rules.isValidColumnIndex(x, columnIndex);
        MatrixOfFunction1x1Rules.isValidRowsInterval(x, fromRow, toRow);
        VectorOfFunction1x1 columnVector = VectorOfFunction1x1.of(toRow - fromRow + 1);
        x.forRowIndices(fromRow, toRow, i -> columnVector.set(i - fromRow, x.get(i, columnIndex)));
        return columnVector;
    }
}