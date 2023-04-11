package com.orion.math.graph.tree.ordered;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.map.OrionMap;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.tree.TreeRules;
import com.orion.math.graph.tree.TreeService;
import com.orion.math.graph.vertex.Vertex;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderedTreeRules extends MathRule
{
    public static void isValid(OrionMap<Vertex, OrionList<Edge>> vertexToOrderedEdgesMapper)
    {
        Assert.notEmpty(vertexToOrderedEdgesMapper, "The vertexToOrderedEdgesMapper input cannot be null/empty.");
        Set<Vertex> vertices = vertexToOrderedEdgesMapper.keySet();
        Set<Edge> edges = vertexToOrderedEdgesMapper.getValuesAsOrionList()
                        .stream()
                        .flatMap(list -> list.stream())
                        .collect(Collectors.toSet());
        TreeRules.isValid(OrionHashSet.<Vertex>of(vertices), OrionHashSet.<Edge>of(edges));
    }


    public static void isValid(OrionMap<Vertex, OrionList<Edge>> vertexToOrderedEdgesMapper, Vertex root)
    {
        isValid(vertexToOrderedEdgesMapper);
        Set<Vertex> vertices = vertexToOrderedEdgesMapper.keySet();
        Set<Edge> edges = vertexToOrderedEdgesMapper.getValuesAsOrionList()
                        .stream()
                        .flatMap(list -> list.stream())
                        .collect(Collectors.toSet());
        Vertex rootTemp = TreeService.getRoot(OrionHashSet.<Vertex>of(vertices), OrionHashSet.<Edge>of(edges));
        Assert.isTrue(rootTemp.isNotEmpty(), "Tree does not have a root.");
        Assert.isFalse(rootTemp.notEquals(root), "The provided root parameter is not a root.");
    }


    public static void isValidWithRootCheck(OrderedTree tree)
    {
        TreeRules.isValidWithRootCheck(tree);
    }


    public static void isValid(OrderedTree tree)
    {
        TreeRules.isValid(tree);
    }


    public static void areValid(OrderedTree... trees)
    {
        Assert.notEmpty(trees, "The trees input cannot be null/empty.");
        Arrays.stream(trees).forEach(tree -> isValid(tree));
    }
}