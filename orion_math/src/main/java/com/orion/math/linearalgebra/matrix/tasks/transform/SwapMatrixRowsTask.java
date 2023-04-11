package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class SwapMatrixRowsTask extends Orion
{
    public static Matrix run(Matrix x, int row1, int row2)
    {
        MatrixRules.isValid(x);
        MatrixRules.isValidRowsInterval(x, row1, row2);
        Matrix temp = x.getCopy();
        Vector tempVector = temp.getRow(row1);
        temp.setRow(row1, temp.getRow(row2));
        temp.setRow(row2, tempVector);
        return temp;
    }
}