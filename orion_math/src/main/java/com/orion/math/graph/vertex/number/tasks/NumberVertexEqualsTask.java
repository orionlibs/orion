package com.orion.math.graph.vertex.number.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.graph.vertex.number.NumberVertexRules;

public class NumberVertexEqualsTask extends Orion
{
    public static boolean run(NumberVertex x, Object y)
    {
        NumberVertexRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            NumberVertex other = (NumberVertex)y;
            return x.getPoint().equal(other.getPoint());
        }

    }
}