package com.orion.math.linearalgebra.matrix.generic.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.geometry.vector.generic.GenericVectorService;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class AugmentGenericMatrixWithTask extends Orion
{
    public static GenericMatrix run(GenericMatrix x, GenericVector y)
    {
        return run(x, GenericVectorService.convertToMatrix(y));
    }


    public static GenericMatrix run(GenericMatrix x, GenericMatrix y)
    {
        GenericMatrixRules.areValid(x, y);
        GenericMatrixRules.doMatrixRowSizesMatch(x, y);
        Object[][] elements = new Object[x.getNumberOfRows()][x.getNumberOfColumns() + y.getNumberOfColumns()];

        for(int i = 0; i < x.getNumberOfRows(); i++)
        {

            for(int j = 0; j < x.getNumberOfColumns() + y.getNumberOfColumns(); j++)
            {

                if(j >= x.getNumberOfColumns())
                {
                    elements[i][j] = CloningService.clone(y.get(i, j - x.getNumberOfColumns()));
                }
                else
                {
                    elements[i][j] = CloningService.clone(x.get(i, j));
                }

            }

        }

        return GenericMatrix.of(elements);
    }
}