package com.orion.math.geometry.shape.square;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.rectangle.tasks.RectangleEqualsTask;
import com.orion.math.geometry.shape.rectangle.tasks.RectangleHashCodeTask;

class SquareInternalService implements MathObject
{
    static boolean equals(Square x, Object y)
    {
        return RectangleEqualsTask.run(x, y);
    }


    static int hashCode(Square x)
    {
        return RectangleHashCodeTask.run(x);
    }
}