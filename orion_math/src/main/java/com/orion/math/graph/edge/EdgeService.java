package com.orion.math.graph.edge;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.tasks.CreateEdgeBetween2VerticesTask;
import com.orion.math.graph.edge.tasks.combination.GetAllPossibleDirectedEdgesOfGraphTask;
import com.orion.math.graph.edge.tasks.combination.GetAllPossibleUndirectedEdgesOfGraphTask;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;
import java.util.Arrays;
import java.util.stream.IntStream;

public class EdgeService extends OrionService
{
    public static boolean isIncidentAt(Edge edge, Vertex vertex)
    {
        EdgeRules.isValid(edge);
        VertexRules.isValid(vertex);
        return edge.getFirst().equals(vertex) || edge.getSecond().equals(vertex);
    }


    public static boolean isVertexFirst(Edge edge, Vertex vertex)
    {
        EdgeRules.isValid(edge);
        VertexRules.isValid(vertex);
        return edge.getFirst().equals(vertex);
    }


    public static boolean isVertexSecond(Edge edge, Vertex vertex)
    {
        EdgeRules.isValid(edge);
        VertexRules.isValid(vertex);
        return edge.getSecond().equals(vertex);
    }


    public static boolean isIncidentAt(Edge edge, Vertex v1, Vertex v2)
    {
        EdgeRules.isValid(edge);
        VertexRules.areValid(v1, v2);
        return (edge.getFirst().equals(v1) && edge.getSecond().equals(v2))
                        || edge.getSecond().equals(v1) && edge.getFirst().equals(v2);
    }


    public static boolean isAdjacentTo(Edge edge, Edge other)
    {
        EdgeRules.areValid(edge, other);
        return edge.notEquals(other) && (edge.getFirst().equals(other.getFirst()) || edge.getFirst().equals(other.getSecond())
                        || edge.getSecond().equals(other.getFirst()) || edge.getFirst().equals(other.getSecond()));
    }


    public static boolean isAdjacentTo(Edge edge, Edge... others)
    {
        EdgeRules.isValid(edge);
        EdgeRules.areValid(others);
        return isAdjacentTo(edge, OrionHashSet.<Edge>of(others));
    }


    public static boolean isAdjacentTo(Edge edge, OrionSet<Edge> others)
    {
        EdgeRules.isValid(edge);
        EdgeRules.areValid(others);
        return !others.findAny(e -> edge.isNotAdjacentTo(e));
    }


    public static boolean isNotAdjacentTo(Edge edge, Edge other)
    {
        return !isAdjacentTo(edge, other);
    }


    public static boolean isNotAdjacentTo(Edge edge, Edge... others)
    {
        return !isAdjacentTo(edge, others);
    }


    public static boolean isNotAdjacentTo(Edge edge, OrionSet<Edge> others)
    {
        return !isAdjacentTo(edge, others);
    }


    public static boolean isIndependentFrom(Edge edge, Edge other)
    {
        return isNotAdjacentTo(edge, other);
    }


    public static boolean isIndependentFrom(Edge edge, Edge... others)
    {
        return isNotAdjacentTo(edge, others);
    }


    public static boolean isIndependentFrom(Edge edge, OrionSet<Edge> others)
    {
        return isNotAdjacentTo(edge, others);
    }


    public static boolean isNotIndependentFrom(Edge edge, Edge other)
    {
        return !isIndependentFrom(edge, other);
    }


    public static boolean isParallelTo(Edge edge, Edge other)
    {
        EdgeRules.areValid(edge, other);
        return edge.notEquals(other) && edge.getFirst().equals(other.getFirst())
                        && edge.getSecond().equals(other.getSecond());
    }


    public static boolean isNotParallelTo(Edge edge, Edge other)
    {
        return !isParallelTo(edge, other);
    }


    public static boolean isParallelTo(Edge edge, Edge... others)
    {
        EdgeRules.isValid(edge);
        EdgeRules.areValid(others);
        return !Arrays.stream(others).anyMatch(other -> isNotParallelTo(edge, other));
    }


    public static boolean areParallel(Edge... edges)
    {
        EdgeRules.areValid(edges);
        Edge edge1 = edges[0];
        return !IntStream.range(1, edges.length).anyMatch(i -> isNotParallelTo(edge1, edges[i]));
    }


    public static boolean isLoop(Edge edge)
    {
        EdgeRules.isValid(edge);
        return edge.getFirst().equals(edge.getSecond());
    }


    public static OrionSet<Edge> getAllPossibleUndirectedEdges(OrionSet<Vertex> vertices)
    {
        return GetAllPossibleUndirectedEdgesOfGraphTask.run(vertices);
    }


    public static OrionSet<Edge> getAllPossibleDirectedEdges(OrionSet<Vertex> vertices)
    {
        return GetAllPossibleDirectedEdgesOfGraphTask.run(vertices);
    }


    public static Edge createEdgeBetween(GraphType graphType, Vertex v1, Vertex v2)
    {
        return CreateEdgeBetween2VerticesTask.run(graphType, v1, v2);
    }
}