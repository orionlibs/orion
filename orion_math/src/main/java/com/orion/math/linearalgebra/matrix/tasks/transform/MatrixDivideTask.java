package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class MatrixDivideTask extends Orion
{
    public static Matrix run(Matrix x, ANumber y)
    {
        MatrixRules.isValid(x);
        NumberRules.isNotNull(y);
        ANumber[][] elements = new ANumber[x.getNumberOfRows()][x.getNumberOfColumns()];
        x.forAll((i, j) -> elements[i][j] = x.get(i, j).divideGET(y));
        return Matrix.of(elements);
    }
}