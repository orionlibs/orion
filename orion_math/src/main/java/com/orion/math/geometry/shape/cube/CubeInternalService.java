package com.orion.math.geometry.shape.cube;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.cube.tasks.CubeEqualsTask;
import com.orion.math.geometry.shape.cube.tasks.CubeHashCodeTask;

class CubeInternalService implements MathObject
{
    static boolean equals(Cube x, Object y)
    {
        return CubeEqualsTask.run(x, y);
    }


    static int hashCode(Cube x)
    {
        return CubeHashCodeTask.run(x);
    }
}