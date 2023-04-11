package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class TransposeMatrixTask extends Orion
{
    public static Matrix run(Matrix x)
    {
        MatrixRules.isValid(x);
        ANumber[][] elements = new ANumber[x.getNumberOfColumns()][x.getNumberOfRows()];
        x.forAllColumnAndRowIndices((i, j) -> elements[i][j] = x.get(j, i).getCopy());
        return Matrix.of(elements);
    }
}