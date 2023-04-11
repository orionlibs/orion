package com.orion.math.graph.tree.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.tree.Tree;
import com.orion.math.graph.tree.TreeRules;
import com.orion.math.graph.vertex.Vertex;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteEdgeFromTreeTask extends Orion
{
    public static Tree run(Tree tree, Edge edgeToDelete)
    {
        TreeRules.isEdgeInTree(tree, edgeToDelete);
        List<Vertex> verticesToDelete = new ArrayList<>();
        verticesToDelete.add(edgeToDelete.getSecond());
        verticesToDelete.addAll(Arrays.asList(tree.getDescendantsOf(edgeToDelete.getSecond())));
        List<Edge> edgesToDelete = new ArrayList<>();
        verticesToDelete.forEach(vertexToDelete -> edgesToDelete.addAll(tree.getEdgesThatIncludeVertexAsSecondAsList(vertexToDelete)));
        OrionSet<Vertex> verticesCopy = tree.getVerticesCopy();
        verticesCopy.deleteAll(verticesToDelete);
        OrionSet<Edge> edgesCopy = tree.getEdgesCopy();
        edgesCopy.deleteAll(edgesToDelete);
        return Tree.of(verticesCopy, edgesCopy);
    }
}