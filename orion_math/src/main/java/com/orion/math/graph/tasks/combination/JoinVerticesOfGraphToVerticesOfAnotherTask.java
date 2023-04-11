package com.orion.math.graph.tasks.combination;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeService;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;
import com.orion.math.graph.vertex.Vertices;

public class JoinVerticesOfGraphToVerticesOfAnotherTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static Graph run(Graph graph, Graph other)
    {
        GraphRules.areValid(graph, other);
        VertexRules.haveSameType(graph.getVertices(), other.getVertices());
        GraphType graphType = Vertices.getType(graph.getVertices());
        OrionSet<Edge> edges = OrionHashSet.<Edge>of();
        OrionSet<Vertex> vertices = OrionHashSet.<Vertex>of(graph.getVertices(), other.getVertices());

        for(Vertex vertexOfGraph : graph.getVertices())
        {

            for(Vertex vertexOfOther : other.getVertices())
            {
                edges.add(EdgeService.createEdgeBetween(graphType, vertexOfGraph, vertexOfOther));
            }

        }

        return Graph.of(vertices, edges);
    }
}