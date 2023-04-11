package com.orion.math.geometry.vector.generic;

import com.orion.math.MathObject;
import com.orion.math.geometry.vector.generic.tasks.GenericVectorEqualsTask;
import com.orion.math.geometry.vector.generic.tasks.GenericVectorHashCodeTask;

class GenericVectorInternalService implements MathObject
{
    static boolean equals(GenericVector x, Object y)
    {
        return GenericVectorEqualsTask.run(x, y);
    }


    static int hashCode(GenericVector x)
    {
        return GenericVectorHashCodeTask.run(x);
    }
}