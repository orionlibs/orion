package com.orion.math.linearalgebra.matrix.generic.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class SwapGenericMatrixColumnsTask extends Orion
{
    public static GenericMatrix run(GenericMatrix x, int column1, int column2)
    {
        GenericMatrixRules.isValid(x);
        GenericMatrixRules.isValidColumnsInterval(x, column1, column2);
        GenericMatrix temp = x.getCopy();
        GenericVector tempColumn = temp.getColumn(column1).getCopy();
        temp.setColumn(column1, temp.getColumn(column2));
        temp.setColumn(column2, tempColumn);
        return temp;
    }
}