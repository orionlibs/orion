package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;

public class GetNonisolatedRandomVertexOfGraphTask extends Orion
{
    public static Vertex run(Graph graph)
    {
        GraphRules.isValid(graph);
        Vertex randomVertex = graph.getRandomVertex();

        while(graph.isVertexIsolated(randomVertex))
        {
            randomVertex = graph.getRandomVertex();
        }

        return randomVertex;
    }
}