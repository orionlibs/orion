package com.orion.math.set.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.Set;
import com.orion.math.set.SetRules;

public class SetEqualsTask extends Orion
{
    public static boolean run(Set x, Object object)
    {
        SetRules.isValid(x);

        if(object == null || x.getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            Set other = (Set)object;
            return x.getElements().equals(other.getElements());
        }

    }
}