package com.orion.math.geometry.vector;

import com.orion.math.MathObject;
import com.orion.math.geometry.vector.tasks.VectorEqualsTask;
import com.orion.math.geometry.vector.tasks.VectorHashCodeTask;

class VectorInternalService implements MathObject
{
    static boolean equals(Vector x, Object y)
    {
        return VectorEqualsTask.run(x, y);
    }


    static int hashCode(Vector x)
    {
        return VectorHashCodeTask.run(x);
    }
}