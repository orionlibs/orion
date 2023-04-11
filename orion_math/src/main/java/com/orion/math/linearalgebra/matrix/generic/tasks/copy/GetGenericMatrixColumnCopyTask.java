package com.orion.math.linearalgebra.matrix.generic.tasks.copy;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class GetGenericMatrixColumnCopyTask extends Orion
{
    public static GenericVector run(GenericMatrix x, int columnIndex)
    {
        GenericMatrixRules.isValid(x);
        GenericMatrixRules.isValidColumnIndex(x, columnIndex);
        GenericVector columnVector = GenericVector.of(x.getNumberOfRows());
        x.forAllRowIndices(i -> columnVector.set(i, CloningService.clone(x.get(i, columnIndex))));
        return columnVector;
    }
}