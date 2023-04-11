package com.orion.math.geometry.shape.circle.sector;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.circle.sector.tasks.CircleSectorEqualsTask;
import com.orion.math.geometry.shape.circle.sector.tasks.CircleSectorHashCodeTask;

class CircleSectorInternalService implements MathObject
{
    static boolean equals(CircleSector x, Object y)
    {
        return CircleSectorEqualsTask.run(x, y);
    }


    static int hashCode(CircleSector x)
    {
        return CircleSectorHashCodeTask.run(x);
    }
}