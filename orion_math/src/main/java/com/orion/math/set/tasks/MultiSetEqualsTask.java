package com.orion.math.set.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.type.OrionHashMultiSet;
import com.orion.math.set.MultiSet;
import com.orion.math.set.SetRules;

public class MultiSetEqualsTask extends Orion
{
    @SuppressWarnings("rawtypes")
    public static boolean run(MultiSet x, Object object)
    {
        SetRules.isValid(x);

        if(object == null || x.getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            MultiSet other = (MultiSet)object;
            return ((OrionHashMultiSet)x.getElements()).equals((OrionHashMultiSet)other.getElements());
        }

    }
}