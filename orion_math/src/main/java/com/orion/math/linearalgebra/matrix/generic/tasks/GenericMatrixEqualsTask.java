package com.orion.math.linearalgebra.matrix.generic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrices;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;

public class GenericMatrixEqualsTask extends Orion
{
    public static boolean run(GenericMatrix x, Object y)
    {
        GenericMatrixRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            GenericMatrix other = (GenericMatrix)y;

            if(!GenericMatrices.doMatrixSizesMatch(x, other))
            {
                return false;
            }

            return x.getElements().equals(other.getElements());
        }

    }
}