package com.orion.math.geometry.vector.functional.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.geometry.vector.functional.VectorsOfFunction1x1;

public class VectorOfFunction1x1EqualsTask extends Orion
{
    public static boolean run(VectorOfFunction1x1 x, Object y)
    {
        VectorOfFunction1x1Rules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            VectorOfFunction1x1 other = (VectorOfFunction1x1)y;

            if(!VectorsOfFunction1x1.doVectorSizesMatch(x, other))
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