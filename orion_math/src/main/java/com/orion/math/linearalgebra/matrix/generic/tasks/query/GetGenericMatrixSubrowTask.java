package com.orion.math.linearalgebra.matrix.generic.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class GetGenericMatrixSubrowTask extends Orion
{
    public static GenericVector run(GenericMatrix x, int rowIndex, int fromColumn, int toColumn)
    {
        GenericMatrixRules.isValid(x);
        GenericMatrixRules.isValidRowIndex(x, rowIndex);
        GenericMatrixRules.isValidColumnsInterval(x, fromColumn, toColumn);
        Object[] elements = new Object[toColumn - fromColumn + 1];
        x.forColumnIndices(fromColumn, toColumn, j -> elements[j - fromColumn] = CloningService.clone(x.get(rowIndex, j)));
        return GenericVector.of(elements);
    }
}