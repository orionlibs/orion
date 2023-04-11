package com.orion.math.graph.edge.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeRules;

public class EdgeHashCodeTask extends Orion
{
    public static int run(Edge x)
    {
        EdgeRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getPair().getFirst().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getPair().getSecond().hashCode();
    }
}