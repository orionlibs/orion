package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.stream.OrionStream;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import java.util.stream.Stream;

public class GetEdgesThatInclude2VerticesOfGraphTask extends Orion
{
    public static Edge[] run(Graph graph, Vertex v1, Vertex v2)
    {
        GraphRules.isValid(graph);
        GraphRules.areVerticesInGraph(graph, v1, v2);
        Stream<Edge> stream = graph.getEdges().filter(edge -> edge.isIncidentAt(v1, v2));
        return OrionStream.getAsArray(stream, Edge.class);
    }
}