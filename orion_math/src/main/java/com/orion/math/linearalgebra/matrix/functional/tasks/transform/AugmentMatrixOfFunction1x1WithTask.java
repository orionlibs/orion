package com.orion.math.linearalgebra.matrix.functional.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Service;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class AugmentMatrixOfFunction1x1WithTask extends Orion
{
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return run(x, VectorOfFunction1x1Service.convertToMatrix(y));
    }


    @SuppressWarnings("unchecked")
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x, MatrixOfFunction1x1 y)
    {
        MatrixOfFunction1x1Rules.areValid(x, y);
        MatrixOfFunction1x1Rules.doMatrixRowSizesMatch(x, y);
        Function1x1<ANumber, ANumber>[][] elements = new Function1x1[x.getNumberOfRows()][x.getNumberOfColumns() + y.getNumberOfColumns()];

        for(int i = 0; i < x.getNumberOfRows(); i++)
        {

            for(int j = 0; j < x.getNumberOfColumns() + y.getNumberOfColumns(); j++)
            {

                if(j >= x.getNumberOfColumns())
                {
                    elements[i][j] = y.get(i, j - x.getNumberOfColumns());
                }
                else
                {
                    elements[i][j] = x.get(i, j);
                }

            }

        }

        return MatrixOfFunction1x1.of(elements);
    }
}