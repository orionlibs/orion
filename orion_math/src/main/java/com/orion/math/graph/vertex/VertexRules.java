package com.orion.math.graph.vertex;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.graph.GraphType;
import java.util.Arrays;

public class VertexRules extends MathRule
{
    public static void isValid(Object point)
    {
        Assert.notNull(point, "the point input cannot be null.");
    }


    public static void isValid(Vertex vertex)
    {
        Assert.notNull(vertex, "the vertex input cannot be null.");
        isValid(vertex.getVertexPoint());
    }


    public static void areValid(Vertex... vertices)
    {
        Assert.notEmpty(vertices, "the vertices input cannot be null/empty.");
        Arrays.stream(vertices).forEach(v -> isValid(v));
    }


    public static void areValid(OrionSet<Vertex> vertices)
    {
        Assert.notEmpty(vertices, "the vertices input cannot be null/empty.");
        vertices.forAll(v -> isValid(v));
    }


    public static void haveSameType(OrionSet<Vertex> vertices1, OrionSet<Vertex> vertices2)
    {
        areValid(vertices1);
        areValid(vertices2);
        GraphType type1 = Vertices.getType(vertices1);
        GraphType type2 = Vertices.getType(vertices2);
        Assert.isFalse(type1.is(GraphType.Either), "Vertices do not have the same type.");
        Assert.isFalse(type2.is(GraphType.Either), "Vertices do not have the same type.");
        Assert.isFalse(Vertices.getType(vertices1).isNot(Vertices.getType(vertices2)), "Vertices do not have the same type.");
    }


    public static void haveSameType(OrionSet<Vertex> vertices1, Vertex vertex)
    {
        areValid(vertices1);
        isValid(vertex);
        Assert.isFalse(Vertices.getType(vertices1).isNot(Vertices.getType(vertex)), "Vertices do not have the same type.");
    }


    public static void haveSameType(Vertex vertex1, Vertex vertex2)
    {
        areValid(vertex1, vertex2);
        Assert.isFalse(Vertices.getType(vertex1).isNot(Vertices.getType(vertex2)), "Vertices do not have the same type.");
    }
}