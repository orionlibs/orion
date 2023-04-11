package com.orion.math.graph.vertex.point.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.vertex.point.PointVertex;
import com.orion.math.graph.vertex.point.PointVertexRules;

public class PointVertexHashCodeTask extends Orion
{
    public static int run(PointVertex x)
    {
        PointVertexRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getPoint().hashCode();
    }
}