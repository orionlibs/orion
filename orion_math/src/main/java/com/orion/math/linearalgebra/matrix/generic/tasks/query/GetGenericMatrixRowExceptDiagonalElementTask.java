package com.orion.math.linearalgebra.matrix.generic.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class GetGenericMatrixRowExceptDiagonalElementTask extends Orion
{
    public static GenericVector run(GenericMatrix x, int rowIndex)
    {
        GenericMatrixRules.isValid(x);
        GenericMatrixRules.isValidRowIndex(x, rowIndex);
        Object[] rowVector = new Object[x.getNumberOfColumns() - 1];
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

        return GenericVector.of(rowVector);
    }
}