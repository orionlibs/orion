package com.orion.math.graph.digraph.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.graph.digraph.Digraph;
import com.orion.math.graph.digraph.DigraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeService;

public class GetComplementOfDirectedGraphTask extends Orion
{
    public static Digraph run(Digraph digraph)
    {
        DigraphRules.isValid(digraph);
        OrionSet<Edge> allPossibleEdges = EdgeService.getAllPossibleDirectedEdges(digraph.getVertices());
        OrionSet<Edge> edgesToKeep = allPossibleEdges.getDifference(digraph.getEdges());
        return Digraph.of(digraph.getVertices(), edgesToKeep);
    }
}