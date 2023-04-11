package com.orion.math.graph.vertex.number;

import com.orion.math.MathObject;
import com.orion.math.graph.vertex.number.tasks.NumberVertexEqualsTask;
import com.orion.math.graph.vertex.number.tasks.NumberVertexHashCodeTask;

class NumberVertexInternalService implements MathObject
{
    static boolean equals(NumberVertex x, Object y)
    {
        return NumberVertexEqualsTask.run(x, y);
    }


    static int hashCode(NumberVertex x)
    {
        return NumberVertexHashCodeTask.run(x);
    }
}