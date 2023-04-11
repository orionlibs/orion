package com.orion.math.graph.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;

public class IsEdgeBridgeBetween2GraphsTask extends Orion
{
    public static boolean run(Graph graph, Graph component, Edge edge)
    {
        GraphRules.isValid(graph);

        if(graph.isComponent(component) && component.containsEdge(edge))
        {
            int numberOfComponentsInsideComponentWithoutVertex = component.subtractEdge(edge).getComponents().length;
            return numberOfComponentsInsideComponentWithoutVertex > component.getComponents().length;
        }
        else
        {
            return false;
        }

    }
}