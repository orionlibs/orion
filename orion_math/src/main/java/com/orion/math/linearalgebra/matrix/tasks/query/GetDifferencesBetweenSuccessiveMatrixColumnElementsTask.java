package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetDifferencesBetweenSuccessiveMatrixColumnElementsTask extends Orion
{
    public static Matrix run(Matrix x)
    {
        MatrixRules.isValid(x);

        if(x.getNumberOfColumns() == 1)
        {
            ANumber[][] newElements = new ANumber[x.getNumberOfRows()][1];
            x.forAllRowIndices(i -> newElements[i][0] = x.get(i, 0).getCopy());
            return Matrix.of(newElements);
        }
        else
        {
            Matrix newMatrix = Matrix.of(x.getNumberOfRows(), x.getNumberOfColumns() - 1);
            newMatrix.forAll((i, j) -> newMatrix.set(i, j, x.get(i, j + 1).subtractGET(x.get(i, j))));
            return newMatrix;
        }

    }
}