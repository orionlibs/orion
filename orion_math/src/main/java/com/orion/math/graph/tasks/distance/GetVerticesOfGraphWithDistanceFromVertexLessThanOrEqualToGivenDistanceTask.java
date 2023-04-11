package com.orion.math.graph.tasks.distance;

import com.orion.core.abstraction.Orion;
import com.orion.core.stream.OrionStream;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.stream.Stream;

public class GetVerticesOfGraphWithDistanceFromVertexLessThanOrEqualToGivenDistanceTask extends Orion
{
    public static Vertex[] run(Graph graph, ANumber distance, Vertex vertex)
    {
        GraphRules.isVertexInGraph(graph, vertex);
        NumberRules.isPositive(distance);
        Stream<Vertex> stream = graph.getVertices()
                        .filter(v -> v.notEquals(vertex) && graph.getDistanceBetween(vertex, v).isLessThanOrEqual(distance));
        return OrionStream.getAsArray(stream, Vertex.class);
    }
}