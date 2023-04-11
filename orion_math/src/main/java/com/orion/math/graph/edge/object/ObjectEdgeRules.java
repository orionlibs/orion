package com.orion.math.graph.edge.object;

import com.orion.core.exception.Assert;
import com.orion.core.tuple.Pair;
import com.orion.math.MathRule;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.object.ObjectVertex;
import com.orion.math.graph.vertex.object.ObjectVertexRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class ObjectEdgeRules extends MathRule
{
    public static void isValidGenericEdge(Pair<Vertex, Vertex> pairOfVertices)
    {
        Assert.notNull(pairOfVertices, "The pairOfVertices input cannot be null.");
        Assert.isFalse(pairOfVertices.getFirst() instanceof ObjectVertex == false, "The pairOfVertices are not of type ObjectVertex.");
        Assert.isFalse(pairOfVertices.getSecond() instanceof ObjectVertex == false, "The pairOfVertices are not of type ObjectVertex.");
        isValid((ObjectVertex)pairOfVertices.getFirst(), (ObjectVertex)pairOfVertices.getSecond());
    }


    public static void isValidGenericEdge(Pair<Vertex, Vertex> pairOfVertices, ANumber weight)
    {
        isValidGenericEdge(pairOfVertices);
        NumberRules.isNotNull(weight);
    }


    public static void isValid(Pair<ObjectVertex, ObjectVertex> pairOfVertices)
    {
        Assert.notNull(pairOfVertices, "The pairOfVertices input cannot be null.");
        Assert.notNull(pairOfVertices.getFirst(), "The pairOfVertices input cannot be null.");
        Assert.notNull(pairOfVertices.getSecond(), "The pairOfVertices input cannot be null.");
    }


    public static void isValid(Pair<ObjectVertex, ObjectVertex> pairOfVertices, ANumber weight)
    {
        isValid(pairOfVertices);
        NumberRules.isNotNull(weight);
    }


    public static void isValid(ObjectVertex vertex1, ObjectVertex vertex2)
    {
        ObjectVertexRules.isValid(vertex1);
        ObjectVertexRules.isValid(vertex2);
    }


    public static void isValid(ObjectVertex vertex1, ObjectVertex vertex2, ANumber weight)
    {
        isValid(vertex1, vertex2);
        NumberRules.isNotNull(weight);
    }


    public static void isValidGenericEdge(Vertex vertex1, Vertex vertex2)
    {
        Assert.isFalse(vertex1 instanceof ObjectVertex == false, "Vertices are null or not ObjectVertex.");
        Assert.isFalse(vertex2 instanceof ObjectVertex == false, "Vertices are null or not ObjectVertex.");
        ObjectVertexRules.isValid((ObjectVertex)vertex1);
        ObjectVertexRules.isValid((ObjectVertex)vertex2);
    }


    public static void isValidGenericEdge(Vertex vertex1, Vertex vertex2, ANumber weight)
    {
        isValidGenericEdge(vertex1, vertex2);
        NumberRules.isNotNull(weight);
    }


    public static void isValid(ObjectEdge objectEdge)
    {
        Assert.notNull(objectEdge, "The objectEdge input cannot be null.");
        isValid(objectEdge.getPairOfVertices());
    }
}