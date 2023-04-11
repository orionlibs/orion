package com.orion.math.graph.tree;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.stream.OrionStream;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.tree.tasks.query.GetAncestorOfVertexInTreeTask;
import com.orion.math.graph.tree.tasks.query.GetChildrenOfVertexInTreeTask;
import com.orion.math.graph.tree.tasks.query.GetDescendantsOfVertexInTreeTask;
import com.orion.math.graph.tree.tasks.query.GetImmediateParentOfVertexInTreeTask;
import com.orion.math.graph.tree.tasks.query.GetRootOfTreeTask;
import com.orion.math.graph.tree.tasks.query.GetSubtreeWithRootTask;
import com.orion.math.graph.tree.tasks.query.IsCompleteMAryTreeTask;
import com.orion.math.graph.tree.tasks.query.IsTreeBalancedTask;
import com.orion.math.graph.tree.tasks.transform.DeleteEdgeFromTreeTask;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.number.ANumber;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TreeService extends OrionService
{
    public static Vertex[] getLeaves(Tree tree)
    {
        TreeRules.isValid(tree);
        return OrionStream.getAsArray(tree.getVertices().filter(v -> tree.getDegreeOf(v).isOne()), Vertex.class);
    }


    public static int getNumberOfLeaves(Tree tree)
    {
        TreeRules.isValid(tree);
        return tree.getLeaves().length;
    }


    public static boolean isTrivial(Tree tree)
    {
        TreeRules.isValid(tree);
        return getNumberOfLeaves(tree) < 2;
    }


    public static Vertex getRoot(Tree tree) throws TreeHasMultipleRootsException
    {
        return GetRootOfTreeTask.run(tree);
    }


    public static Vertex getRoot(OrionSet<Vertex> vertices, OrionSet<Edge> edges)
    {
        return GetRootOfTreeTask.run(vertices, edges);
    }


    public static boolean isRoot(Tree tree, Vertex root)
    {
        TreeRules.isValid(tree);
        return tree.getRoot().equals(root);
    }


    public static boolean isLeaf(Tree tree, Vertex vertex)
    {
        TreeRules.isVertexInTree(tree, vertex);
        return tree.getDegreeOf(vertex).isOne();
    }


    public static boolean isComparable(Tree tree)
    {
        TreeRules.isValid(tree);
        return tree.getType().is(GraphType.Number);
    }


    public static Vertex getImmediateParentOf(Tree tree, Vertex vertex)
    {
        return GetImmediateParentOfVertexInTreeTask.run(tree, vertex);
    }


    public static Vertex[] getChildrenOf(Tree tree, Vertex vertex)
    {
        return GetChildrenOfVertexInTreeTask.run(tree, vertex);
    }


    public static Edge getEdgeIncidentAtVertex(Tree tree, Vertex vertex)
    {
        TreeRules.isVertexInTree(tree, vertex);
        return tree.getEdgesThatIncludeVertex(vertex)[0];
    }


    public static Vertex[] getSiblingsOf(Tree tree, Vertex vertex)
    {
        TreeRules.isVertexInTree(tree, vertex);
        return Arrays.stream(getChildrenOf(tree, getImmediateParentOf(tree, vertex)))
                        .filter(child -> child.notEquals(vertex))
                        .collect(Collectors.toList())
                        .toArray(new Vertex[0]);
    }


    public static Vertex[] getAncestorsOf(Tree tree, Vertex vertex)
    {
        return GetAncestorOfVertexInTreeTask.run(tree, vertex);
    }


    public static Vertex[] getDescendantsOf(Tree tree, Vertex vertex)
    {
        return GetDescendantsOfVertexInTreeTask.run(tree, vertex);
    }


    public static Tree getSubtreeWithRoot(Tree tree, Vertex newRoot)
    {
        return GetSubtreeWithRootTask.run(tree, newRoot);
    }


    public static boolean isBinaryTree(Tree tree)
    {
        return isMAryTree(tree, 2);
    }


    public static boolean isMAryTree(Tree tree, int m)
    {
        TreeRules.isValid(tree);
        return tree.getNonLeavesAsOrionList().findAny(vertex -> tree.getNumberOfChildren(vertex).notEqual(m));
    }


    public static Tree subtractEdge(Tree tree, Edge edgeToDelete)
    {
        return DeleteEdgeFromTreeTask.run(tree, edgeToDelete);
    }


    public static Tree subtractEdges(Tree tree, Edge[] edgesToDelete)
    {
        return subtractEdges(tree, OrionHashSet.<Edge>of(edgesToDelete));
    }


    public static Tree subtractEdges(Tree tree, OrionSet<Edge> edgesToDelete)
    {
        TreeRules.areValidEdges(tree, edgesToDelete);
        Tree[] newTree = new Tree[1];
        edgesToDelete.forEach(edge -> newTree[0] = tree.subtractEdge(edge));
        return newTree[0];
    }


    public static Tree subtractEdges(Tree tree, OrionList<Edge> edgesToDelete)
    {
        return subtractEdges(tree, OrionHashSet.<Edge>of(edgesToDelete));
    }


    public static ANumber getHeight(Tree tree)
    {
        TreeRules.isValid(tree);
        return tree.getDiameter();
    }


    public static ANumber getHeightOfVertex(Tree tree, Vertex vertex)
    {
        TreeRules.isVertexInTree(tree, vertex);
        return tree.getLargestDistanceBetween(tree.getRoot(), vertex);
    }


    public static boolean isBalanced(Tree tree)
    {
        return IsTreeBalancedTask.run(tree);
    }


    public static boolean isCompleteMAryTree(Tree tree, int m)
    {
        return IsCompleteMAryTreeTask.run(tree, m);
    }
}