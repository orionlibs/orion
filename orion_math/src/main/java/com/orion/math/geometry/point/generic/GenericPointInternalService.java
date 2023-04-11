package com.orion.math.geometry.point.generic;

import com.orion.math.MathObject;
import com.orion.math.geometry.point.generic.tasks.GenericPointEqualsTask;
import com.orion.math.geometry.point.generic.tasks.GenericPointHashCodeTask;

class GenericPointInternalService implements MathObject
{
    static boolean equals(GenericPoint x, Object y)
    {
        return GenericPointEqualsTask.run(x, y);
    }


    static int hashCode(GenericPoint x)
    {
        return GenericPointHashCodeTask.run(x);
    }
}