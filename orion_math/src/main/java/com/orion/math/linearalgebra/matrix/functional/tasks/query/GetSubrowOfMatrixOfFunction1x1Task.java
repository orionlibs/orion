package com.orion.math.linearalgebra.matrix.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;

public class GetSubrowOfMatrixOfFunction1x1Task extends Orion
{
    public static VectorOfFunction1x1 run(MatrixOfFunction1x1 x, int rowIndex, int fromColumn, int toColumn)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        MatrixOfFunction1x1Rules.isValidRowIndex(x, rowIndex);
        MatrixOfFunction1x1Rules.isValidColumnsInterval(x, fromColumn, toColumn);
        VectorOfFunction1x1 rowVector = VectorOfFunction1x1.of(toColumn - fromColumn + 1);
        x.forColumnIndices(fromColumn, toColumn, j -> rowVector.set(j - fromColumn, x.get(rowIndex, j)));
        return rowVector;
    }
}