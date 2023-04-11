package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetMatrixPeriodTask extends Orion
{
    public static ANumber run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);

        for(int i = 2; i < Integer.MAX_VALUE; i++)
        {

            if(x.multiply(x).equals(x))
            {
                return ANumber.of(i);
            }

        }

        return ANumber.of(0);
    }
}