package com.orion.math.graph.tree.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.tree.Tree;
import com.orion.math.graph.tree.TreeRules;
import com.orion.math.graph.vertex.Vertex;
import java.util.ArrayList;
import java.util.List;

public class GetSubtreeWithRootTask extends Orion
{
    public static Tree run(Tree tree, Vertex newRoot)
    {
        TreeRules.isVertexInTree(tree, newRoot);
        List<Vertex> newVertices = new ArrayList<>();
        newVertices.add(newRoot);
        List<Edge> newEdges = new ArrayList<>();
        newEdges.addAll(tree.getEdgesThatIncludeVertexAsFirstAsList(newRoot));
        getNewVerticesAndEdges(tree, tree.getChildrenOf(newRoot), newVertices, newEdges);
        return Tree.of(newVertices, newEdges, newRoot);
    }


    private static void getNewVerticesAndEdges(Tree tree, Vertex[] descendants, List<Vertex> newVertices, List<Edge> newEdges)
    {

        for(Vertex descendant : descendants)
        {
            newVertices.add(descendant);

            if(tree.isNotLeaf(descendant))
            {
                newEdges.addAll(tree.getEdgesThatIncludeVertexAsFirstAsList(descendant));
                getNewVerticesAndEdges(tree, tree.getChildrenOf(descendant), newVertices, newEdges);
            }

        }

    }
}