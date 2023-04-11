package com.orion.math.linearalgebra.matrix.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class GetMatrixColumnCopyTask extends Orion
{
    public static Vector run(Matrix x, int columnIndex)
    {
        MatrixRules.isValid(x);
        MatrixRules.isValidColumnIndex(x, columnIndex);
        Vector columnVector = Vector.of(x.getNumberOfRows());
        x.forAllRowIndices(i -> columnVector.set(i, x.get(i, columnIndex).getCopy()));
        return columnVector;
    }
}