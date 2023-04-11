package com.orion.math.geometry.vector.rowvector;

import com.orion.math.MathObject;
import com.orion.math.geometry.vector.rowvector.tasks.RowVectorEqualsTask;
import com.orion.math.geometry.vector.rowvector.tasks.RowVectorHashCodeTask;

class RowVectorInternalService implements MathObject
{
    static boolean equals(RowVector x, Object y)
    {
        return RowVectorEqualsTask.run(x, y);
    }


    static int hashCode(RowVector x)
    {
        return RowVectorHashCodeTask.run(x);
    }
}