package com.orion.math.set;

import com.orion.math.MathObject;
import com.orion.math.set.tasks.MultiSetEqualsTask;
import com.orion.math.set.tasks.MultiSetHashCodeTask;

class MultiSetInternalService implements MathObject
{
    static boolean equals(MultiSet x, Object y)
    {
        return MultiSetEqualsTask.run(x, y);
    }


    static int hashCode(MultiSet x)
    {
        return MultiSetHashCodeTask.run(x);
    }
}