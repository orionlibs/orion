package com.orion.math.linearalgebra.matrix.generic.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class GetGenericMatrixLowerTriangularPartTask extends Orion
{
    public static GenericMatrix run(GenericMatrix x)
    {
        GenericMatrixRules.isValidSquareMatrix(x);
        Object[][] elements = x.getAsArrayOfArraysCopy();
        x.forAll((i, j) -> elements[i][j] = (i >= j) ? elements[i][j] : null);
        return GenericMatrix.of(elements);
    }
}