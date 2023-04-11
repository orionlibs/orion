package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetMatrixColumnExceptDiagonalElementTask extends Orion
{
    public static Vector run(Matrix x, int columnIndex)
    {
        MatrixRules.isValidSquareMatrix(x);
        MatrixRules.isValidColumnIndex(x, columnIndex);
        ANumber[] columnVector = new ANumber[x.getNumberOfRows() - 1];
        boolean foundDiagonalElement = false;

        for(int i = 0; i < x.getNumberOfRows(); i++)
        {

            if(i != columnIndex)
            {

                if(foundDiagonalElement)
                {
                    columnVector[i - 1] = x.get(i, columnIndex);
                }
                else
                {
                    columnVector[i] = x.get(i, columnIndex);
                }

            }
            else
            {
                foundDiagonalElement = true;
            }

        }

        return Vector.of(columnVector);
    }
}