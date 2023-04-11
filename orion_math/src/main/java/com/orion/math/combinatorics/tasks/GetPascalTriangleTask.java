package com.orion.math.combinatorics.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetPascalTriangleTask<T> extends Orion
{
    public static Matrix run(int order)
    {
        NumberRules.hasNaturalNumberValue(order);
        ANumber[][] pascal = new ANumber[order][];
        pascal[0] = new ANumber[1];
        pascal[0][0] = ANumber.of(1);

        for(int i = 1; i < order; i++)
        {
            pascal[i] = new ANumber[i + 1];

            for(int k = 1; k < pascal[i].length - 1; k++)
            {
                pascal[i][k] = pascal[i - 1][k - 1].addGET(pascal[i - 1][k]);
            }

        }

        return Matrix.of(pascal);
    }
}