package com.orion.math.graph.path.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.path.PathRules;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;

public class GetIndexOfVertexInPathTask extends Orion
{
    public static int run(Path path, Vertex vertex)
    {
        PathRules.isValid(path);
        VertexRules.haveSameType(path.getVerticesAsSet(), vertex);

        for(int i = 0; i < path.getVertices().length; i++)
        {

            if(path.getVertex(i).equals(vertex))
            {
                return i;
            }

        }

        return -1;
    }
}