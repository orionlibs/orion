package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetTraceOfMatrixTask extends Orion
{
    public static ANumber run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        ANumber sum = ANumber.of(0);
        x.forAllRowAndColumnIndices((i, j) -> i == j, (i, j) -> sum.add(x.get(i, j)));
        return sum;
    }
}