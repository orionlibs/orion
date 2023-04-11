package com.orion.math.geometry.vector.functional;

import com.orion.math.MathObject;
import com.orion.math.geometry.vector.functional.tasks.VectorOfFunction1x1EqualsTask;
import com.orion.math.geometry.vector.functional.tasks.VectorOfFunction1x1HashCodeTask;

class VectorOfFunction1x1InternalService implements MathObject
{
    static boolean equals(VectorOfFunction1x1 x, Object y)
    {
        return VectorOfFunction1x1EqualsTask.run(x, y);
    }


    static int hashCode(VectorOfFunction1x1 x)
    {
        return VectorOfFunction1x1HashCodeTask.run(x);
    }
}