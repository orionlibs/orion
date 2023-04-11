package com.orion.core.tuple.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.NTuple;
import java.util.Arrays;

public class EqualsForNTupleTask extends Orion
{
    public static boolean run(Object object1, Object object2)
    {

        if(object2 == null || object1.getClass() != object2.getClass())
        {
            return false;
        }
        else
        {
            NTuple thisObject = (NTuple)object1;
            NTuple other = (NTuple)object2;
            return Arrays.equals(thisObject.getElements(), other.getElements());
        }

    }
}