package com.orion.math.set.generic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.type.OrionHashMultiSet;
import com.orion.math.set.generic.GenericMultiSet;
import com.orion.math.set.generic.GenericSetRules;

public class GenericMultiSetEqualsTask extends Orion
{
    @SuppressWarnings("rawtypes")
    public static boolean run(GenericMultiSet x, Object object)
    {
        GenericSetRules.isValid(x);

        if(object == null || x.getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            GenericMultiSet other = (GenericMultiSet)object;
            return ((OrionHashMultiSet)x.getElements()).equals((OrionHashMultiSet)other.getElements());
        }

    }
}