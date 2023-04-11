package com.orion.math.graph.tasks.degree;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.number.ANumber;

public class GetIndegreeOfVertexTask extends Orion
{
    public static ANumber run(Graph graph, Vertex vertex)
    {
        GraphRules.isValid(graph);
        GraphRules.isVertexInGraph(graph, vertex);
        OrionSet<Edge> edges = graph.getNeighbourEdgesOf(vertex);
        return ANumber.of(edges.filter(edge -> edge.isVertexSecond(vertex)).count());
    }
}