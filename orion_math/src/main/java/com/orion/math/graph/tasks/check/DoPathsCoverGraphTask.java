package com.orion.math.graph.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.path.PathService;
import com.orion.math.graph.vertex.Vertex;

public class DoPathsCoverGraphTask extends Orion
{
    public static boolean run(Graph graph, OrionSet<Path> paths)
    {
        GraphRules.isValid(graph);

        if(PathService.areIndependent(paths))
        {
            return false;
        }
        else
        {
            OrionSet<Vertex> verticesIncludedInPaths = OrionHashSet.<Vertex>of();

            for(Path path : paths)
            {

                if(graph.doesPathNotBelongToGraph(path))
                {
                    return false;
                }
                else
                {
                    verticesIncludedInPaths.addAll(path.getVerticesAsList());
                }

            }

            return graph.getVertices().containsAll(verticesIncludedInPaths);
        }

    }
}