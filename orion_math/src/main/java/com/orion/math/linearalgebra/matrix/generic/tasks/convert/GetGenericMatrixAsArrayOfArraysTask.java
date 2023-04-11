package com.orion.math.linearalgebra.matrix.generic.tasks.convert;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class GetGenericMatrixAsArrayOfArraysTask extends Orion
{
    public static Object[][] run(GenericMatrix x)
    {
        GenericMatrixRules.isValid(x);
        Object[][] result = new Object[x.getNumberOfRows()][x.getNumberOfColumns()];
        x.forAllRowIndices(i -> result[i] = x.getRow(i).getAsArray());
        return result;
    }
}