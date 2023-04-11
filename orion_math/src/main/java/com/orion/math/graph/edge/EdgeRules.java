package com.orion.math.graph.edge;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.core.tuple.Pair;
import com.orion.math.MathRule;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.graph.vertex.number.NumberVertexRules;
import com.orion.math.graph.vertex.point.PointVertex;
import com.orion.math.graph.vertex.point.PointVertexRules;
import java.util.Arrays;

public class EdgeRules extends MathRule
{
    public static void isValid(Pair<Vertex, Vertex> pairOfVertices)
    {
        Assert.notNull(pairOfVertices, "The pairOfVertices input cannot be null.");
        Assert.notNull(pairOfVertices.getFirst(), "The graph input cannot be null.");
        Assert.notNull(pairOfVertices.getSecond(), "The graph input cannot be null.");
    }


    public static void isValid(Vertex vertex1, Vertex vertex2)
    {
        Assert.isFalse(vertex1 instanceof NumberVertex || vertex1 instanceof PointVertex, "The vertex1 input cannot be null.");
        Assert.isFalse(vertex2 instanceof NumberVertex || vertex2 instanceof PointVertex, "The vertex2 input cannot be null.");

        if(vertex1 instanceof NumberVertex)
        {
            NumberVertexRules.isValid((NumberVertex)vertex1);
        }
        else if(vertex1 instanceof PointVertex)
        {
            PointVertexRules.isValid((PointVertex)vertex1);
        }

        if(vertex2 instanceof NumberVertex)
        {
            NumberVertexRules.isValid((NumberVertex)vertex2);
        }
        else if(vertex2 instanceof PointVertex)
        {
            PointVertexRules.isValid((PointVertex)vertex2);
        }

    }


    public static void isValid(Edge edge)
    {
        Assert.notNull(edge, "The edge input cannot be null.");
        isValid(edge.getPair());
    }


    public static void areValid(Edge... edges)
    {
        Assert.notEmpty(edges, "The edges input cannot be null/empty.");
        Arrays.stream(edges).forEach(edge -> isValid(edge));
    }


    public static void areValid(OrionSet<Edge> edges)
    {
        Assert.notEmpty(edges, "The edges input cannot be null/empty.");
        edges.forAll(e -> isValid(e));
    }


    public static void areValid(OrionList<Edge> edges)
    {
        Assert.notEmpty(edges, "The edges input cannot be null/empty.");
        edges.forAll(e -> isValid(e));
    }


    public static void haveSameType(OrionSet<Edge> edges)
    {
        areValid(edges);
        Assert.isFalse(Edges.getType(edges).is(GraphType.Either), "Edges do not have the same type.");
    }


    public static void haveSameType(OrionList<Edge> edges)
    {
        areValid(edges);
        Assert.isFalse(Edges.getType(edges).is(GraphType.Either), "Edges do not have the same type.");
    }
}