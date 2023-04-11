package com.orion.math.linearalgebra.matrix.tasks.convert;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetMatrixAsArrayOfArraysTask extends Orion
{
    public static ANumber[][] run(Matrix x)
    {
        MatrixRules.isValid(x);
        ANumber[][] result = new ANumber[x.getNumberOfRows()][x.getNumberOfColumns()];
        x.forAllRowIndices(i -> result[i] = x.getRow(i).getAsArray());
        return result;
    }
}