package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.number.ANumber;
import com.orion.math.number.services.NumberService;

public class GetRandomVertexFromGraphTask extends Orion
{
    public static Vertex run(Graph graph)
    {
        GraphRules.isValid(graph);
        ANumber random = NumberService.getRandomNumber(0, graph.getNumberOfVertices());
        random = random.getFloor();
        return graph.getVerticesAsArray()[random.getAsInt()];
    }
}