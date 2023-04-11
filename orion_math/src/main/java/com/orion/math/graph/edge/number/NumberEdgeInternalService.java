package com.orion.math.graph.edge.number;

import com.orion.math.MathObject;
import com.orion.math.graph.edge.number.tasks.NumberEdgeEqualsTask;
import com.orion.math.graph.edge.number.tasks.NumberEdgeHashCodeTask;

class NumberEdgeInternalService implements MathObject
{
    static boolean equals(NumberEdge x, Object y)
    {
        return NumberEdgeEqualsTask.run(x, y);
    }


    static int hashCode(NumberEdge x)
    {
        return NumberEdgeHashCodeTask.run(x);
    }
}