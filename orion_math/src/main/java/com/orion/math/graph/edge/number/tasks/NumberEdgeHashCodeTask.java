package com.orion.math.graph.edge.number.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.edge.number.NumberEdge;
import com.orion.math.graph.edge.number.NumberEdgeRules;

public class NumberEdgeHashCodeTask extends Orion
{
    public static int run(NumberEdge x)
    {
        NumberEdgeRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getPairOfVertices().getFirst().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getPairOfVertices().getSecond().hashCode();
    }
}