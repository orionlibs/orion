package com.orion.math.graph.vertex;

import com.orion.core.abstraction.OrionService;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeRules;

public class VertexService extends OrionService
{
    public static boolean isIncident(Vertex vertex, Edge edge)
    {
        VertexRules.isValid(vertex);
        EdgeRules.isValid(edge);
        return edge.isIncidentAt(vertex);
    }
}