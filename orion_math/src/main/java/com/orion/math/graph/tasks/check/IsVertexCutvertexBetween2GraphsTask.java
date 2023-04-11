package com.orion.math.graph.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;

public class IsVertexCutvertexBetween2GraphsTask extends Orion
{
    public static boolean run(Graph graph, Graph component, Vertex vertex)
    {
        GraphRules.isValid(graph);

        if(graph.isComponent(component) && component.containsVertex(vertex))
        {
            int numberOfComponentsInsideComponentWithoutVertex = component.subtract(vertex).getComponents().length;
            return numberOfComponentsInsideComponentWithoutVertex > component.getComponents().length;
        }
        else
        {
            return false;
        }

    }
}