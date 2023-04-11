package com.orion.math.graph.edge.number.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.edge.number.NumberEdge;
import com.orion.math.graph.edge.number.NumberEdgeRules;

public class NumberEdgeEqualsTask extends Orion
{
    public static boolean run(NumberEdge x, Object y)
    {
        NumberEdgeRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            NumberEdge other = (NumberEdge)y;
            return x.getPairOfVertices().getFirst().equals(other.getPairOfVertices().getFirst())
                            && x.getPairOfVertices().getSecond().equals(other.getPairOfVertices().getSecond());
        }

    }
}