package com.orion.math.geometry.shape.rectangle;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.rectangle.tasks.RectangleEqualsTask;
import com.orion.math.geometry.shape.rectangle.tasks.RectangleHashCodeTask;

class RectangleInternalService implements MathObject
{
    static boolean equals(Rectangle x, Object y)
    {
        return RectangleEqualsTask.run(x, y);
    }


    static int hashCode(Rectangle x)
    {
        return RectangleHashCodeTask.run(x);
    }
}