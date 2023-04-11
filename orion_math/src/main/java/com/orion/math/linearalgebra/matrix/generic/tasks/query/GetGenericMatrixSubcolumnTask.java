package com.orion.math.linearalgebra.matrix.generic.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class GetGenericMatrixSubcolumnTask extends Orion
{
    public static GenericVector run(GenericMatrix x, int fromRow, int toRow, int columnIndex)
    {
        GenericMatrixRules.isValid(x);
        GenericMatrixRules.isValidColumnIndex(x, columnIndex);
        GenericMatrixRules.isValidRowsInterval(x, fromRow, toRow);
        Object[] elements = new Object[toRow - fromRow + 1];
        x.forRowIndices(fromRow, toRow, i -> elements[i - fromRow] = CloningService.clone(x.get(i, columnIndex)));
        return GenericVector.of(elements);
    }
}