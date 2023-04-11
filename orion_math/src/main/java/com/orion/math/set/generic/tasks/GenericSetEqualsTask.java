package com.orion.math.set.generic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.generic.GenericSet;
import com.orion.math.set.generic.GenericSetRules;

public class GenericSetEqualsTask extends Orion
{
    public static boolean run(GenericSet x, Object object)
    {
        GenericSetRules.isValid(x);

        if(object == null || x.getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            GenericSet other = (GenericSet)object;
            return x.getElements().equals(other.getElements());
        }

    }
}