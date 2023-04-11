package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.vertex.Vertex;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetCyclesOfGraphTask extends Orion
{
    public static Path[] run(Graph graph)
    {
        GraphRules.isValid(graph);
        OrionSet<Vertex> vertices = graph.getVertices();
        List<Path> paths = new ArrayList<Path>();

        for(Vertex vertex : vertices)
        {
            Path[] pathsTemp = graph.getPathsBetween(vertex, vertex);

            if(pathsTemp != null && pathsTemp.length > 0)
            {
                paths.addAll(Arrays.asList(pathsTemp));
            }

        }

        return paths.toArray(new Path[0]);
    }
}