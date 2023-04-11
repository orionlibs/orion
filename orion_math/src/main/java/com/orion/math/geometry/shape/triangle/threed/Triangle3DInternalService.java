package com.orion.math.geometry.shape.triangle.threed;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.triangle.threed.tasks.Triangle3DEqualsTask;
import com.orion.math.geometry.shape.triangle.threed.tasks.Triangle3DHashCodeTask;

class Triangle3DInternalService implements MathObject
{
    static boolean equals(Triangle3D x, Object y)
    {
        return Triangle3DEqualsTask.run(x, y);
    }


    static int hashCode(Triangle3D x)
    {
        return Triangle3DHashCodeTask.run(x);
    }
}