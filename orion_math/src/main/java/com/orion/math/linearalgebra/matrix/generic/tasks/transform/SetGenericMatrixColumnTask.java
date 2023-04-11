package com.orion.math.linearalgebra.matrix.generic.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class SetGenericMatrixColumnTask extends Orion
{
    public static void run(GenericMatrix x, int columnIndex, GenericVector elements)
    {
        GenericMatrixRules.isValid(x);
        GenericMatrixRules.isValidColumnIndex(x, columnIndex);
        GenericMatrixRules.doMatrixRowsAndVectorSizeMatch(x, elements);
        Object[][] elementsTemp = x.getAsArrayOfArrays();
        x.forAllRowIndices(i -> elementsTemp[i][columnIndex] = CloningService.clone(elements.get(i)));
        x.setElementsAsArrayOfrrays(elementsTemp);
    }
}