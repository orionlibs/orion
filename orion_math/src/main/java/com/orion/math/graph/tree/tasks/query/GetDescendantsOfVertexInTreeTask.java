package com.orion.math.graph.tree.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.tree.Tree;
import com.orion.math.graph.tree.TreeRules;
import com.orion.math.graph.vertex.Vertex;
import java.util.ArrayList;
import java.util.List;

public class GetDescendantsOfVertexInTreeTask extends Orion
{
    public static Vertex[] run(Tree tree, Vertex vertex)
    {
        TreeRules.isVertexInTree(tree, vertex);
        return getChildrenOf(tree, new Vertex[]
        {vertex}, new ArrayList<>()).toArray(new Vertex[0]);
    }


    private static List<Vertex> getChildrenOf(Tree tree, Vertex[] vertices, List<Vertex> descendants)
    {

        for(Vertex vertex : vertices)
        {
            descendants.add(vertex);

            if(tree.isNotLeaf(vertex))
            {
                getChildrenOf(tree, tree.getChildrenOf(vertex), descendants);
            }

        }

        return descendants;
    }
}