package com.orion.math.graph.edge.number;

import com.orion.core.exception.Assert;
import com.orion.core.tuple.Pair;
import com.orion.math.MathRule;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.graph.vertex.number.NumberVertexRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class NumberEdgeRules extends MathRule
{
    public static void isValidGenericEdge(Pair<Vertex, Vertex> pairOfVertices)
    {
        Assert.notNull(pairOfVertices, "The pairOfVertices input cannot be null.");
        Assert.isFalse(pairOfVertices.getFirst() instanceof NumberVertex == false, "The pairOfVertices are not of type NumberVertex.");
        Assert.isFalse(pairOfVertices.getSecond() instanceof NumberVertex == false, "The pairOfVertices are not of type NumberVertex.");
        isValid((NumberVertex)pairOfVertices.getFirst(), (NumberVertex)pairOfVertices.getSecond());
    }


    public static void isValidGenericEdge(Pair<Vertex, Vertex> pairOfVertices, ANumber weight)
    {
        isValidGenericEdge(pairOfVertices);
        NumberRules.isNotNull(weight);
    }


    public static void isValid(Pair<NumberVertex, NumberVertex> pairOfVertices)
    {
        Assert.notNull(pairOfVertices, "The pairOfVertices input cannot be null.");
        Assert.notNull(pairOfVertices.getFirst(), "The pairOfVertices input cannot be null.");
        Assert.notNull(pairOfVertices.getSecond(), "The pairOfVertices input cannot be null.");
    }


    public static void isValid(Pair<NumberVertex, NumberVertex> pairOfVertices, ANumber weight)
    {
        isValid(pairOfVertices);
        NumberRules.isNotNull(weight);
    }


    public static void isValid(NumberVertex vertex1, NumberVertex vertex2)
    {
        NumberVertexRules.isValid(vertex1);
        NumberVertexRules.isValid(vertex2);
    }


    public static void isValid(NumberVertex vertex1, NumberVertex vertex2, ANumber weight)
    {
        isValid(vertex1, vertex2);
        NumberRules.isNotNull(weight);
    }


    public static void isValidGenericEdge(Vertex vertex1, Vertex vertex2)
    {
        Assert.isFalse(vertex1 instanceof NumberVertex == false, "Vertices are null or not NumberVertex.");
        Assert.isFalse(vertex2 instanceof NumberVertex == false, "Vertices are null or not NumberVertex.");
        NumberVertexRules.isValid((NumberVertex)vertex1);
        NumberVertexRules.isValid((NumberVertex)vertex2);
    }


    public static void isValidGenericEdge(Vertex vertex1, Vertex vertex2, ANumber weight)
    {
        isValidGenericEdge(vertex1, vertex2);
        NumberRules.isNotNull(weight);
    }


    public static void isValid(NumberEdge numberEdge)
    {
        Assert.notNull(numberEdge, "The numberEdge input cannot be null.");
        isValid(numberEdge.getPairOfVertices());
    }
}