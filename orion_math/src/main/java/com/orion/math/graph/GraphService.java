package com.orion.math.graph;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.OrionSetService;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.stream.OrionStream;
import com.orion.core.tuple.Pair;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeRules;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.path.PathRules;
import com.orion.math.graph.tasks.GetComplementOfUndirectedGraphTask;
import com.orion.math.graph.tasks.check.AreGraphVerticesIndependentTask;
import com.orion.math.graph.tasks.check.AreGraphsIsomorphicTask;
import com.orion.math.graph.tasks.check.DoPathsCoverGraphTask;
import com.orion.math.graph.tasks.check.IsEdgeBridgeBetween2GraphsTask;
import com.orion.math.graph.tasks.check.IsGraphAComponentTask;
import com.orion.math.graph.tasks.check.IsGraphCompleteTask;
import com.orion.math.graph.tasks.check.IsGraphConnectedTask;
import com.orion.math.graph.tasks.check.IsGraphKConnectedTask;
import com.orion.math.graph.tasks.check.IsGraphLEdgeConnectedTask;
import com.orion.math.graph.tasks.check.IsHamiltonPathOnGraphTask;
import com.orion.math.graph.tasks.check.IsSimpleGraphTask;
import com.orion.math.graph.tasks.check.IsVertexCutvertexBetween2GraphsTask;
import com.orion.math.graph.tasks.combination.GetAllPossibleEdgesForGraphTask;
import com.orion.math.graph.tasks.combination.GetGraphUnionTask;
import com.orion.math.graph.tasks.combination.GetIntersectionBetween2GraphsTask;
import com.orion.math.graph.tasks.combination.JoinVerticesOfGraphToVerticesOfAnotherTask;
import com.orion.math.graph.tasks.degree.GetDegreesOfVerticesTask;
import com.orion.math.graph.tasks.degree.GetIndegreeOfVertexTask;
import com.orion.math.graph.tasks.degree.GetIndegreesOfVerticesTask;
import com.orion.math.graph.tasks.degree.GetOutdegreeOfVertexTask;
import com.orion.math.graph.tasks.degree.GetOutdegreesOfVerticesTask;
import com.orion.math.graph.tasks.distance.Get2VerticesOfGraphWithDistanceAtLeastTask;
import com.orion.math.graph.tasks.distance.Get2VerticesOfGraphWithDistanceLessThanOrEqualToDistanceTask;
import com.orion.math.graph.tasks.distance.Get2VerticesOfGraphWithDistanceLessThanTask;
import com.orion.math.graph.tasks.distance.Get2VerticesOfGraphWithDistanceTask;
import com.orion.math.graph.tasks.distance.GetShortestPathBetween2VerticesOnWeightedGraphTask;
import com.orion.math.graph.tasks.distance.GetVerticesOfGraphWithDistanceFromVertexGreaterThanGivenDistanceTask;
import com.orion.math.graph.tasks.distance.GetVerticesOfGraphWithDistanceFromVertexGreaterThanOrEqualToGivenDistanceTask;
import com.orion.math.graph.tasks.distance.GetVerticesOfGraphWithDistanceFromVertexLessThanGivenDistanceTask;
import com.orion.math.graph.tasks.distance.GetVerticesOfGraphWithDistanceFromVertexLessThanOrEqualToGivenDistanceTask;
import com.orion.math.graph.tasks.distance.GetVerticesOfGraphWithGivenDistanceFromVertexTask;
import com.orion.math.graph.tasks.query.GetAdjacencyListForGraphTask;
import com.orion.math.graph.tasks.query.GetAdjacencyMatrixForGraphTask;
import com.orion.math.graph.tasks.query.GetAllPossibleSubgraphsOfGraphTask;
import com.orion.math.graph.tasks.query.GetBridgesOfGraphTask;
import com.orion.math.graph.tasks.query.GetCentralVerticesOfGraphTask;
import com.orion.math.graph.tasks.query.GetComponentsOfGraphTask;
import com.orion.math.graph.tasks.query.GetConnectivityOfGraphTask;
import com.orion.math.graph.tasks.query.GetCutverticesOfGraphTask;
import com.orion.math.graph.tasks.query.GetCyclesOfGraphTask;
import com.orion.math.graph.tasks.query.GetEccentricityOfVertexOfGraphTask;
import com.orion.math.graph.tasks.query.GetEdgeConnectivityOfGraphTask;
import com.orion.math.graph.tasks.query.GetEdgesThatInclude2VerticesOfGraphTask;
import com.orion.math.graph.tasks.query.GetGraphDiameterTask;
import com.orion.math.graph.tasks.query.GetIncidenceMatrixForGraphTask;
import com.orion.math.graph.tasks.query.GetMatchingNumberOfGraphTask;
import com.orion.math.graph.tasks.query.GetNeighbourEdgesOfVertexOfGraphTask;
import com.orion.math.graph.tasks.query.GetNeighbourVerticesOfVertexOfGraphTask;
import com.orion.math.graph.tasks.query.GetNonisolatedRandomVertexOfGraphTask;
import com.orion.math.graph.tasks.query.GetNumberOfMultipleEdgesInGraphTask;
import com.orion.math.graph.tasks.query.GetPathsBetween2VerticesOfGraphTask;
import com.orion.math.graph.tasks.query.GetRadiusOfGraphTask;
import com.orion.math.graph.tasks.query.GetRandomVertexFromGraphTask;
import com.orion.math.graph.tasks.transform.ContractEdgeOfGraphTask;
import com.orion.math.graph.tasks.transform.GetWheelForGraphTask;
import com.orion.math.graph.tasks.transform.SubtractEdgesFromGraphTask;
import com.orion.math.graph.tasks.transform.SubtractVerticesFromGraphTask;
import com.orion.math.graph.tasks.traversal.DoBreadthFirstTraversalInGraphTask;
import com.orion.math.graph.tasks.traversal.DoDepthFirstTraversalInGraphTask;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.average.function.ArithmeticAverageFunction;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphService extends OrionService
{
    public static ANumber getOrder(Graph graph)
    {
        GraphRules.isValid(graph);
        return ANumber.of(graph.getVertices().getSize());
    }


    public static List<Edge> getAllPossibleEdges(Graph graph)
    {
        return GetAllPossibleEdgesForGraphTask.run(graph);
    }


    public static List<Edge> getAllPossibleEdgesBetween(Graph graph, Graph other)
    {
        GraphRules.isValid(graph);
        return getAllPossibleEdges(graph.joinVerticesToVerticesOf(other));
    }


    public static boolean isTrivial(Graph graph)
    {
        GraphRules.isValid(graph);
        return graph.getVertices().getSize() <= 1;
    }


    public static boolean isNotTrivial(Graph graph)
    {
        return !isTrivial(graph);
    }


    public static boolean areAdjacent(Graph graph, Vertex v1, Vertex v2)
    {
        GraphRules.isValid(graph);
        VertexRules.areValid(v1, v2);
        return graph.getEdges().findAny(edge -> edge.isIncidentAt(v1) && edge.isIncidentAt(v2));
    }


    @SuppressWarnings("unchecked")
    public static boolean areAdjacent(Graph graph, Edge edge1, Edge edge2)
    {
        GraphRules.isValid(graph);
        GraphRules.areEdgesInGraph(graph, edge1, edge2);
        return OrionSetService.getIntersection(edge1.getAsOrionSet(), edge2.getAsOrionSet()).getSize() == 1;
    }


    public static boolean isComplete(Graph graph)
    {
        return IsGraphCompleteTask.run(graph);
    }


    public static Graph getUnion(Graph graph, Graph other)
    {
        return GetGraphUnionTask.run(graph, other);
    }


    public static Graph getIntersection(Graph graph, Graph other)
    {
        return GetIntersectionBetween2GraphsTask.run(graph, other);
    }


    public static boolean isDisjointWith(Graph graph, Graph other)
    {
        GraphRules.areValid(graph, other);
        Graph intersection = getIntersection(graph, other);
        return intersection.getVertices().isEmpty() && intersection.getEdges().isEmpty();
    }


    public static boolean isSubgraphOf(Graph graph, Graph other)
    {
        GraphRules.areValid(graph, other);
        return graph.getVertices().isSubsetOf(other.getVertices())
                        && graph.getEdges().isSubsetOf(other.getEdges());
    }


    public static boolean isSupergraphOf(Graph graph, Graph other)
    {
        return isSubgraphOf(other, graph);
    }


    public static boolean contains(Graph graph, Graph other)
    {
        return isSupergraphOf(graph, other);
    }


    public static boolean isInducedSubgraphOf(Graph graph, Graph other)
    {
        GraphRules.areValid(graph, other);
        return isSubgraphOf(graph, other) && graph.getEdges().equals(other.getEdges());
    }


    public static boolean doesGraphInduce(Graph graph, Graph other)
    {
        return isInducedSubgraphOf(graph, other);
    }


    public static boolean doesGraphSpan(Graph graph, Graph other)
    {
        return isInducedSubgraphOf(graph, other);
    }


    public static boolean isSpanningSubgraphOf(Graph graph, Graph other)
    {
        GraphRules.areValid(graph, other);
        return isSubgraphOf(graph, other) && graph.getVertices().equals(other.getVertices());
    }


    public static Graph subtract(Graph graph, Vertex[] verticesToDelete)
    {
        return SubtractVerticesFromGraphTask.run(graph, OrionHashSet.<Vertex>of(Arrays.asList(verticesToDelete)));
    }


    public static Graph subtract(Graph graph, Vertex vertexToDelete)
    {
        return SubtractVerticesFromGraphTask.run(graph, OrionHashSet.<Vertex>of(Arrays.asList(vertexToDelete)));
    }


    public static Graph subtract(Graph graph, OrionSet<Vertex> verticesToDelete)
    {
        return SubtractVerticesFromGraphTask.run(graph, verticesToDelete);
    }


    public static Graph subtract(Graph graph, OrionList<Vertex> verticesToDelete)
    {
        return SubtractVerticesFromGraphTask.run(graph, OrionHashSet.<Vertex>of(verticesToDelete));
    }


    public static Graph subtractEdges(Graph graph, Edge[] edgesToDelete)
    {
        return SubtractEdgesFromGraphTask.run(graph, OrionHashSet.<Edge>of(Arrays.asList(edgesToDelete)));
    }


    public static Graph subtractEdge(Graph graph, Edge edgeToDelete)
    {
        return SubtractEdgesFromGraphTask.run(graph, OrionHashSet.<Edge>of(Arrays.asList(edgeToDelete)));
    }


    public static Graph subtractEdges(Graph graph, OrionSet<Edge> edgesToDelete)
    {
        return SubtractEdgesFromGraphTask.run(graph, edgesToDelete);
    }


    public static Graph subtractEdges(Graph graph, OrionList<Edge> edgesToDelete)
    {
        return SubtractEdgesFromGraphTask.run(graph, OrionHashSet.<Edge>of(edgesToDelete));
    }


    public static Graph getComplement(Graph graph)
    {
        return GetComplementOfUndirectedGraphTask.run(graph);
    }


    public static Graph joinVerticesToVerticesOf(Graph graph, Graph other)
    {
        return JoinVerticesOfGraphToVerticesOfAnotherTask.run(graph, other);
    }


    public static OrionSet<Vertex> getNeighbourVerticesOf(Graph graph, Vertex vertex)
    {
        return GetNeighbourVerticesOfVertexOfGraphTask.run(graph, vertex);
    }


    public static OrionSet<Edge> getNeighbourEdgesOf(Graph graph, Vertex vertex)
    {
        return GetNeighbourEdgesOfVertexOfGraphTask.run(graph, vertex);
    }


    public static Pair<OrionSet<Vertex>, OrionSet<Edge>> getNeighbourhoodOf(Graph graph, Vertex vertex)
    {
        return Pair.of(getNeighbourVerticesOf(graph, vertex), getNeighbourEdgesOf(graph, vertex));
    }


    public static ANumber getDegreeOf(Graph graph, Vertex vertex)
    {
        return ANumber.of(getNeighbourVerticesOf(graph, vertex).getSize());
    }


    public static boolean isVertexIsolated(Graph graph, Vertex vertex)
    {
        GraphRules.isValid(graph);
        VertexRules.isValid(vertex);
        return graph.getEdges().findNone(edge -> edge.isIncidentAt(vertex));
    }


    public static ANumber[] getDegrees(Graph graph)
    {
        return GetDegreesOfVerticesTask.run(graph);
    }


    public static ANumber[] getIndegrees(Graph graph)
    {
        return GetIndegreesOfVerticesTask.run(graph);
    }


    public static ANumber[] getOutdegrees(Graph graph)
    {
        return GetOutdegreesOfVerticesTask.run(graph);
    }


    public static ANumber getIndegreeOf(Graph graph, Vertex vertex)
    {
        return GetIndegreeOfVertexTask.run(graph, vertex);
    }


    public static ANumber getOutdegreeOf(Graph graph, Vertex vertex)
    {
        return GetOutdegreeOfVertexTask.run(graph, vertex);
    }


    public static ANumber getMinimumDegree(Graph graph)
    {
        return ArithmeticService.getMinimum(getDegrees(graph));
    }


    public static ANumber getMinimumIndegree(Graph graph)
    {
        return ArithmeticService.getMinimum(getIndegrees(graph));
    }


    public static ANumber getMinimumOutdegree(Graph graph)
    {
        return ArithmeticService.getMinimum(getOutdegrees(graph));
    }


    public static ANumber getMaximumDegree(Graph graph)
    {
        return ArithmeticService.getMaximum(getDegrees(graph));
    }


    public static ANumber getMaximumIndegree(Graph graph)
    {
        return ArithmeticService.getMaximum(getIndegrees(graph));
    }


    public static ANumber getMaximumOutdegree(Graph graph)
    {
        return ArithmeticService.getMaximum(getOutdegrees(graph));
    }


    public static boolean isRegular(Graph graph)
    {
        return Numbers.areEqual(getDegrees(graph));
    }


    public static ANumber getAverageDegree(Graph graph)
    {
        return ArithmeticAverageFunction.run(getDegrees(graph));
    }


    public static ANumber getAverageIndegree(Graph graph)
    {
        return ArithmeticAverageFunction.run(getIndegrees(graph));
    }


    public static ANumber getAverageOutdegree(Graph graph)
    {
        return ArithmeticAverageFunction.run(getOutdegrees(graph));
    }


    public static boolean containsVertex(Graph graph, Vertex vertex)
    {
        GraphRules.isValid(graph);
        VertexRules.isValid(vertex);
        return graph.getVertices().contains(vertex);
    }


    public static boolean notContainsVertex(Graph graph, Vertex vertex)
    {
        return !containsVertex(graph, vertex);
    }


    public static boolean containsVertices(Graph graph, OrionSet<Vertex> vertices)
    {
        GraphRules.isValid(graph);
        VertexRules.areValid(vertices);
        return graph.getVertices().containsAll(vertices);
    }


    public static boolean notContainsVertices(Graph graph, OrionSet<Vertex> vertices)
    {
        return !containsVertices(graph, vertices);
    }


    public static boolean containsEdge(Graph graph, Edge edge)
    {
        GraphRules.isValid(graph);
        EdgeRules.isValid(edge);
        return graph.getEdges().contains(edge);
    }


    public static boolean notContainsEdge(Graph graph, Edge edge)
    {
        return !containsEdge(graph, edge);
    }


    public static boolean containsEdges(Graph graph, OrionSet<Edge> edges)
    {
        GraphRules.isValid(graph);
        EdgeRules.areValid(edges);
        return graph.getEdges().containsAll(edges);
    }


    public static boolean notContainsEdges(Graph graph, OrionSet<Edge> edges)
    {
        return !containsEdges(graph, edges);
    }


    public static Edge[] getEdgesThatIncludeVertex(Graph graph, Vertex vertex)
    {
        GraphRules.isValid(graph);
        VertexRules.haveSameType(graph.getVertices(), vertex);
        return OrionStream.getAsList(graph.getEdges()
                        .filter(edge -> edge.isIncidentAt(vertex))).toArray(new Edge[0]);
    }


    public static Edge[] getEdgesThatIncludeVertexAsFirst(Graph graph, Vertex vertex)
    {
        GraphRules.isValid(graph);
        VertexRules.haveSameType(graph.getVertices(), vertex);
        return OrionStream.getAsList(graph.getEdges()
                        .filter(edge -> edge.isVertexFirst(vertex))).toArray(new Edge[0]);
    }


    public static Edge[] getEdgesThatIncludeVertexAsSecond(Graph graph, Vertex vertex)
    {
        GraphRules.isValid(graph);
        VertexRules.haveSameType(graph.getVertices(), vertex);
        return OrionStream.getAsList(graph.getEdges()
                        .filter(edge -> edge.isVertexSecond(vertex))).toArray(new Edge[0]);
    }


    public static Path[] getCycles(Graph graph)
    {
        return GetCyclesOfGraphTask.run(graph);
    }


    public static ANumber getGirth(Graph graph)
    {
        OptionalInt minimumCycleLength = Arrays.stream(getCycles(graph)).mapToInt(cycle -> cycle.getLengthAsInt()).min();
        return minimumCycleLength.isPresent() ? ANumber.of(minimumCycleLength.getAsInt()) : ANumber.of(0);
    }


    public static ANumber getCircumference(Graph graph)
    {
        OptionalInt minimumCycleLength = Arrays.stream(getCycles(graph)).mapToInt(cycle -> cycle.getLengthAsInt()).max();
        return minimumCycleLength.isPresent() ? ANumber.of(minimumCycleLength.getAsInt()) : ANumber.of(0);
    }


    public static Path[] getPathsBetween(Graph graph, Vertex v1, Vertex v2)
    {
        return new GetPathsBetween2VerticesOfGraphTask().run(graph, v1, v2);
    }


    public static ANumber getNumberOfPathsBetween(Graph graph, Vertex v1, Vertex v2)
    {
        Path[] paths = getPathsBetween(graph, v1, v2);

        if(paths != null)
        {
            return ANumber.of(paths.length);
        }
        else
        {
            return ANumber.of(0);
        }

    }


    public static ANumber getDistanceBetween(Graph graph, Vertex v1, Vertex v2)
    {
        OptionalInt minimumPathLength = Arrays.stream(getPathsBetween(graph, v1, v2)).mapToInt(path -> path.getLengthAsInt()).min();
        return minimumPathLength.isPresent() ? ANumber.of(minimumPathLength.getAsInt()) : ANumber.ofMax();
    }


    public static ANumber getLargestDistanceBetween(Graph graph, Vertex v1, Vertex v2)
    {
        OptionalInt maximumPathLength = Arrays.stream(getPathsBetween(graph, v1, v2)).mapToInt(path -> path.getLengthAsInt()).max();
        return maximumPathLength.isPresent() ? ANumber.of(maximumPathLength.getAsInt()) : ANumber.of(0);
    }


    public static ANumber getDiameter(Graph graph)
    {
        return GetGraphDiameterTask.run(graph);
    }


    public static Pair<Vertex, Vertex> get2VerticesWithDistance(Graph graph, ANumber distance)
    {
        return Get2VerticesOfGraphWithDistanceTask.run(graph, distance);
    }


    public static Pair<Vertex, Vertex> get2VerticesWithDistanceAtLeast(Graph graph, ANumber distance)
    {
        return Get2VerticesOfGraphWithDistanceAtLeastTask.run(graph, distance);
    }


    public static Pair<Vertex, Vertex> get2VerticesWithDistanceLessThan(Graph graph, ANumber distance)
    {
        return Get2VerticesOfGraphWithDistanceLessThanTask.run(graph, distance);
    }


    public static Pair<Vertex, Vertex> get2VerticesWithDistanceLessThanOrEqualTo(Graph graph, ANumber distance)
    {
        return Get2VerticesOfGraphWithDistanceLessThanOrEqualToDistanceTask.run(graph, distance);
    }


    public static ANumber getEccentricityOfVertex(Graph graph, Vertex vertex)
    {
        return GetEccentricityOfVertexOfGraphTask.run(graph, vertex);
    }


    public static Vertex[] getCentralVertices(Graph graph)
    {
        return GetCentralVerticesOfGraphTask.run(graph);
    }


    public static boolean isVertexCentral(Graph graph, Vertex vertex)
    {
        VertexRules.isValid(vertex);
        return Arrays.stream(getCentralVertices(graph)).anyMatch(cv -> cv.equals(vertex));
    }


    public static ANumber getRadius(Graph graph)
    {
        return GetRadiusOfGraphTask.run(graph);
    }


    public static Vertex[] getVerticesWithGivenDistanceFromVertex(Graph graph, ANumber distance, Vertex vertex)
    {
        return GetVerticesOfGraphWithGivenDistanceFromVertexTask.run(graph, distance, vertex);
    }


    public static Vertex[] getVerticesWithDistanceFromVertexLessThanGivenDistance(Graph graph, ANumber distance, Vertex vertex)
    {
        return GetVerticesOfGraphWithDistanceFromVertexLessThanGivenDistanceTask.run(graph, distance, vertex);
    }


    public static Vertex[] getVerticesWithDistanceFromVertexLessThanOrEqualToGivenDistance(Graph graph, ANumber distance, Vertex vertex)
    {
        return GetVerticesOfGraphWithDistanceFromVertexLessThanOrEqualToGivenDistanceTask.run(graph, distance, vertex);
    }


    public static Vertex[] getVerticesWithDistanceFromVertexGreaterThanGivenDistance(Graph graph, ANumber distance, Vertex vertex)
    {
        return GetVerticesOfGraphWithDistanceFromVertexGreaterThanGivenDistanceTask.run(graph, distance, vertex);
    }


    public static Vertex[] getVerticesWithDistanceFromVertexGreaterThanOrEqualToGivenDistance(Graph graph, ANumber distance, Vertex vertex)
    {
        return GetVerticesOfGraphWithDistanceFromVertexGreaterThanOrEqualToGivenDistanceTask.run(graph, distance, vertex);
    }


    public static boolean isTherePathBetween(Graph graph, Vertex v1, Vertex v2)
    {
        return getPathsBetween(graph, v1, v2).length > 0;
    }


    public static boolean isConnected(Graph graph)
    {
        return IsGraphConnectedTask.run(graph);
    }


    public static boolean isNotConnected(Graph graph)
    {
        return !isConnected(graph);
    }


    public static boolean isComponent(Graph graph, Graph subgraph)
    {
        return IsGraphAComponentTask.run(graph, subgraph);
    }


    public static Graph[] getAllPossibleSubgraphs(Graph graph)
    {
        return GetAllPossibleSubgraphsOfGraphTask.run(graph);
    }


    public static Graph[] getComponents(Graph graph)
    {
        return GetComponentsOfGraphTask.run(graph);
    }


    public static boolean isCutvertex(Graph graph, Graph component, Vertex vertex)
    {
        return IsVertexCutvertexBetween2GraphsTask.run(graph, component, vertex);
    }


    public static boolean isNotCutvertex(Graph graph, Graph component, Vertex vertex)
    {
        return !isCutvertex(graph, component, vertex);
    }


    public static boolean areCutvertices(Graph graph, Graph component, OrionSet<Vertex> vertices)
    {
        GraphRules.isValid(graph);
        return graph.isComponent(component) && component.containsVertices(vertices)
                        && !vertices.findAny(vertex -> graph.isNotCutvertex(component, vertex));
    }


    public static boolean isBridge(Graph graph, Graph component, Edge edge)
    {
        return IsEdgeBridgeBetween2GraphsTask.run(graph, component, edge);
    }


    public static boolean isNotBridge(Graph graph, Graph component, Edge edge)
    {
        return !isBridge(graph, component, edge);
    }


    public static boolean areBridges(Graph graph, Graph component, OrionSet<Edge> edges)
    {
        GraphRules.isValid(graph);
        return graph.isComponent(component) && component.containsEdges(edges)
                        && !edges.findAny(edge -> graph.isNotBridge(component, edge));
    }


    public static Vertex[] getCutvertices(Graph graph)
    {
        return GetCutverticesOfGraphTask.run(graph);
    }


    public static Edge[] getBridges(Graph graph)
    {
        return GetBridgesOfGraphTask.run(graph);
    }


    public static boolean isKConnected(Graph graph, ANumber k)
    {
        return IsGraphKConnectedTask.run(graph, k);
    }


    public static ANumber getConnectivity(Graph graph)
    {
        return GetConnectivityOfGraphTask.run(graph);
    }


    public static boolean isLEdgeConnected(Graph graph, ANumber l)
    {
        return IsGraphLEdgeConnectedTask.run(graph, l);
    }


    public static ANumber getEdgeConnectivity(Graph graph)
    {
        return GetEdgeConnectivityOfGraphTask.run(graph);
    }


    public static ANumber getNumberOfCycles(Graph graph)
    {
        return ANumber.of(getCycles(graph).length);
    }


    public static boolean isAcyclic(Graph graph)
    {
        return getNumberOfCycles(graph).isZero();
    }


    public static boolean isForest(Graph graph)
    {
        return isAcyclic(graph);
    }


    public static boolean isTree(Graph graph)
    {
        return isAcyclic(graph) && isConnected(graph)
                        && graph.getNumberOfEdgesAsNumber().equal(graph.getOrder().subtractOneGET());
    }


    public static boolean isBipartite(Graph graph)
    {
        GraphRules.isValid(graph);
        Path[] paths = graph.getCycles();
        return !Arrays.stream(paths).anyMatch(path -> path.isEvenCycle());
    }


    public static Graph contractEdge(Graph graph, Edge edge)
    {
        return ContractEdgeOfGraphTask.run(graph, edge);
    }


    public static boolean isEulerian(Graph graph)
    {
        GraphRules.isValid(graph);
        return graph.isConnected() && !graph.getVertices().findAny(v -> graph.getDegreeOf(v).isOdd());
    }


    public static boolean doEdgesBelongToCycleSpace(Graph graph, OrionSet<Edge> edges)
    {
        GraphRules.isValid(graph);
        GraphRules.areEdgesInGraph(graph, edges);
        return !edges.findAny(edge -> graph.getDegreeOf(edge.getFirst()).isOdd())
                        && !edges.findAny(edge -> graph.getDegreeOf(edge.getSecond()).isOdd());
    }


    public static ANumber getDimensionsOfCycleSpace(Graph graph)
    {
        GraphRules.isValid(graph);
        return (graph.isConnected()) ? graph.getNumberOfEdgesAsNumber().subtractGET(getDimensionsOfCutSpace(graph)) : ANumber.of(0);
    }


    public static ANumber getDimensionsOfCutSpace(Graph graph)
    {
        GraphRules.isValid(graph);
        return (graph.isConnected()) ? graph.getOrder().subtractOneGET() : ANumber.of(0);
    }


    public static ANumber getNumberOfEdgesThatInclude(Graph graph, Vertex v1, Vertex v2)
    {
        GraphRules.isValid(graph);
        GraphRules.areVerticesInGraph(graph, v1, v2);
        return ANumber.of(graph.getEdges().filter(edge -> edge.isIncidentAt(v1, v2)).count());
    }


    public static boolean areAdjacentByMultipleEdges(Graph graph, Vertex v1, Vertex v2)
    {
        return getNumberOfEdgesThatInclude(graph, v1, v2).isGreaterThan(1);
    }


    public static Edge[] getEdgesThatInclude(Graph graph, Vertex v1, Vertex v2)
    {
        return GetEdgesThatInclude2VerticesOfGraphTask.run(graph, v1, v2);
    }


    public static ANumber getNumberOfLoops(Graph graph)
    {
        GraphRules.isValid(graph);
        return ANumber.of(graph.getEdges().filter(edge -> edge.isLoop()).count());
    }


    public static Edge[] getLoops(Graph graph)
    {
        GraphRules.isValid(graph);
        return graph.getEdges().filter(edge -> edge.isLoop()).collect(Collectors.toList()).toArray(new Edge[0]);
    }


    public static ANumber getNumberOfMultipleEdges(Graph graph)
    {
        return GetNumberOfMultipleEdgesInGraphTask.run(graph);
    }


    public static Vertex getRandomVertex(Graph graph)
    {
        return GetRandomVertexFromGraphTask.run(graph);
    }


    public static Vertex getNonisolatedRandomVertex(Graph graph)
    {
        return GetNonisolatedRandomVertexOfGraphTask.run(graph);
    }


    public static Vertex[] getIsolatedVertices(Graph graph)
    {
        GraphRules.isValid(graph);
        Stream<Vertex> stream = graph.getVerticesAsList().filter(v -> graph.isVertexIsolated(v));
        return OrionStream.getAsArray(stream, Vertex.class);
    }


    public static void doDepthFirstTraversal(Graph graph, Consumer<Vertex> action)
    {
        DoDepthFirstTraversalInGraphTask.run(graph, action);
    }


    public static void doDepthFirstTraversal(Graph graph, Vertex startVertex, Consumer<Vertex> action)
    {
        DoDepthFirstTraversalInGraphTask.run(graph, startVertex, action);
    }


    public static void doBreadthFirstTraversal(Graph graph, Consumer<Vertex> action)
    {
        DoBreadthFirstTraversalInGraphTask.run(graph, action);
    }


    public static void doBreadthFirstTraversal(Graph graph, Vertex startVertex, Consumer<Vertex> action)
    {
        DoBreadthFirstTraversalInGraphTask.run(graph, startVertex, action);
    }


    public static boolean areEdgesIndependent(Graph graph, OrionSet<Edge> edges)
    {
        GraphRules.isValid(graph);
        GraphRules.areEdgesInGraph(graph, edges);
        OrionList<Edge> edgesList = edges.getAsOrionList();
        return !edgesList.findAnyInPairsCountedOnce((i, j) -> edgesList.get(i).isNotIndependentFrom(edgesList.get(j)));
    }


    public static boolean areVerticesIndependent(Graph graph, OrionSet<Vertex> vertices)
    {
        return AreGraphVerticesIndependentTask.run(graph, vertices);
    }


    public static boolean isAMatching(Graph graph, OrionSet<Edge> edges)
    {
        return areEdgesIndependent(graph, edges);
    }


    public static boolean isPerfectMatching(Graph graph, OrionSet<Edge> edges)
    {
        return getMatchingNumber(graph).equal(graph.getNumberOfVertices() / 2);
    }


    public static ANumber getMatchingNumber(Graph graph)
    {
        return GetMatchingNumberOfGraphTask.run(graph);
    }


    public static boolean isAMatchingOfVertices(Graph graph, OrionSet<Edge> edges, OrionSet<Vertex> vertices)
    {
        GraphRules.areVerticesInGraph(graph, vertices);
        return isAMatching(graph, edges)
                        && !vertices.findAny(vertex -> !edges.findAny(edge -> edge.isIncidentAt(vertex)));
    }


    public static boolean areVerticesMatchedByEdges(Graph graph, OrionSet<Vertex> vertices, OrionSet<Edge> edges)
    {
        return isAMatchingOfVertices(graph, edges, vertices);
    }


    public static boolean areVerticesACover(Graph graph, OrionSet<Vertex> vertices)
    {
        GraphRules.isValid(graph);
        GraphRules.areVerticesInGraph(graph, vertices);
        return !graph.getEdges().findAny(edge -> vertices.notContains(edge.getFirst()) && vertices.notContains(edge.getSecond()));
    }


    public static boolean doesPathBelongToGraph(Graph graph, Path path)
    {
        GraphRules.isValid(graph);
        PathRules.isValid(path);
        return !path.getEdges().findAny(edge -> graph.notContainsVertex(edge.getFirst()) || graph.notContainsVertex(edge.getSecond()));
    }


    public static boolean doesPathNotBelongToGraph(Graph graph, Path path)
    {
        return !doesPathBelongToGraph(graph, path);
    }


    public static boolean isPathCover(Graph graph, OrionSet<Path> paths)
    {
        return DoPathsCoverGraphTask.run(graph, paths);
    }


    public static boolean isSimpleGraph(Graph graph)
    {
        return IsSimpleGraphTask.run(graph);
    }


    public static boolean isMultigraph(Graph graph)
    {
        return !isSimpleGraph(graph);
    }


    public static boolean isPseudograph(Graph graph)
    {
        return getNumberOfLoops(graph).isGreaterThan(0) && isMultigraph(graph);
    }


    public static ANumber getMultiplicityOfEdge(Graph graph, Edge edge)
    {
        return getNumberOfEdgesThatInclude(graph, edge.getFirst(), edge.getSecond());
    }


    public static boolean isVertexPendant(Graph graph, Vertex vertex)
    {
        return getDegreeOf(graph, vertex).isOne();
    }


    public static Edge[] getWheel(Graph graph, Path cycle, Vertex vertex)
    {
        return GetWheelForGraphTask.run(graph, cycle, vertex);
    }


    public static OrionList<ANumber> getSequenceOfDegrees(Graph graph)
    {
        return OrionArrayList.<ANumber>of(getDegrees(graph)).sortReverseGET();
    }


    public static boolean isSequenceOfDegreesGraphic(Graph graph)
    {
        return isSimpleGraph(graph);
    }


    public static Map<Vertex, List<Vertex>> getAdjacencyList(Graph graph)
    {
        return GetAdjacencyListForGraphTask.run(graph);
    }


    public static Matrix getAdjacencyMatrix(Graph graph)
    {
        return GetAdjacencyMatrixForGraphTask.run(graph);
    }


    public static Matrix getIncidenceMatrix(Graph graph)
    {
        return GetIncidenceMatrixForGraphTask.run(graph);
    }


    public static boolean areVerticesAdjacent(Graph graph, Vertex v1, Vertex v2)
    {
        GraphRules.isValid(graph);
        GraphRules.areVerticesInGraph(graph, v1, v2);
        return graph.getEdges().findAny(edge -> edge.isIncidentAt(v1, v2));
    }


    public static boolean isGraphIsomorphicTo(Graph graph, Graph other)
    {
        return AreGraphsIsomorphicTask.run(graph, other);
    }


    public static boolean isSelfComplementary(Graph graph)
    {
        GraphRules.isValid(graph);
        return isGraphIsomorphicTo(graph, getComplement(graph));
    }


    public static boolean isHamiltonPath(Graph graph, Path path)
    {
        return IsHamiltonPathOnGraphTask.run(graph, path);
    }


    public static boolean doesGraphHaveAHamiltonCircuit(Graph graph)
    {
        GraphRules.isValid(graph);
        boolean areDegreesLessThanHalfTheNumberOfVertices = Arrays.stream(graph.getDegrees())
                        .anyMatch(degree -> degree.isLessThan(graph.getNumberOfVertices() / 2));
        return isSimpleGraph(graph) && graph.getNumberOfVertices() >= 3
                        && !areDegreesLessThanHalfTheNumberOfVertices;
    }


    public static boolean isWeightedGraph(Graph graph)
    {
        GraphRules.isValid(graph);
        return !graph.getEdges().findAny(edge -> edge.getWeight() == null);
    }


    public static Path getShortestPathBetween2VerticesOnWeightedGraph(Graph graph, Vertex v1, Vertex v2)
    {
        return new GetShortestPathBetween2VerticesOnWeightedGraphTask().run(graph, v1, v2);
    }


    public static ANumber getLengthOfShortestPathBetween2VerticesForSimpleConnectedWeightedGraph(Graph graph, Vertex v1, Vertex v2)
    {
        GetShortestPathBetween2VerticesOnWeightedGraphTask task = new GetShortestPathBetween2VerticesOnWeightedGraphTask();
        task.run(graph, v1, v2);
        return task.getLengthOfPath();
    }


    public static ANumber getNumberOfRegionsForPlanarRepresentation(Graph graph)
    {
        GraphRules.isSimple(graph);
        GraphRules.isConnected(graph);
        return graph.getNumberOfEdgesAsNumber().subtractGET(graph.getNumberOfVertices()).addGET(2);
    }


    public static ANumber getNumberOfProperColorings(Graph graph, int numberOfColors)
    {
        GraphRules.isConnected(graph);
        NumberRules.isPositive(numberOfColors);
        return ANumber.of(numberOfColors).exponentiateGET(graph.getNumberOfVertices());
    }
}