package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class MultiplyMatrixColumnTask extends Orion
{
    public static void run(Matrix x, int columnIndex, ANumber y)
    {
        MatrixRules.isValid(x);
        NumberRules.isNotNull(y);
        Vector column = x.getColumn(columnIndex);
        column.forAllIndices(i -> column.get(i).multiply(y));
    }
}