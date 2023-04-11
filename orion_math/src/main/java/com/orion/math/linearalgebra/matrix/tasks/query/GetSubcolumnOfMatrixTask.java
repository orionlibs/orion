package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class GetSubcolumnOfMatrixTask extends Orion
{
    public static Vector run(Matrix x, int fromRow, int toRow, int columnIndex)
    {
        MatrixRules.isValid(x);
        MatrixRules.isValidColumnIndex(x, columnIndex);
        MatrixRules.isValidRowsInterval(x, fromRow, toRow);
        Vector columnVector = Vector.of(toRow - fromRow + 1);
        x.forRowIndices(fromRow, toRow, i -> columnVector.set(i - fromRow, x.get(i, columnIndex).getCopy()));
        return columnVector;
    }
}