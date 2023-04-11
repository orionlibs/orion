package com.orion.math.graph.path;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeRules;
import com.orion.math.graph.path.tasks.GetIndexOfVertexInPathTask;
import com.orion.math.graph.path.tasks.GetPathUnionTask;
import com.orion.math.graph.path.tasks.GetSubpathBetween2VerticesTask;
import com.orion.math.graph.path.tasks.GetVerticesOfPathTask;
import com.orion.math.graph.path.tasks.check.ArePathsIndependentTask;
import com.orion.math.graph.path.tasks.check.IsPathAnInducedCycleTask;
import com.orion.math.graph.path.tasks.check.IsPathHPathTask;
import com.orion.math.graph.path.tasks.check.IsPathIndependentFromAnotherTask;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;
import com.orion.math.graph.vertex.Vertices;
import com.orion.math.number.ANumber;

public class PathService extends OrionService
{
    public static Vertex[] getVertices(Path path)
    {
        return GetVerticesOfPathTask.run(path);
    }


    public static Vertex[] getInnerVertices(Path path)
    {
        OrionList<Vertex> vertices = path.getVerticesAsList();
        return vertices.subList(1, vertices.getSize() - 1).toArray(new Vertex[0]);
    }


    public static boolean isVertexInPath(Path path, Vertex vertex)
    {
        PathRules.isValid(path);
        VertexRules.isValid(vertex);
        return path.getVerticesAsList().findAny(v -> v.equals(vertex));
    }


    public static boolean isVertexNotInPath(Path path, Vertex vertex)
    {
        return !isVertexInPath(path, vertex);
    }


    public static int getIndexOfVertex(Path path, Vertex vertex)
    {
        return GetIndexOfVertexInPathTask.run(path, vertex);
    }


    public static Path getSubpath(Path path, Vertex fromVertex, Vertex toVertex)
    {
        return GetSubpathBetween2VerticesTask.run(path, fromVertex, toVertex);
    }


    public static GraphType getType(Path path)
    {
        PathRules.isValid(path);
        return Vertices.getType(path.getVerticesAsSet());
    }


    public static Path getUnion(Path path, Path other, Vertex connectingVertex)
    {
        return GetPathUnionTask.run(path, other, connectingVertex);
    }


    public static boolean isIndependentFrom(Path path, Path other)
    {
        return IsPathIndependentFromAnotherTask.run(path, other);
    }


    public static boolean areIndependent(Path... paths)
    {
        return ArePathsIndependentTask.run(paths);
    }


    public static boolean areIndependent(OrionSet<Path> paths)
    {
        return ArePathsIndependentTask.run(paths);
    }


    public static boolean isTrivial(Path path)
    {
        PathRules.isValid(path);
        return path.getVertices().length <= 1;
    }


    public static boolean isNotTrivial(Path path)
    {
        return !isTrivial(path);
    }


    public static boolean isHPath(Path path, Graph graph)
    {
        return IsPathHPathTask.run(path, graph);
    }


    public static boolean isCycle(Path path)
    {
        return isCircuit(path);
    }


    public static boolean isClosedWalk(Path path)
    {
        return isCircuit(path);
    }


    public static boolean isCircuit(Path path)
    {
        PathRules.isValid(path);
        return path.getNumberOfVertices() >= 3 && path.getFirstVertex().equals(path.getLastVertex());
    }


    public static boolean isKCycle(Path path, ANumber k)
    {
        PathRules.isValid(path);
        return isCycle(path) && path.getLength().equal(k);
    }


    public static boolean isChordOfCycle(Path path, Edge edge)
    {
        PathRules.isValid(path);
        EdgeRules.isValid(edge);
        return isCycle(path) && path.isNotEdgeInPath(edge) && path.isVertexInPath(edge.getFirst())
                        && path.isVertexInPath(edge.getSecond());
    }


    public static boolean isEdgeInPath(Path path, Edge edge)
    {
        PathRules.isValid(path);
        EdgeRules.isValid(edge);
        return path.getEdges().findAny(edge1 -> edge1.equals(edge));
    }


    public static boolean isNotEdgeInPath(Path path, Edge edge)
    {
        return !isEdgeInPath(path, edge);
    }


    public static boolean isInducedCycle(Path path, Graph graph)
    {
        return IsPathAnInducedCycleTask.run(path, graph);
    }


    public static boolean isOddCycle(Path path)
    {
        PathRules.isValid(path);
        return path.isCycle() && path.getLength().isOdd();
    }


    public static boolean isEvenCycle(Path path)
    {
        PathRules.isValid(path);
        return path.isCycle() && path.getLength().isEven();
    }


    public static boolean isSimple(Path path)
    {
        PathRules.isValid(path);
        return path.getEdgesAsSet().getSize() == path.getEdges().getSize();
    }


    public static boolean isTrail(Path path)
    {
        return isSimple(path);
    }
}