package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class MatrixAddTask extends Orion
{
    public static Matrix run(Matrix x, Matrix y)
    {
        MatrixRules.areValid(x, y);
        MatrixRules.doMatrixSizesMatch(x, y);
        ANumber[][] elements = new ANumber[x.getNumberOfRows()][x.getNumberOfColumns()];
        x.forAll((i, j) -> elements[i][j] = x.get(i, j).addGET(y.get(i, j)));
        return Matrix.of(elements);
    }
}