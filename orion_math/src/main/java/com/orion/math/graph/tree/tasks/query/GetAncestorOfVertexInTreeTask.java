package com.orion.math.graph.tree.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.tree.Tree;
import com.orion.math.graph.tree.TreeRules;
import com.orion.math.graph.vertex.Vertex;
import java.util.ArrayList;
import java.util.List;

public class GetAncestorOfVertexInTreeTask extends Orion
{
    public static Vertex[] run(Tree tree, Vertex vertex)
    {
        TreeRules.isVertexInTree(tree, vertex);
        Vertex parent = null;
        List<Vertex> parents = new ArrayList<>();
        Vertex currentVertex = vertex;

        while((parent = tree.getImmediateParentOf(currentVertex)).notEquals(tree.getRoot()))
        {
            parents.add(parent);
            currentVertex = parent;
        }

        return parents.toArray(new Vertex[0]);
    }
}