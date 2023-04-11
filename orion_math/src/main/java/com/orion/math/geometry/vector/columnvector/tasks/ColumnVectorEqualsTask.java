package com.orion.math.geometry.vector.columnvector.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.columnvector.ColumnVector;
import com.orion.math.geometry.vector.columnvector.ColumnVectorRules;
import com.orion.math.geometry.vector.columnvector.ColumnVectors;

public class ColumnVectorEqualsTask extends Orion
{
    public static boolean run(ColumnVector x, Object y)
    {
        ColumnVectorRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            ColumnVector other = (ColumnVector)y;

            if(!ColumnVectors.doColumnVectorsSizesMatch(x, other))
            {
                return false;
            }

            return x.getElements().equals(other.getElements());
        }

    }
}