package com.orion.math.geometry.shape.ellipse;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.ellipse.tasks.EllipseEqualsTask;
import com.orion.math.geometry.shape.ellipse.tasks.EllipseHashCodeTask;

class EllipseInternalService implements MathObject
{
    static boolean equals(Ellipse x, Object y)
    {
        return EllipseEqualsTask.run(x, y);
    }


    static int hashCode(Ellipse x)
    {
        return EllipseHashCodeTask.run(x);
    }
}