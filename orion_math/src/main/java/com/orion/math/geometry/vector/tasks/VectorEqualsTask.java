package com.orion.math.geometry.vector.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.geometry.vector.Vectors;

public class VectorEqualsTask extends Orion
{
    public static boolean run(Vector x, Object y)
    {
        VectorRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Vector other = (Vector)y;

            if(!Vectors.doVectorSizesMatch(x, other))
            {
                return false;
            }
            else if(x.getElements().equals(other.getElements())
                            || x.isZeroVector() && other.isZeroVector())
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