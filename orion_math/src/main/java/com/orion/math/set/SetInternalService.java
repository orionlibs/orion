package com.orion.math.set;

import com.orion.math.MathObject;
import com.orion.math.set.tasks.SetEqualsTask;
import com.orion.math.set.tasks.SetHashCodeTask;

class SetInternalService implements MathObject
{
    static boolean equals(Set x, Object y)
    {
        return SetEqualsTask.run(x, y);
    }


    static int hashCode(Set x)
    {
        return SetHashCodeTask.run(x);
    }
}