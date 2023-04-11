package com.orion.math.graph.edge;

import com.orion.math.MathObject;
import com.orion.math.graph.edge.tasks.EdgeEqualsTask;
import com.orion.math.graph.edge.tasks.EdgeHashCodeTask;

class EdgeInternalService implements MathObject
{
    static boolean equals(Edge x, Object y)
    {
        return EdgeEqualsTask.run(x, y);
    }


    static int hashCode(Edge x)
    {
        return EdgeHashCodeTask.run(x);
    }
}