package com.orion.math.graph;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.math.MathRule;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeRules;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.path.PathRules;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphRules extends MathRule
{
    public static void doGraphsHaveSameNumberOfVertices(Graph graph, Graph other)
    {
        isValid(graph);
        isValid(other);
        Assert.isTrue(graph.getNumberOfVertices() == other.getNumberOfVertices(), "Graphs do not have the same number of vertices.");
    }


    public static void isVertexInGraph(Graph graph, Vertex vertex)
    {
        isValid(graph);
        VertexRules.isValid(vertex);
        Assert.isTrue(graph.containsVertex(vertex), "Graph does not contain the given vertex.");
    }


    public static void isPathInGraph(Graph graph, Path path)
    {
        isValid(graph);
        PathRules.isValid(path);
        Assert.isTrue(graph.containsEdges(path.getEdgesAsSet()), "Graph does not contain the given path.");
    }


    public static void areVerticesInGraph(Graph graph, OrionSet<Vertex> vertices)
    {
        Assert.notEmpty(vertices, "The vertices input cannot be null/empty.");
        vertices.forAll(vertex -> isVertexInGraph(graph, vertex));
    }


    public static void areVerticesInGraph(Graph graph, Vertex... vertices)
    {
        Assert.notEmpty(vertices, "The vertices input cannot be null/empty.");
        Arrays.stream(vertices).forEach(vertex -> isVertexInGraph(graph, vertex));
    }


    public static void isEdgeInGraph(Graph graph, Edge edge)
    {
        isValid(graph);
        EdgeRules.isValid(edge);
        Assert.isFalse(graph.notContainsEdge(edge), "Graph does not contain the given edge.");
    }


    public static void areEdgesInGraph(Graph graph, OrionSet<Edge> edges)
    {
        Assert.notEmpty(edges, "The edges input cannot be null/empty.");
        edges.forAll(edge -> isEdgeInGraph(graph, edge));
    }


    public static void isThereAtLeastOneEdge(Graph graph)
    {
        isValid(graph);
        Assert.isGreaterThan(graph.getNumberOfEdges(), 0, "The graph needs to have at least one edge.");
    }


    public static void areEdgesInGraph(Graph graph, Edge... edges)
    {
        Assert.notEmpty(edges, "The edges input cannot be null/empty.");
        Arrays.stream(edges).forEach(edge -> isEdgeInGraph(graph, edge));
    }


    public static void isValid(OrionSet<Vertex> vertices, OrionSet<Edge> edges)
    {
        Assert.notEmpty(vertices, "The vertices input cannot be null/empty.");
        Assert.notNull(edges, "The edges input cannot be null.");
        List<Vertex> verticesTemp = new ArrayList<Vertex>();
        edges.forAll(edge -> verticesTemp.addAll(edge.getAsList()));

        for(int i = 0; i < verticesTemp.size(); i++)
        {
            Assert.isFalse(vertices.notContains(verticesTemp.get(i)), "Edge has vertex that does not belong to the set of vertices.");
        }

    }


    public static void isValid(Map<Vertex, List<Vertex>> adjacencyList)
    {
        Assert.notEmpty(adjacencyList, "The adjacencyList input cannot be null/empty.");
        Set<Vertex> vertices = adjacencyList.keySet();
        List<Vertex> verticesValues = adjacencyList.values().stream().flatMap(list -> list.stream()).collect(Collectors.toList());

        if(verticesValues.stream().anyMatch(vertex -> !vertices.contains(vertex)))
        {
            throw new InvalidArgumentException("There is at least one vertex that is not mapped to other vertices.");
        }

    }


    public static void isValid(OrionSet<Vertex> vertices, Matrix adjacencyMatrix)
    {
        Assert.notEmpty(vertices, "The vertices input cannot be null/empty.");
        MatrixRules.isValidSquareMatrix(adjacencyMatrix);
        Assert.isTrue(vertices.size() == adjacencyMatrix.getNumberOfRows(), "The given adjacencyMatrix number of rows/columns does not match the number of given vertices.");
    }


    public static void isValid(OrionSet<Vertex> vertices)
    {
        Assert.notEmpty(vertices, "The vertices input cannot be null/empty.");
    }


    public static void isValid(Collection<Vertex> vertices, Collection<Edge> edges)
    {
        Assert.notEmpty(vertices, "The vertices input cannot be null/empty.");
        Assert.notEmpty(edges, "The edges input cannot be null/empty.");
        isValid(OrionHashSet.<Vertex>of(vertices), OrionHashSet.<Edge>of(edges));
    }


    public static void isValid(Collection<Vertex> vertices)
    {
        Assert.notEmpty(vertices, "The vertices input cannot be null/empty.");
    }


    public static void isValid(Collection<Vertex> vertices, OrionSet<Edge> edges)
    {
        Assert.notEmpty(vertices, "The vertices input cannot be null/empty.");
        Assert.notEmpty(edges, "The edges input cannot be null/empty.");
    }


    public static void isValid(OrionSet<Vertex> vertices, Collection<Edge> edges)
    {
        Assert.notEmpty(vertices, "The vertices input cannot be null/empty.");
        Assert.notEmpty(edges, "The edges input cannot be null/empty.");
    }


    public static void isValid(Graph graph)
    {
        Assert.notNull(graph, "The graph input cannot be null.");
        isValid(graph.getVertices(), graph.getEdges());
    }


    public static void areValid(Graph... graphs)
    {
        Assert.notEmpty(graphs, "The graphs input cannot be null/empty.");
        Arrays.stream(graphs).forEach(graph -> isValid(graph));
    }


    public static void isConnected(Graph graph)
    {
        isValid(graph);
        Assert.isFalse(graph.isNotConnected(), "Graph is not connected.");
    }


    public static void isWeighted(Graph graph)
    {
        isValid(graph);
        Assert.isTrue(graph.isWeightedGraph(), "Graph is not weighted. All edges must have weights.");
    }


    public static void isSimple(Graph graph)
    {
        isValid(graph);
        Assert.isTrue(graph.isSimpleGraph(), "Graph is not simple.");
    }


    public static void doEdgesHavePositiveWeights(Graph graph)
    {
        isValid(graph);
        Assert.isFalse(graph.getEdges().findAny(edge -> edge.getWeight().isNonPositive()), "Graph edges must have positive weights.");
    }
}