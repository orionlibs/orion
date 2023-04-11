package com.orion.math.graph.edge.point.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.edge.point.PointEdge;
import com.orion.math.graph.edge.point.PointEdgeRules;

public class PointEdgeEqualsTask extends Orion
{
    public static boolean run(PointEdge x, Object y)
    {
        PointEdgeRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            PointEdge other = (PointEdge)y;
            return x.getPairOfVertices().getFirst().equals(other.getPairOfVertices().getFirst())
                            && x.getPairOfVertices().getSecond().equals(other.getPairOfVertices().getSecond());
        }

    }
}