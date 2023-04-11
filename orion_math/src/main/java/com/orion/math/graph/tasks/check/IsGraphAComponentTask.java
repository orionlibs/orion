package com.orion.math.graph.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;

public class IsGraphAComponentTask extends Orion
{
    public static boolean run(Graph graph, Graph subgraph)
    {
        GraphRules.isValid(graph);

        if(subgraph.isSubgraphOf(graph))
        {
            OrionSet<Vertex> verticesOfSubgraph = subgraph.getVertices();
            OrionSet<Vertex> verticesOfGraphExceptVerticesOfSubgraph = graph.getVertices().getDifference(verticesOfSubgraph);

            if(subgraph.isConnected())
            {

                for(Vertex vertexInSubgraph : verticesOfSubgraph)
                {

                    for(Vertex vertexNotInSubgraph : verticesOfGraphExceptVerticesOfSubgraph)
                    {

                        if(graph.isTherePathBetween(vertexInSubgraph, vertexNotInSubgraph))
                        {
                            return false;
                        }

                    }

                }

                return true;
            }
            else
            {
                return false;
            }

        }
        else
        {
            return false;
        }

    }
}