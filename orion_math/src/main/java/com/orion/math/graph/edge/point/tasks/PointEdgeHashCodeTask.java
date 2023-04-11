package com.orion.math.graph.edge.point.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.edge.point.PointEdge;
import com.orion.math.graph.edge.point.PointEdgeRules;

public class PointEdgeHashCodeTask extends Orion
{
    public static int run(PointEdge x)
    {
        PointEdgeRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getPairOfVertices().getFirst().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getPairOfVertices().getSecond().hashCode();
    }
}