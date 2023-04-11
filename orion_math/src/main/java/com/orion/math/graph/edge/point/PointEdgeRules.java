package com.orion.math.graph.edge.point;

import com.orion.core.exception.Assert;
import com.orion.core.tuple.Pair;
import com.orion.math.MathRule;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.point.PointVertex;
import com.orion.math.graph.vertex.point.PointVertexRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class PointEdgeRules extends MathRule
{
    public static void isValidGenericEdge(Pair<Vertex, Vertex> pairOfVertices)
    {
        Assert.notNull(pairOfVertices, "The pairOfVertices input cannot be null.");
        Assert.isFalse(pairOfVertices.getFirst() instanceof PointVertex == false, "Vertices are null or not PointVertex.");
        Assert.isFalse(pairOfVertices.getSecond() instanceof PointVertex == false, "Vertices are null or not PointVertex.");
        isValid((PointVertex)pairOfVertices.getFirst(), (PointVertex)pairOfVertices.getSecond());
    }


    public static void isValidGenericEdge(Pair<Vertex, Vertex> pairOfVertices, ANumber weight)
    {
        isValidGenericEdge(pairOfVertices);
        NumberRules.isNotNull(weight);
    }


    public static void isValidGenericEdge(Vertex vertex1, Vertex vertex2)
    {
        Assert.isFalse(vertex1 instanceof PointVertex == false, "Vertices are null or not PointVertex.");
        Assert.isFalse(vertex2 instanceof PointVertex == false, "Vertices are null or not PointVertex.");
        PointVertexRules.isValid((PointVertex)vertex1);
        PointVertexRules.isValid((PointVertex)vertex2);
    }


    public static void isValidGenericEdge(Vertex vertex1, Vertex vertex2, ANumber weight)
    {
        isValidGenericEdge(vertex1, vertex2);
        NumberRules.isNotNull(weight);
    }


    public static void isValid(Pair<PointVertex, PointVertex> pairOfVertices)
    {
        Assert.notNull(pairOfVertices, "The pairOfVertices input cannot be null.");
        Assert.notNull(pairOfVertices.getFirst(), "The pairOfVertices input cannot be null.");
        Assert.notNull(pairOfVertices.getSecond(), "The pairOfVertices input cannot be null.");
    }


    public static void isValid(Pair<PointVertex, PointVertex> pairOfVertices, ANumber weight)
    {
        isValid(pairOfVertices);
        NumberRules.isNotNull(weight);
    }


    public static void isValid(PointVertex vertex1, PointVertex vertex2)
    {
        PointVertexRules.isValid(vertex1);
        PointVertexRules.isValid(vertex2);
    }


    public static void isValid(PointVertex vertex1, PointVertex vertex2, ANumber weight)
    {
        isValid(vertex1, vertex2);
        NumberRules.isNotNull(weight);
    }


    public static void isValid(PointEdge pointEdge)
    {
        Assert.notNull(pointEdge, "The pointEdge input cannot be null.");
        isValid(pointEdge.getPairOfVertices());
    }
}