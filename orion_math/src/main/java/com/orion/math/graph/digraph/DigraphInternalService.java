package com.orion.math.graph.digraph;

import com.orion.math.MathObject;
import com.orion.math.graph.digraph.tasks.DigraphEqualsTask;

class DigraphInternalService implements MathObject
{
    static boolean equals(Digraph x, Object y)
    {
        return DigraphEqualsTask.run(x, y);
    }
}