package com.orion.math.geometry.vector.rowvector.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.rowvector.RowVector;
import com.orion.math.geometry.vector.rowvector.RowVectorRules;
import com.orion.math.geometry.vector.rowvector.RowVectors;

public class RowVectorEqualsTask extends Orion
{
    public static boolean run(RowVector x, Object y)
    {
        RowVectorRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            RowVector other = (RowVector)y;

            if(!RowVectors.doRowVectorsSizesMatch(x, other))
            {
                return false;
            }

            return x.getElements().equals(other.getElements());
        }

    }
}