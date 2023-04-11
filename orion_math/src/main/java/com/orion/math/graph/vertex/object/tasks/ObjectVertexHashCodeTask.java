package com.orion.math.graph.vertex.object.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.vertex.object.ObjectVertex;
import com.orion.math.graph.vertex.object.ObjectVertexRules;

public class ObjectVertexHashCodeTask extends Orion
{
    public static int run(ObjectVertex x)
    {
        ObjectVertexRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getObject().hashCode();
    }
}