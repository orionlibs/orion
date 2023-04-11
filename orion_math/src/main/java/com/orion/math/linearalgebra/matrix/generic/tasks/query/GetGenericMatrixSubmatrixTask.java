package com.orion.math.linearalgebra.matrix.generic.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.object.CloningService;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class GetGenericMatrixSubmatrixTask extends Orion
{
    public static GenericMatrix run(GenericMatrix x, Object[][] elementsArray, int fromRow, int toRow, int fromColumn, int toColumn)
    {
        GenericMatrixRules.areValidDimensionIntervals(x, fromRow, toRow, fromColumn, toColumn);
        OrionList<GenericVector> elements = OrionArrayList.of();
        x.forRowIndices(fromRow, toRow, i ->
        {
            Object[] temp = new Object[toColumn - fromColumn + 1];
            x.forColumnIndices(fromColumn, toColumn, j -> temp[j - fromColumn] = CloningService.clone(elementsArray[i][j]));
            elements.append(GenericVector.of(temp));
        });
        return GenericMatrix.of(elements);
    }
}