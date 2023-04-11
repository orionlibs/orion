package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetMatrixRowExceptDiagonalElementTask extends Orion
{
    public static Vector run(Matrix x, int rowIndex)
    {
        MatrixRules.isValidSquareMatrix(x);
        MatrixRules.isValidRowIndex(x, rowIndex);
        ANumber[] rowVector = new ANumber[x.getNumberOfColumns() - 1];
        boolean foundDiagonalElement = false;

        for(int j = 0; j < x.getNumberOfColumns(); j++)
        {

            if(j != rowIndex)
            {

                if(foundDiagonalElement)
                {
                    rowVector[j - 1] = x.get(rowIndex, j);
                }
                else
                {
                    rowVector[j] = x.get(rowIndex, j);
                }

            }
            else
            {
                foundDiagonalElement = true;
            }

        }

        return Vector.of(rowVector);
    }
}