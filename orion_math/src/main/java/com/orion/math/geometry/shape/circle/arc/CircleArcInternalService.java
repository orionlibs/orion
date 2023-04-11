package com.orion.math.geometry.shape.circle.arc;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.circle.arc.tasks.CircleArcEqualsTask;
import com.orion.math.geometry.shape.circle.arc.tasks.CircleArcHashCodeTask;

class CircleArcInternalService implements MathObject
{
    static boolean equals(CircleArc x, Object y)
    {
        return CircleArcEqualsTask.run(x, y);
    }


    static int hashCode(CircleArc x)
    {
        return CircleArcHashCodeTask.run(x);
    }
}