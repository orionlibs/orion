package com.orion.math.graph.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeService;

public class GetComplementOfUndirectedGraphTask extends Orion
{
    public static Graph run(Graph graph)
    {
        GraphRules.isValid(graph);
        OrionSet<Edge> allPossibleEdges = EdgeService.getAllPossibleUndirectedEdges(graph.getVertices());
        OrionSet<Edge> edgesToKeep = allPossibleEdges.getDifference(graph.getEdges());
        return Graph.of(graph.getVertices(), edgesToKeep);
    }
}