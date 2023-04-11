package com.orion.math.geometry.vector.columnvector;

import com.orion.math.MathObject;
import com.orion.math.geometry.vector.columnvector.tasks.ColumnVectorEqualsTask;
import com.orion.math.geometry.vector.columnvector.tasks.ColumnVectorHashCodeTask;

class ColumnVectorInternalService implements MathObject
{
    static boolean equals(ColumnVector x, Object y)
    {
        return ColumnVectorEqualsTask.run(x, y);
    }


    static int hashCode(ColumnVector x)
    {
        return ColumnVectorHashCodeTask.run(x);
    }
}