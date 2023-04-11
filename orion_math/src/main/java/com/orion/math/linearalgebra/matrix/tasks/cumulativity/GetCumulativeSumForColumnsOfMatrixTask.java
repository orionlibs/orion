package com.orion.math.linearalgebra.matrix.tasks.cumulativity;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetCumulativeSumForColumnsOfMatrixTask extends Orion
{
    public static Matrix run(Matrix x)
    {
        MatrixRules.isValid(x);
        ANumber[][] newElements = new ANumber[x.getNumberOfRows()][x.getNumberOfColumns()];
        x.forAllColumnIndices(j ->
        {
            ANumber sum = ANumber.of(0);
            x.forAllRowIndices(i ->
            {
                sum.add(x.get(i, j));
                newElements[i][j] = sum.getCopy();
            });
        });
        return Matrix.of(newElements);
    }
}