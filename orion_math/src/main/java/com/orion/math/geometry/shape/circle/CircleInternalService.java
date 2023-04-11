package com.orion.math.geometry.shape.circle;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.circle.tasks.CircleEqualsTask;
import com.orion.math.geometry.shape.circle.tasks.CircleHashCodeTask;

class CircleInternalService implements MathObject
{
    static boolean equals(Circle x, Object y)
    {
        return CircleEqualsTask.run(x, y);
    }


    static int hashCode(Circle x)
    {
        return CircleHashCodeTask.run(x);
    }
}