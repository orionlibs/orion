package com.orion.math.geometry.vector.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;

public class GetLastIndexOfMinimumVectorElementTask extends Orion
{
    public static int run(Vector x)
    {
        VectorRules.isValid(x);
        ANumber minimum = x.get(0);
        int index = 0;

        if(x.getDimensions() > 1)
        {

            for(int i = 1; i < x.getDimensions(); i++)
            {

                if(x.get(i).isLessThanOrEqual(minimum))
                {
                    minimum = x.get(i);
                    index = i;
                }

            }

        }

        return index;
    }
}