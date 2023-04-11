package com.orion.math.graph.vertex.point;

import com.orion.math.MathObject;
import com.orion.math.graph.vertex.point.tasks.PointVertexEqualsTask;
import com.orion.math.graph.vertex.point.tasks.PointVertexHashCodeTask;

class PointVertexInternalService implements MathObject
{
    static boolean equals(PointVertex x, Object y)
    {
        return PointVertexEqualsTask.run(x, y);
    }


    static int hashCode(PointVertex x)
    {
        return PointVertexHashCodeTask.run(x);
    }
}