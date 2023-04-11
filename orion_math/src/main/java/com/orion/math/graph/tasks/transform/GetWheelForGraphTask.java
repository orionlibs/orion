package com.orion.math.graph.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.exception.Assert;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.number.NumberEdge;
import com.orion.math.graph.edge.object.ObjectEdge;
import com.orion.math.graph.edge.point.PointEdge;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.graph.vertex.object.ObjectVertex;
import com.orion.math.graph.vertex.point.PointVertex;
import java.util.ArrayList;
import java.util.List;

public class GetWheelForGraphTask extends Orion
{
    public static Edge[] run(Graph graph, Path cycle, Vertex vertex)
    {
        GraphRules.isValid(graph);
        GraphRules.isPathInGraph(graph, cycle);
        GraphRules.isVertexInGraph(graph, vertex);
        GraphType type = graph.getType();
        OrionList<Vertex> cycleVertices = cycle.getVerticesAsList();
        List<Edge> newEdges = new ArrayList<>(cycle.getEdges());

        for(Vertex vertexInCycle : cycleVertices)
        {

            if(type.is(GraphType.Number))
            {
                Assert.isTrue(vertex instanceof NumberVertex, "The given vertex input has to be of type NumberVertex");
                newEdges.add(NumberEdge.of((NumberVertex)vertex, (NumberVertex)vertexInCycle));
            }
            else if(type.is(GraphType.Point))
            {
                Assert.isTrue(vertex instanceof PointVertex, "The given vertex input has to be of type PointVertex");
                newEdges.add(PointEdge.of((PointVertex)vertex, (PointVertex)vertexInCycle));
            }
            else if(type.is(GraphType.Object))
            {
                Assert.isTrue(vertex instanceof ObjectVertex, "The given vertex input has to be of type ObjectVertex");
                newEdges.add(ObjectEdge.of((ObjectVertex)vertex, (ObjectVertex)vertexInCycle));
            }

        }

        return newEdges.toArray(new Edge[0]);
    }
}