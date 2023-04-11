package com.orion.math.geometry.shape.sphere;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.sphere.tasks.SphereEqualsTask;
import com.orion.math.geometry.shape.sphere.tasks.SphereHashCodeTask;

class SphereInternalService implements MathObject
{
    static boolean equals(Sphere x, Object y)
    {
        return SphereEqualsTask.run(x, y);
    }


    static int hashCode(Sphere x)
    {
        return SphereHashCodeTask.run(x);
    }
}