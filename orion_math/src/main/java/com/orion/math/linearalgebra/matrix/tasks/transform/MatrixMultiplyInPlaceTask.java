package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class MatrixMultiplyInPlaceTask extends Orion
{
    public static void run(Matrix x, Matrix y)
    {
        MatrixRules.areValid(x, y);
        MatrixRules.areMatrixSizesValidForMultiplication(x, y);
        ANumber[][] elements = new ANumber[x.getNumberOfRows()][y.getNumberOfColumns()];
        x.forAllRowIndices(i ->
        {
            y.forAllColumnIndices(j ->
            {
                elements[i][j] = x.getRow(i).getDotProduct(y.getColumn(j));
            });
        });
        x.setElementsAsArrayOfrrays(elements);
    }
}