package com.orion.math.geometry.point.polar;

import com.orion.math.MathObject;
import com.orion.math.geometry.point.polar.tasks.PolarPointEqualsTask;
import com.orion.math.geometry.point.polar.tasks.PolarPointHashCodeTask;

class PolarPointInternalService implements MathObject
{
    static boolean equals(PolarPoint x, Object y)
    {
        return PolarPointEqualsTask.run(x, y);
    }


    static int hashCode(PolarPoint x)
    {
        return PolarPointHashCodeTask.run(x);
    }
}