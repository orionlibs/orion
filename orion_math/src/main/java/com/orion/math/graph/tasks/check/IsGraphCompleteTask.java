package com.orion.math.graph.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;

public class IsGraphCompleteTask extends Orion
{
    public static boolean run(Graph graph)
    {
        GraphRules.isValid(graph);
        OrionList<Vertex> vertices = graph.getVertices().getAsOrionList().getCopy();
        OrionSet<Vertex> adjacentVertices = OrionHashSet.<Vertex>of();

        for(int i = 0; i < vertices.getSize() - 1; i++)
        {

            for(int j = i + 1; j < vertices.getSize(); j++)
            {

                if(graph.areAdjacent(vertices.get(i), vertices.get(j)))
                {

                    if(adjacentVertices.contains(vertices.get(i)) && adjacentVertices.notContains(vertices.get(j)))
                    {
                        adjacentVertices.add(vertices.get(j));
                    }
                    else if(adjacentVertices.notContains(vertices.get(i)) && adjacentVertices.contains(vertices.get(j)))
                    {
                        adjacentVertices.add(vertices.get(i));
                    }
                    else if(adjacentVertices.notContains(vertices.get(i)) && adjacentVertices.notContains(vertices.get(j)))
                    {
                        adjacentVertices.add(vertices.get(i));
                        adjacentVertices.add(vertices.get(j));
                    }

                    break;
                }

            }

        }

        return adjacentVertices.size() == vertices.getSize();
    }
}