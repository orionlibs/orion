package com.orion.math.linearalgebra.matrix.generic.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class SwapGenericMatrixRowsTask extends Orion
{
    public static GenericMatrix run(GenericMatrix x, int row1, int row2)
    {
        GenericMatrixRules.isValid(x);
        GenericMatrixRules.isValidRowsInterval(x, row1, row2);
        GenericMatrix temp = x.getCopy();
        GenericVector tempVector = temp.getRow(row1).getCopy();
        temp.setRow(row1, temp.getRow(row2));
        temp.setRow(row2, tempVector);
        return temp;
    }
}