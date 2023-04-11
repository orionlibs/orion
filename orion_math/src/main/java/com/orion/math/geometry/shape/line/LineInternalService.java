package com.orion.math.geometry.shape.line;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.line.tasks.LineEqualsTask;
import com.orion.math.geometry.shape.line.tasks.LineHashCodeTask;

class LineInternalService implements MathObject
{
    static boolean equals(Line x, Object y)
    {
        return LineEqualsTask.run(x, y);
    }


    static int hashCode(Line x)
    {
        return LineHashCodeTask.run(x);
    }
}