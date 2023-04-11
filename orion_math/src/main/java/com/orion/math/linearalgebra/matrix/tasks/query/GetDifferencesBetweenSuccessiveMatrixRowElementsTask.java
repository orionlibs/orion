package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetDifferencesBetweenSuccessiveMatrixRowElementsTask extends Orion
{
    public static Matrix run(Matrix x)
    {
        MatrixRules.isValid(x);

        if(x.getNumberOfRows() == 1)
        {
            ANumber[][] newElements = new ANumber[1][x.getNumberOfColumns()];
            x.forAllColumnIndices(j -> newElements[0][j] = x.get(0, j).getCopy());
            return Matrix.of(newElements);
        }
        else
        {
            Matrix newMatrix = Matrix.of(x.getNumberOfRows() - 1, x.getNumberOfColumns());
            newMatrix.forAllColumnAndRowIndices((j, i) -> newMatrix.set(i, j, x.get(i + 1, j).subtractGET(x.get(i, j))));
            return newMatrix;
        }

    }
}