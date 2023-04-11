package com.orion.math.graph.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;

public class IsSimpleGraphTask extends Orion
{
    public static boolean run(Graph graph)
    {
        GraphRules.isValid(graph);
        Vertex[] vertices = graph.getVerticesAsArray();

        for(int i = 0; i < vertices.length - 1; i++)
        {

            for(int j = i + 1; j < vertices.length; j++)
            {

                if(graph.areAdjacentByMultipleEdges(vertices[i], vertices[j]))
                {
                    return false;
                }

            }

        }

        return true;
    }
}