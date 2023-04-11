package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.number.ANumber;

public class GetGraphDiameterTask extends Orion
{
    public static ANumber run(Graph graph)
    {
        GraphRules.isValid(graph);
        OrionList<Vertex> vertices = graph.getVerticesAsList();
        ANumber maximumPathDistance = ANumber.of(0);
        vertices.forAllPairsCountedOnce((i, j) ->
        {
            ANumber distance = graph.getLargestDistanceBetween(vertices.get(i), vertices.get(j));
            maximumPathDistance.setNewValues(maximumPathDistance.getMaximum(distance));
        });
        return maximumPathDistance;
    }
}