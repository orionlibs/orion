package com.orion.math.graph.tasks.combination;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;

public class GetGraphUnionTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static Graph run(Graph graph, Graph other)
    {
        GraphRules.areValid(graph, other);
        OrionSet<Vertex> newVertices = graph.getVertices().getUnion(other.getVertices());
        OrionSet<Edge> newEdges = graph.getEdges().getUnion(other.getEdges());
        return Graph.of(newVertices, newEdges);
    }
}