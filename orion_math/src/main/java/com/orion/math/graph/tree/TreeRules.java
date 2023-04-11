package com.orion.math.graph.tree;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeRules;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TreeRules extends MathRule
{
    public static void isVertexInTree(Tree tree, Vertex vertex)
    {
        isValid(tree);
        VertexRules.isValid(vertex);
        Assert.isTrue(tree.containsVertex(vertex), "Tree does not contain the given vertex.");
    }


    public static void isEdgeInTree(Tree tree, Edge edge)
    {
        isValid(tree);
        EdgeRules.isValid(edge);
        Assert.isTrue(tree.containsEdge(edge), "Tree does not contain the given edge.");
    }


    public static void isValid(OrionSet<Vertex> vertices, OrionSet<Edge> edges, Vertex root)
    {
        isValid(vertices, edges);
        Vertex rootTemp = TreeService.getRoot(vertices, edges);
        Assert.isTrue(rootTemp.isNotEmpty(), "Tree does not have a root.");
        Assert.isFalse(rootTemp.notEquals(root), "The provided root parameter is not a root.");
    }


    public static void isValid(OrionSet<Vertex> vertices, OrionSet<Edge> edges)
    {
        Assert.notEmpty(vertices, "the vertices input cannot be null/empty.");
        Assert.notEmpty(edges, "the edges input cannot be null/empty.");
        List<Vertex> verticesTemp = new ArrayList<Vertex>();
        edges.forAll(edge -> verticesTemp.addAll(edge.getAsList()));

        for(int i = 0; i < verticesTemp.size(); i++)
        {
            Assert.isTrue(vertices.contains(verticesTemp.get(i)), "Edge has vertex that does not belong to the set of vertices.");
        }

        /*
         * OrionList<Vertex> verticesTemp2 = OrionArrayList.of(vertices); Graph temp =
         * Graph.of(vertices, edges); AtomicBoolean foundAtLeast2PathsBetween2Vertices =
         * new AtomicBoolean(); verticesTemp2.forAllPairsCountedOnce((i, j) -> {
         * if(temp.getNumberOfPathsBetween(verticesTemp2.get(i),
         * verticesTemp2.get(j)).isGreaterThan(1)) {
         * foundAtLeast2PathsBetween2Vertices.set(true); } });
         * Assert.isFalse(foundAtLeast2PathsBetween2Vertices.get(),
         * "There is a pair of vertices that are connected by more than 1 paths.");
         */
    }


    public static void isValid(Collection<Vertex> vertices, Collection<Edge> edges, Vertex root)
    {
        Assert.notEmpty(vertices, "the vertices input cannot be null/empty.");
        Assert.notEmpty(edges, "the edges input cannot be null/empty.");
        isValid(OrionHashSet.<Vertex>of(vertices), OrionHashSet.<Edge>of(edges), root);
    }


    public static void isValid(Collection<Vertex> vertices, OrionSet<Edge> edges, Vertex root)
    {
        Assert.notEmpty(vertices, "the vertices input cannot be null/empty.");
        Assert.notEmpty(edges, "the edges input cannot be null/empty.");
        Assert.isFalse(!vertices.contains(root), "Root vertex does not belong to the vertices collection.");
    }


    public static void isValid(OrionSet<Vertex> vertices, Collection<Edge> edges, Vertex root)
    {
        Assert.notEmpty(vertices, "the vertices input cannot be null/empty.");
        Assert.notEmpty(edges, "the edges input cannot be null/empty.");
        Assert.isFalse(!vertices.contains(root), "Root vertex does not belong to the vertices collection.");
    }


    public static void isValidWithRootCheck(Tree tree)
    {
        Assert.notNull(tree, "the tree input cannot be null.");
        isValid(tree.getVertices(), tree.getEdges(), tree.getRoot());
    }


    public static void isValid(Tree tree)
    {
        Assert.notNull(tree, "the tree input cannot be null.");
        isValid(tree.getVertices(), tree.getEdges());
    }


    public static void areValid(Tree... trees)
    {
        Assert.notEmpty(trees, "The trees input cannot be null/empty.");
        Arrays.stream(trees).forEach(tree -> isValid(tree));
    }


    public static void areValidEdges(Tree tree, OrionSet<Edge> edgesToDelete)
    {
        isValid(tree);
        Assert.notEmpty(edgesToDelete, "The edgesToDelete input cannot be null/empty.");
        edgesToDelete.forEach(edge -> isEdgeInTree(tree, edge));
    }
}