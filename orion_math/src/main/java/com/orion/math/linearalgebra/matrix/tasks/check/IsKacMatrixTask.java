package com.orion.math.linearalgebra.matrix.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class IsKacMatrixTask extends Orion
{
    public static boolean run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        ANumber n = ANumber.of(x.getNumberOfRows() - 1);
        ANumber k = ANumber.of(1);

        for(int i = 0; i < x.getNumberOfRows(); i++)
        {

            for(int j = 0; j < x.getNumberOfColumns(); j++)
            {

                if(j - i == 1 && x.get(i, j).notEqual(n))
                {
                    return false;
                }
                else if(i - j == 1 && x.get(i, j).notEqual(k))
                {
                    return false;
                }
                else if(x.get(i, j).isNotZero())
                {
                    return false;
                }

                n.subtractOne();
                k.addOne();
            }

        }

        return true;
    }
}