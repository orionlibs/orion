package com.orion.math.graph.digraph;

import com.orion.core.abstraction.OrionService;
import com.orion.math.graph.digraph.tasks.GetAllPossibleSubgraphsOfDigraphTask;
import com.orion.math.graph.digraph.tasks.GetComplementOfDirectedGraphTask;
import com.orion.math.graph.digraph.tasks.GetDirectedEdgesThatInclude2VerticesTask;
import com.orion.math.graph.digraph.tasks.IsDigraphKConnectedTask;
import com.orion.math.graph.digraph.tasks.IsDigraphLEdgeConnectedTask;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.number.ANumber;

public class DigraphService extends OrionService
{
    public static Digraph getComplement(Digraph digraph)
    {
        return GetComplementOfDirectedGraphTask.run(digraph);
    }


    public static Digraph[] getAllPossibleSubgraphs(Digraph digraph)
    {
        return GetAllPossibleSubgraphsOfDigraphTask.run(digraph);
    }


    public static boolean isKConnected(Digraph digraph, ANumber k)
    {
        return IsDigraphKConnectedTask.run(digraph, k);
    }


    public static boolean isLEdgeConnected(Digraph digraph, ANumber l)
    {
        return IsDigraphLEdgeConnectedTask.run(digraph, l);
    }


    public static Edge[] getDirectedEdgesThatInclude(Digraph digraph, Vertex firstVertex, Vertex secondVertex)
    {
        return GetDirectedEdgesThatInclude2VerticesTask.run(digraph, firstVertex, secondVertex);
    }


    public static boolean isOriented(Digraph digraph)
    {
        DigraphRules.isValid(digraph);
        return digraph.getNumberOfLoops().isZero() && digraph.getNumberOfMultipleEdges().isZero();
    }
}