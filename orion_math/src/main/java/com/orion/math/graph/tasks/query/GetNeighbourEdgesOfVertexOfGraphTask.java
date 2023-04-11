package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;

public class GetNeighbourEdgesOfVertexOfGraphTask extends Orion
{
    public static OrionSet<Edge> run(Graph graph, Vertex vertex)
    {
        GraphRules.isValid(graph);
        VertexRules.haveSameType(graph.getVertices(), vertex);
        OrionSet<Vertex> neighbourVertices = graph.getNeighbourVerticesOf(vertex);
        OrionList<Vertex> vertices = neighbourVertices.getAsOrionList();
        OrionSet<Edge> neighbours = OrionHashSet.<Edge>of();
        vertices.forAllPairsCountedOnce((i, j) ->
        {

            for(Edge edge : graph.getEdges())
            {

                if(edge.isIncidentAt(vertices.get(i), vertices.get(j)))
                {
                    neighbours.add(edge);
                    break;
                }

            }

        });
        return neighbours;
    }
}