package com.orion.math.linearalgebra.matrix.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrices;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class MatrixEqualsTask extends Orion
{
    public static boolean run(Matrix x, Object y)
    {
        MatrixRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Matrix other = (Matrix)y;

            if(!Matrices.doMatrixSizesMatch(x, other))
            {
                return false;
            }
            else if(x.getAsList().equals(other.getAsList()))
            {
                return true;
            }
            else
            {
                return false;
            }

        }

    }
}