package com.orion.math.graph.digraph.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.stream.OrionStream;
import com.orion.math.graph.digraph.Digraph;
import com.orion.math.graph.digraph.DigraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import java.util.stream.Stream;

public class GetDirectedEdgesThatInclude2VerticesTask extends Orion
{
    public static Edge[] run(Digraph digraph, Vertex firstVertex, Vertex secondVertex)
    {
        DigraphRules.isValid(digraph);
        DigraphRules.areVerticesInGraph(digraph, firstVertex, secondVertex);
        Stream<Edge> stream = digraph.getEdges()
                        .filter(edge -> edge.isVertexFirst(firstVertex) && edge.isVertexSecond(secondVertex));
        return OrionStream.getAsArray(stream, Edge.class);
    }
}