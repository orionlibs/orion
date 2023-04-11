package com.orion.math.set.generic;

import com.orion.math.MathObject;
import com.orion.math.set.generic.tasks.GenericMultiSetEqualsTask;
import com.orion.math.set.generic.tasks.GenericMultiSetHashCodeTask;

class GenericMultiSetInternalService implements MathObject
{
    static boolean equals(GenericMultiSet x, Object y)
    {
        return GenericMultiSetEqualsTask.run(x, y);
    }


    static int hashCode(GenericMultiSet x)
    {
        return GenericMultiSetHashCodeTask.run(x);
    }
}