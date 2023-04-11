package com.orion.math.graph.vertex.number.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.graph.vertex.number.NumberVertexRules;

public class NumberVertexHashCodeTask extends Orion
{
    public static int run(NumberVertex x)
    {
        NumberVertexRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getPoint().hashCode();
    }
}