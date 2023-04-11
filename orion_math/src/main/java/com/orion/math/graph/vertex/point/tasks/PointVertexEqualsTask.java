package com.orion.math.graph.vertex.point.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.vertex.point.PointVertex;
import com.orion.math.graph.vertex.point.PointVertexRules;

public class PointVertexEqualsTask extends Orion
{
    public static boolean run(PointVertex x, Object y)
    {
        PointVertexRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            PointVertex other = (PointVertex)y;
            return x.getPoint().equals(other.getPoint());
        }

    }
}