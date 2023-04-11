package com.orion.math.graph.digraph;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.MathRule;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import java.util.Collection;

public class DigraphRules extends MathRule
{
    public static void isVertexInGraph(Digraph digraph, Vertex vertex)
    {
        GraphRules.isVertexInGraph(digraph, vertex);
    }


    public static void areVerticesInGraph(Digraph digraph, OrionSet<Vertex> vertices)
    {
        GraphRules.areVerticesInGraph(digraph, vertices);
    }


    public static void areVerticesInGraph(Digraph digraph, Vertex... vertices)
    {
        GraphRules.areVerticesInGraph(digraph, vertices);
    }


    public static void isEdgeInGraph(Digraph digraph, Edge edge)
    {
        GraphRules.isEdgeInGraph(digraph, edge);
    }


    public static void areEdgesInGraph(Digraph digraph, OrionSet<Edge> edges)
    {
        GraphRules.areEdgesInGraph(digraph, edges);
    }


    public static void areEdgesInGraph(Digraph digraph, Edge... edges)
    {
        GraphRules.areEdgesInGraph(digraph, edges);
    }


    public static void isValid(OrionSet<Vertex> vertices, OrionSet<Edge> edges)
    {
        GraphRules.isValid(vertices, edges);
    }


    public static void isValid(Collection<Vertex> vertices, Collection<Edge> edges)
    {
        GraphRules.isValid(vertices, edges);
    }


    public static void isValid(Collection<Vertex> vertices, OrionSet<Edge> edges)
    {
        GraphRules.isValid(vertices, edges);
    }


    public static void isValid(OrionSet<Vertex> vertices, Collection<Edge> edges)
    {
        GraphRules.isValid(vertices, edges);
    }


    public static void isValid(Digraph digraph)
    {
        GraphRules.isValid(digraph);
    }


    public static void areValid(Digraph... digraphs)
    {
        GraphRules.areValid(digraphs);
    }
}