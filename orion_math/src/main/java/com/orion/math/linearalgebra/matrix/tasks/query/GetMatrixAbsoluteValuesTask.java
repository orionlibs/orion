package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetMatrixAbsoluteValuesTask extends Orion
{
    public static Matrix run(Matrix x)
    {
        MatrixRules.isValid(x);
        ANumber[][] elements = new ANumber[x.getNumberOfRows()][x.getNumberOfColumns()];
        x.forAll((i, j) -> elements[i][j] = x.get(i, j).getAbsoluteValue());
        return Matrix.of(elements);
    }
}