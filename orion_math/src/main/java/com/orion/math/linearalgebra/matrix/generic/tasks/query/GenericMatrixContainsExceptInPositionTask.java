package com.orion.math.linearalgebra.matrix.generic.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;
import com.orion.math.number.NumberRules;

public class GenericMatrixContainsExceptInPositionTask extends Orion
{
    public static boolean run(GenericMatrix x, Object y, int rowIndex, int columnIndex)
    {
        GenericMatrixRules.isValid(x);
        GenericMatrixRules.isValidRowIndex(x, rowIndex);
        GenericMatrixRules.isValidColumnIndex(x, columnIndex);
        NumberRules.isNotNull(y);
        return x.findAny((i, j) -> i != rowIndex && j != columnIndex && x.get(i, j).equals(y));
    }
}