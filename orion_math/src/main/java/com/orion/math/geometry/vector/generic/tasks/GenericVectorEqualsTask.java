package com.orion.math.geometry.vector.generic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.geometry.vector.generic.GenericVectorRules;

public class GenericVectorEqualsTask extends Orion
{
    public static boolean run(GenericVector x, Object y)
    {
        GenericVectorRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            GenericVector other = (GenericVector)y;
            return x.getElements().equals(other.getElements());
        }

    }
}