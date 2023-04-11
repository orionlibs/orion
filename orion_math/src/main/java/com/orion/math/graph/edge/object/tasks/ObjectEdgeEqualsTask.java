package com.orion.math.graph.edge.object.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.edge.object.ObjectEdge;
import com.orion.math.graph.edge.object.ObjectEdgeRules;

public class ObjectEdgeEqualsTask extends Orion
{
    public static boolean run(ObjectEdge x, Object y)
    {
        ObjectEdgeRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            ObjectEdge other = (ObjectEdge)y;
            return x.getPairOfVertices().getFirst().equals(other.getPairOfVertices().getFirst())
                            && x.getPairOfVertices().getSecond().equals(other.getPairOfVertices().getSecond());
        }

    }
}