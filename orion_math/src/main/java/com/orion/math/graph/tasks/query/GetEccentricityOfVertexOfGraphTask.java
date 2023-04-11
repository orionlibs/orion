package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.number.ANumber;

public class GetEccentricityOfVertexOfGraphTask extends Orion
{
    public static ANumber run(Graph graph, Vertex vertex)
    {
        GraphRules.isVertexInGraph(graph, vertex);
        ANumber maximumDistance = ANumber.of(0);
        OrionList<Vertex> vertices = graph.getVerticesAsList();

        for(int i = 0; i < vertices.getSize(); i++)
        {

            if(vertices.get(i).notEquals(vertex))
            {
                ANumber distance = graph.getLargestDistanceBetween(vertex, vertices.get(i));

                if(distance.isGreaterThan(maximumDistance))
                {
                    maximumDistance = distance;
                }

            }

        }

        return maximumDistance;
    }
}