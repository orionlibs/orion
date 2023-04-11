package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class SwapMatrixColumnsTask extends Orion
{
    public static Matrix run(Matrix x, int column1, int column2)
    {
        MatrixRules.isValid(x);
        MatrixRules.isValidColumnsInterval(x, column1, column2);
        Matrix temp = x.getCopy();
        Vector tempColumn = temp.getColumn(column1);
        temp.setColumn(column1, temp.getColumn(column2));
        temp.setColumn(column2, tempColumn);
        return temp;
    }
}