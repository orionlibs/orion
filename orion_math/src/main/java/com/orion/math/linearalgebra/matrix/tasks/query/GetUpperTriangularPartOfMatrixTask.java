package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetUpperTriangularPartOfMatrixTask extends Orion
{
    public static Matrix run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        ANumber[][] elements = x.getAsArrayOfArraysCopy();
        x.forAll((i, j) -> elements[i][j] = (i <= j) ? elements[i][j] : ANumber.of(0));
        return Matrix.of(elements);
    }
}