package com.orion.math.graph.path.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.path.Path;

public class IsPathHPathTask extends Orion
{
    public static boolean run(Path path, Graph graph)
    {
        GraphRules.isValid(graph);

        if(path.getInnerVerticesAsList().findAny(iv -> graph.containsVertex(iv)))
        {
            return false;
        }

        return graph.containsVertex(path.getFirstVertex()) && graph.containsVertex(path.getLastVertex());
    }
}