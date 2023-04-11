package com.orion.math.graph.tree.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.tree.Tree;
import com.orion.math.graph.tree.TreeRules;
import com.orion.math.graph.vertex.Vertex;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GetChildrenOfVertexInTreeTask extends Orion
{
    public static Vertex[] run(Tree tree, Vertex vertex)
    {
        TreeRules.isVertexInTree(tree, vertex);

        if(tree.isLeaf(vertex))
        {
            return new Vertex[0];
        }
        else
        {
            Edge[] edges = tree.getEdgesThatIncludeVertexAsFirst(vertex);

            if(edges.length == 0)
            {
                return new Vertex[0];
            }
            else
            {
                return Arrays.stream(edges).map(edge -> edge.getSecond()).collect(Collectors.toList()).toArray(new Vertex[0]);
            }

        }

    }
}