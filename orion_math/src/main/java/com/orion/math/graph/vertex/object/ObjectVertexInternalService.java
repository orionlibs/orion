package com.orion.math.graph.vertex.object;

import com.orion.math.MathObject;
import com.orion.math.graph.vertex.object.tasks.ObjectVertexEqualsTask;
import com.orion.math.graph.vertex.object.tasks.ObjectVertexHashCodeTask;

class ObjectVertexInternalService implements MathObject
{
    static boolean equals(ObjectVertex x, Object y)
    {
        return ObjectVertexEqualsTask.run(x, y);
    }


    static int hashCode(ObjectVertex x)
    {
        return ObjectVertexHashCodeTask.run(x);
    }
}