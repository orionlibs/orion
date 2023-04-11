package com.orion.math.linearalgebra.matrix.tasks.cumulativity;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetCumulativeProductForRowsOfMatrixTask extends Orion
{
    public static Matrix run(Matrix x)
    {
        MatrixRules.isValid(x);
        ANumber[][] newElements = new ANumber[x.getNumberOfRows()][x.getNumberOfColumns()];
        x.forAllRowIndices(i ->
        {
            ANumber product = ANumber.of(1);
            x.forAllColumnIndices(j ->
            {
                product.multiply(x.get(i, j));
                newElements[i][j] = product.getCopy();
            });
        });
        return Matrix.of(newElements);
    }
}