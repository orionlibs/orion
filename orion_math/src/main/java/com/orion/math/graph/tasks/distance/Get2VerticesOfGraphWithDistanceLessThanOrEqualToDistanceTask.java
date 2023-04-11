package com.orion.math.graph.tasks.distance;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.tuple.Pair;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class Get2VerticesOfGraphWithDistanceLessThanOrEqualToDistanceTask extends Orion
{
    public static Pair<Vertex, Vertex> run(Graph graph, ANumber distance)
    {
        GraphRules.isValid(graph);
        NumberRules.isPositive(distance);
        OrionList<Vertex> vertices = graph.getVerticesAsList();

        for(int i = 0; i < graph.getNumberOfVertices() - 1; i++)
        {

            for(int j = i + 1; j < graph.getNumberOfVertices(); j++)
            {
                Path[] paths = graph.getPathsBetween(vertices.get(i), vertices.get(j));

                if(Arrays.stream(paths).anyMatch(path -> path.getLength().isLessThanOrEqual(distance)))
                {
                    return Pair.of(vertices.get(i), vertices.get(j));
                }

            }

        }

        return null;
    }
}