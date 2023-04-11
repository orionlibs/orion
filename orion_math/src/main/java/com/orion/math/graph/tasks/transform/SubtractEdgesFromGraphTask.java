package com.orion.math.graph.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeRules;

public class SubtractEdgesFromGraphTask extends Orion
{
    public static Graph run(Graph graph, OrionSet<Edge> edgesToDelete)
    {
        GraphRules.isValid(graph);
        EdgeRules.areValid(edgesToDelete);
        OrionSet<Edge> edges = graph.getEdgesCopy();
        edges.removeAll(edgesToDelete);
        return Graph.of(graph.getVerticesCopy(), edges);
    }
}