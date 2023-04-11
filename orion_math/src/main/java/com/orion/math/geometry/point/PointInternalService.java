package com.orion.math.geometry.point;

import com.orion.math.MathObject;
import com.orion.math.geometry.point.tasks.PointEqualsTask;
import com.orion.math.geometry.point.tasks.PointHashCodeTask;

class PointInternalService implements MathObject
{
    static boolean equals(Point x, Object y)
    {
        return PointEqualsTask.run(x, y);
    }


    static int hashCode(Point x)
    {
        return PointHashCodeTask.run(x);
    }
}