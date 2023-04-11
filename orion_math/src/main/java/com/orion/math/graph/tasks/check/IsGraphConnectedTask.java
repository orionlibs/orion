package com.orion.math.graph.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;

public class IsGraphConnectedTask extends Orion
{
    public static boolean run(Graph graph)
    {
        GraphRules.isValid(graph);
        OrionList<Vertex> vertices = graph.getVertices().getAsOrionList();
        int numberOfVerticesThatConnectToAtLeastOneOtherVertex = 0;

        for(int i = 0; i < vertices.getSize() - 1; i++)
        {

            for(int j = i + 1; j < vertices.getSize(); j++)
            {

                if(graph.isTherePathBetween(vertices.get(i), vertices.get(j)))
                {
                    numberOfVerticesThatConnectToAtLeastOneOtherVertex++;
                }

            }

        }

        return numberOfVerticesThatConnectToAtLeastOneOtherVertex == vertices.getSize();
    }
}