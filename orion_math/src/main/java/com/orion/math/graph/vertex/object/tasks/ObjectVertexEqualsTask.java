package com.orion.math.graph.vertex.object.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.vertex.object.ObjectVertex;
import com.orion.math.graph.vertex.object.ObjectVertexRules;

public class ObjectVertexEqualsTask extends Orion
{
    public static boolean run(ObjectVertex x, Object y)
    {
        ObjectVertexRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            ObjectVertex other = (ObjectVertex)y;
            return x.getObject().equals(other.getObject());
        }

    }
}