package com.orion.math.graph.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;

public class GraphHashCodeTask extends Orion
{
    public static int run(Graph x)
    {
        GraphRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getVertices().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getEdges().hashCode();
    }
}