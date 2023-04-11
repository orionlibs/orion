package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetHadamartMatrixTask extends Orion
{
    public static Matrix run(int order)
    {
        NumberRules.hasNaturalNumberValue(order);
        ANumber[][] hadamard = new ANumber[order][order];
        hadamard[0][0] = ANumber.of(1);

        for(int k = 1; k < order; k += k)
        {

            for(int i = 0; i < k; i++)
            {

                for(int j = 0; j < k; j++)
                {
                    hadamard[i + k][j] = hadamard[i][j];
                    hadamard[i][j + k] = hadamard[i][j];
                    hadamard[i + k][j + k] = (hadamard[i][j].isOne()) ? ANumber.of(0) : ANumber.of(1);
                }

            }

        }

        return Matrix.of(hadamard);
    }
}