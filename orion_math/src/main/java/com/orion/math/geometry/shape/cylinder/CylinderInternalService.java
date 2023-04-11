package com.orion.math.geometry.shape.cylinder;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.cylinder.tasks.CylinderEqualsTask;
import com.orion.math.geometry.shape.cylinder.tasks.CylinderHashCodeTask;

class CylinderInternalService implements MathObject
{
    static boolean equals(Cylinder x, Object y)
    {
        return CylinderEqualsTask.run(x, y);
    }


    static int hashCode(Cylinder x)
    {
        return CylinderHashCodeTask.run(x);
    }
}