package com.orion.math.linearalgebra.matrix.generic.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class GetGenericMatrixColumnExceptDiagonalElementTask extends Orion
{
    public static GenericVector run(GenericMatrix x, int columnIndex)
    {
        GenericMatrixRules.isValid(x);
        GenericMatrixRules.isValidColumnIndex(x, columnIndex);
        Object[] columnVector = new Object[x.getNumberOfRows() - 1];
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

        return GenericVector.of(columnVector);
    }
}