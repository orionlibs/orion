package com.orion.math.geometry.vector.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;

public class GetLastIndexOfMaximumVectorElementTask extends Orion
{
    public static int run(Vector x)
    {
        VectorRules.isValid(x);
        ANumber maximum = x.get(0);
        int index = 0;

        if(x.getDimensions() > 1)
        {

            for(int i = 1; i < x.getDimensions(); i++)
            {

                if(x.get(i).isGreaterThanOrEqual(maximum))
                {
                    maximum = x.get(i);
                    index = i;
                }

            }

        }

        return index;
    }
}