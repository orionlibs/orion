package com.orion.math.linearalgebra.matrix.generic.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class TransposeGenericMatrixTask extends Orion
{
    public static GenericMatrix run(GenericMatrix x)
    {
        GenericMatrixRules.isValid(x);
        Object[][] elements = new Object[x.getNumberOfColumns()][x.getNumberOfRows()];
        x.forAllColumnAndRowIndices((i, j) -> elements[i][j] = CloningService.clone(x.get(j, i)));
        return GenericMatrix.of(elements);
    }
}