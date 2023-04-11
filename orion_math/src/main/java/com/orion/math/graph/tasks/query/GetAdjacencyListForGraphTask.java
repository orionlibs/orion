package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAdjacencyListForGraphTask extends Orion
{
    public static Map<Vertex, List<Vertex>> run(Graph graph)
    {
        GraphRules.isValid(graph);
        Map<Vertex, List<Vertex>> map = new HashMap<>();

        for(Vertex vertex : graph.getVertices())
        {
            List<Vertex> mappings = null;

            if(map.get(vertex) != null)
            {
                mappings = map.get(vertex);
            }
            else
            {
                mappings = new ArrayList<Vertex>();
            }

            mappings.addAll(graph.getNeighbourVerticesOf(vertex));
            map.put(vertex, mappings);
        }

        return map;
    }
}