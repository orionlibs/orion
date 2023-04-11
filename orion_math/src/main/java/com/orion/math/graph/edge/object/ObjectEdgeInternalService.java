package com.orion.math.graph.edge.object;

import com.orion.math.MathObject;
import com.orion.math.graph.edge.object.tasks.ObjectEdgeEqualsTask;
import com.orion.math.graph.edge.object.tasks.ObjectEdgeHashCodeTask;

class ObjectEdgeInternalService implements MathObject
{
    static boolean equals(ObjectEdge x, Object y)
    {
        return ObjectEdgeEqualsTask.run(x, y);
    }


    static int hashCode(ObjectEdge x)
    {
        return ObjectEdgeHashCodeTask.run(x);
    }
}