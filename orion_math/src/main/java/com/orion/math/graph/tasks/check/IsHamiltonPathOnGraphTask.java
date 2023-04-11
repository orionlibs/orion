package com.orion.math.graph.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.path.PathRules;
import com.orion.math.graph.vertex.Vertex;
import java.util.HashMap;
import java.util.Map;

public class IsHamiltonPathOnGraphTask extends Orion
{
    public static boolean run(Graph graph, Path path)
    {
        PathRules.doPathVerticesBelongToGraph(path, graph);

        if(path.getVerticesAsSet().notContains(graph.getVertices()))
        {
            return false;
        }
        else
        {
            Map<Vertex, Integer> graphVertexToFrequencyMapper = new HashMap<Vertex, Integer>();

            for(Vertex vertex : path.getVertices())
            {

                if(graphVertexToFrequencyMapper.get(vertex) != null)
                {
                    return false;
                }
                else
                {
                    graphVertexToFrequencyMapper.put(vertex, 1);
                }

            }

        }

        return true;
    }
}