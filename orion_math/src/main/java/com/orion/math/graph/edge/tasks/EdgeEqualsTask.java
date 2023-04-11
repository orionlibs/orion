package com.orion.math.graph.edge.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeRules;

public class EdgeEqualsTask extends Orion
{
    public static boolean run(Edge x, Object y)
    {
        EdgeRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Edge other = (Edge)y;
            return x.getPair().getFirst().equals(other.getPair().getFirst())
                            && x.getPair().getSecond().equals(other.getPair().getSecond());
        }

    }
}