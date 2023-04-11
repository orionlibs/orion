package com.orion.math.graph.edge.object.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.edge.object.ObjectEdge;
import com.orion.math.graph.edge.object.ObjectEdgeRules;

public class ObjectEdgeHashCodeTask extends Orion
{
    public static int run(ObjectEdge x)
    {
        ObjectEdgeRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getPairOfVertices().getFirst().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getPairOfVertices().getSecond().hashCode();
    }
}