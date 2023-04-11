package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class GetSubrowOfMatrixTask extends Orion
{
    public static Vector run(Matrix x, int rowIndex, int fromColumn, int toColumn)
    {
        MatrixRules.isValid(x);
        MatrixRules.isValidRowIndex(x, rowIndex);
        MatrixRules.isValidColumnsInterval(x, fromColumn, toColumn);
        Vector rowVector = Vector.of(toColumn - fromColumn + 1);
        x.forColumnIndices(fromColumn, toColumn, j -> rowVector.set(j - fromColumn, x.get(rowIndex, j).getCopy()));
        return rowVector;
    }
}