package com.orion.math.geometry.shape.triangle;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.triangle.tasks.TriangleEqualsTask;
import com.orion.math.geometry.shape.triangle.tasks.TriangleHashCodeTask;

class TriangleInternalService implements MathObject
{
    static boolean equals(Triangle x, Object y)
    {
        return TriangleEqualsTask.run(x, y);
    }


    static int hashCode(Triangle x)
    {
        return TriangleHashCodeTask.run(x);
    }
}