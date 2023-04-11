package com.orion.math.graph.tree.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.tree.Tree;
import com.orion.math.graph.tree.TreeRules;
import com.orion.math.graph.vertex.Vertex;
import java.util.stream.Collectors;

public class GetImmediateParentOfVertexInTreeTask extends Orion
{
    public static Vertex run(Tree tree, Vertex vertex)
    {
        TreeRules.isVertexInTree(tree, vertex);

        if(tree.isRoot(vertex))
        {
            return null;
        }
        else
        {
            return tree.getEdges().filter(e -> e.getSecond().equals(vertex)).collect(Collectors.toList()).get(0).getFirst();
        }

    }
}