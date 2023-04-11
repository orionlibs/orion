package com.orion.math.graph.edge.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.number.NumberEdge;
import com.orion.math.graph.edge.object.ObjectEdge;
import com.orion.math.graph.edge.point.PointEdge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.graph.vertex.object.ObjectVertex;
import com.orion.math.graph.vertex.point.PointVertex;

public class CreateEdgeBetween2VerticesTask extends Orion
{
    public static Edge run(GraphType graphType, Vertex v1, Vertex v2)
    {
        VertexRules.haveSameType(v1, v2);

        if(graphType.is(GraphType.Number))
        {
            return NumberEdge.of((NumberVertex)v1, (NumberVertex)v2);
        }
        else if(graphType.is(GraphType.Point))
        {
            return PointEdge.of((PointVertex)v1, (PointVertex)v2);
        }
        else
        {
            return ObjectEdge.of((ObjectVertex)v1, (ObjectVertex)v2);
        }

    }
}