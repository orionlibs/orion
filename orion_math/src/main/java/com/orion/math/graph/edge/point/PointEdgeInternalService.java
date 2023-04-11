package com.orion.math.graph.edge.point;

import com.orion.math.MathObject;
import com.orion.math.graph.edge.point.tasks.PointEdgeEqualsTask;
import com.orion.math.graph.edge.point.tasks.PointEdgeHashCodeTask;

class PointEdgeInternalService implements MathObject
{
    static boolean equals(PointEdge x, Object y)
    {
        return PointEdgeEqualsTask.run(x, y);
    }


    static int hashCode(PointEdge x)
    {
        return PointEdgeHashCodeTask.run(x);
    }
}