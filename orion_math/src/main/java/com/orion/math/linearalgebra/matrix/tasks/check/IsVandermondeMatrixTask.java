package com.orion.math.linearalgebra.matrix.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class IsVandermondeMatrixTask extends Orion
{
    public static boolean run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);

        if(x.getColumn(0).findAny((int j) -> x.getColumn(0).getAsArray()[j].isNotOne()))
        {
            return false;
        }

        for(int i = 1; i < x.getNumberOfRows(); i++)
        {
            ANumber x1 = x.get(i, 1).getCopy();

            for(int j = 2; j < x.getNumberOfColumns(); j++)
            {

                if(x.get(i, j).notEqual(x.get(i, j - 1).multiplyGET(x1)))
                {
                    return false;
                }

            }

        }

        return true;
    }
}