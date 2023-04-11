package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorService;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class AugmentMatrixWithTask extends Orion
{
    public static Matrix run(Matrix x, Vector y)
    {
        return run(x, VectorService.convertToMatrix(y));
    }


    public static Matrix run(Matrix x, Matrix y)
    {
        MatrixRules.areValid(x, y);
        MatrixRules.doMatrixRowSizesMatch(x, y);
        ANumber[][] elements = new ANumber[x.getNumberOfRows()][x.getNumberOfColumns() + y.getNumberOfColumns()];

        for(int i = 0; i < x.getNumberOfRows(); i++)
        {

            for(int j = 0; j < x.getNumberOfColumns() + y.getNumberOfColumns(); j++)
            {

                if(j >= x.getNumberOfColumns())
                {
                    elements[i][j] = y.get(i, j - x.getNumberOfColumns()).getCopy();
                }
                else
                {
                    elements[i][j] = x.get(i, j).getCopy();
                }

            }

        }

        return Matrix.of(elements);
    }
}