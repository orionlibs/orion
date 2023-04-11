package com.orion.math.graph.tree.labeled;

import com.orion.core.data.structure.map.OrionMap;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.tree.TreeService;
import com.orion.math.graph.vertex.Vertex;
import java.util.ArrayList;
import java.util.List;

public class LabeledTreeRules extends MathRule
{
    public static void isValid(OrionSet<Vertex> vertices, OrionSet<Edge> edges, OrionMap<Vertex, Object> vertexToLabelMapper, Vertex root)
    {
        isValid(vertices, edges, vertexToLabelMapper);
        Vertex rootTemp = TreeService.getRoot(vertices, edges);
        Assert.isTrue(rootTemp.isNotEmpty(), "Tree does not have a root.");
        Assert.isFalse(rootTemp.notEquals(root), "The provided root parameter is not a root.");
    }


    public static void isValid(OrionSet<Vertex> vertices, OrionSet<Edge> edges, OrionMap<Vertex, Object> vertexToLabelMapper)
    {
        Assert.notEmpty(vertices, "the vertices input cannot be null/empty.");
        Assert.notEmpty(edges, "the edges input cannot be null/empty.");
        Assert.notEmpty(vertexToLabelMapper, "the vertexToLabelMapper input cannot be null/empty.");
        List<Vertex> verticesTemp = new ArrayList<Vertex>();
        edges.forAll(edge -> verticesTemp.addAll(edge.getAsList()));

        for(int i = 0; i < verticesTemp.size(); i++)
        {
            Assert.isTrue(vertices.contains(verticesTemp.get(i)), "Edge has vertex that does not belong to the set of vertices.");
        }

        Assert.isTrue(vertices.equals(vertexToLabelMapper.keySet()), "The keyset of the vertexToLabelMapper does not match the vertices set.");
    }


    public static void isValid(LabeledTree tree)
    {
        Assert.notNull(tree, "the tree input cannot be null.");
        isValid(tree.getVertices(), tree.getEdges(), tree.getVertexToLabelMapper());
    }
}