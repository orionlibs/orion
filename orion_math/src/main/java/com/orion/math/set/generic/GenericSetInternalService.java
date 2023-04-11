package com.orion.math.set.generic;

import com.orion.math.MathObject;
import com.orion.math.set.generic.tasks.GenericSetEqualsTask;
import com.orion.math.set.generic.tasks.GenericSetHashCodeTask;

class GenericSetInternalService implements MathObject
{
    static boolean equals(GenericSet x, Object y)
    {
        return GenericSetEqualsTask.run(x, y);
    }


    static int hashCode(GenericSet x)
    {
        return GenericSetHashCodeTask.run(x);
    }
}