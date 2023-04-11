package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;

public class GetNeighbourVerticesOfVertexOfGraphTask extends Orion
{
    public static OrionSet<Vertex> run(Graph graph, Vertex vertex)
    {
        GraphRules.isValid(graph);
        VertexRules.haveSameType(graph.getVertices(), vertex);
        OrionSet<Vertex> neighbours = OrionHashSet.<Vertex>of();

        for(Edge edge : graph.getEdges())
        {

            if(edge.isIncidentAt(vertex))
            {

                if(edge.getFirst().equals(vertex))
                {
                    neighbours.add(edge.getSecond());
                }
                else
                {
                    neighbours.add(edge.getFirst());
                }

            }

        }

        return neighbours;
    }
}