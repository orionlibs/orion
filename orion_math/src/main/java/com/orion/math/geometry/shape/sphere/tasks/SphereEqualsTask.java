package com.orion.math.geometry.shape.sphere.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.sphere.Sphere;
import com.orion.math.geometry.shape.sphere.SphereRules;

public class SphereEqualsTask extends Orion
{
    public static boolean run(Sphere x, Object y)
    {
        SphereRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Sphere other = (Sphere)y;
            return x.getRadius().equal(other.getRadius());
        }

    }
}