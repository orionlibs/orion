package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetExponentForMatrixToBeNilpotentTask extends Orion
{
    public static ANumber run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        Matrix newMatrix = x.getCopy();
        int i = 2;

        for(i = 2; i <= Integer.MAX_VALUE; i++)
        {
            newMatrix = newMatrix.multiply(x);

            if(newMatrix.isZeroMatrix())
            {
                break;
            }

        }

        return ANumber.of(i);
    }
}