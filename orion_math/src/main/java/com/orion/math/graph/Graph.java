package com.orion.math.graph;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.tree.Tree;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.Vertices;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Graph implements MathObject, Cloneable
{
    private OrionSet<Vertex> vertices;
    private OrionSet<Edge> edges;
    private boolean isEmpty;


    public Graph()
    {
        this.isEmpty = true;
    }


    public Graph(OrionSet<Vertex> vertices)
    {
        GraphRules.isValid(vertices);
        this.vertices = vertices;
        this.edges = OrionHashSet.<Edge>of();
    }


    public Graph(OrionSet<Vertex> vertices, OrionSet<Edge> edges)
    {
        GraphRules.isValid(vertices, edges);
        this.vertices = vertices;
        this.edges = edges;
    }


    public Graph(Collection<Vertex> vertices, Collection<Edge> edges)
    {
        GraphRules.isValid(vertices, edges);
        this.vertices = OrionHashSet.<Vertex>of(vertices);
        this.edges = OrionHashSet.<Edge>of(edges);
    }


    public Graph(Collection<Vertex> vertices)
    {
        GraphRules.isValid(vertices);
        this.vertices = OrionHashSet.<Vertex>of(vertices);
        this.edges = OrionHashSet.<Edge>of();
    }


    public Graph(OrionSet<Vertex> vertices, Collection<Edge> edges)
    {
        GraphRules.isValid(vertices, edges);
        this.vertices = vertices;
        this.edges = OrionHashSet.<Edge>of(edges);
    }


    public Graph(Collection<Vertex> vertices, OrionSet<Edge> edges)
    {
        GraphRules.isValid(vertices, edges);
        this.vertices = OrionHashSet.<Vertex>of(vertices);
        this.edges = edges;
    }


    public Graph(Map<Vertex, List<Vertex>> adjacencyList)
    {
        GraphRules.isValid(adjacencyList);
        this.vertices = OrionHashSet.<Vertex>of(adjacencyList.keySet());
        this.edges = GraphInternalService.buildEdgesFromAdjacencyList(getType(), adjacencyList);
    }


    public Graph(OrionSet<Vertex> vertices, Matrix adjacencyMatrix)
    {
        GraphRules.isValid(vertices, adjacencyMatrix);
        this.vertices = vertices;
        this.edges = GraphInternalService.buildEdgesFromAdjacencyMatrix(getType(), vertices, adjacencyMatrix);
    }


    public static Graph of()
    {
        return new Graph();
    }


    public static Graph of(OrionSet<Vertex> vertices)
    {
        return new Graph(vertices);
    }


    public static Graph of(OrionSet<Vertex> vertices, OrionSet<Edge> edges)
    {
        return new Graph(vertices, edges);
    }


    public static Graph of(Collection<Vertex> vertices)
    {
        return new Graph(vertices);
    }


    public static Graph of(Collection<Vertex> vertices, Collection<Edge> edges)
    {
        return new Graph(vertices, edges);
    }


    public static Graph of(OrionSet<Vertex> vertices, Collection<Edge> edges)
    {
        return new Graph(vertices, edges);
    }


    public static Graph of(Collection<Vertex> vertices, OrionSet<Edge> edges)
    {
        return new Graph(vertices, edges);
    }


    public static Graph of(Map<Vertex, List<Vertex>> adjacencyList)
    {
        return new Graph(adjacencyList);
    }


    public static Graph of(OrionSet<Vertex> vertices, Matrix adjacencyMatrix)
    {
        return new Graph(vertices, adjacencyMatrix);
    }


    public ANumber getOrder()
    {
        return GraphService.getOrder(this);
    }


    public int getOrderAsInt()
    {
        return getOrder().getAsInteger().intValue();
    }


    public List<Edge> getAllPossibleEdges()
    {
        return GraphService.getAllPossibleEdges(this);
    }


    public List<Edge> getAllPossibleEdgesBetween(Graph other)
    {
        return GraphService.getAllPossibleEdgesBetween(this, other);
    }


    public boolean isTrivial()
    {
        return GraphService.isTrivial(this);
    }


    public boolean isNotTrivial()
    {
        return GraphService.isNotTrivial(this);
    }


    public boolean areAdjacent(Vertex v1, Vertex v2)
    {
        return GraphService.areAdjacent(this, v1, v2);
    }


    public boolean areAdjacent(Edge edge1, Edge edge2)
    {
        return GraphService.areAdjacent(this, edge1, edge2);
    }


    public boolean isComplete()
    {
        return GraphService.isComplete(this);
    }


    public Graph getUnion(Graph other)
    {
        return GraphService.getUnion(this, other);
    }


    public Graph getIntersection(Graph other)
    {
        return GraphService.getIntersection(this, other);
    }


    public boolean isDisjointWith(Graph other)
    {
        return GraphService.isDisjointWith(this, other);
    }


    public boolean isSubgraphOf(Graph other)
    {
        return GraphService.isSubgraphOf(this, other);
    }


    public boolean isSupergraphOf(Graph other)
    {
        return GraphService.isSupergraphOf(this, other);
    }


    public boolean contains(Graph other)
    {
        return GraphService.contains(this, other);
    }


    public boolean isInducedSubgraphOf(Graph other)
    {
        return GraphService.isInducedSubgraphOf(this, other);
    }


    public boolean doesGraphInduce(Graph other)
    {
        return GraphService.doesGraphInduce(this, other);
    }


    public boolean doesGraphSpan(Graph other)
    {
        return GraphService.doesGraphSpan(this, other);
    }


    public boolean isSpanningSubgraphOf(Graph other)
    {
        return GraphService.isSpanningSubgraphOf(this, other);
    }


    public Graph subtract(Vertex[] verticesToDelete)
    {
        return GraphService.subtract(this, verticesToDelete);
    }


    public Graph subtract(Vertex vertexToDelete)
    {
        return GraphService.subtract(this, vertexToDelete);
    }


    public Graph subtract(OrionSet<Vertex> verticesToDelete)
    {
        return GraphService.subtract(this, verticesToDelete);
    }


    public Graph subtract(OrionList<Vertex> verticesToDelete)
    {
        return GraphService.subtract(this, verticesToDelete);
    }


    public Graph subtractEdge(Edge edgeToDelete)
    {
        return GraphService.subtractEdge(this, edgeToDelete);
    }


    public Graph subtractEdges(Edge[] edgesToDelete)
    {
        return GraphService.subtractEdges(this, edgesToDelete);
    }


    public Graph subtractEdges(OrionSet<Edge> edgesToDelete)
    {
        return GraphService.subtractEdges(this, edgesToDelete);
    }


    public Graph subtractEdges(OrionList<Edge> edgesToDelete)
    {
        return GraphService.subtractEdges(this, edgesToDelete);
    }


    public Graph getComplement()
    {
        return GraphService.getComplement(this);
    }


    public Graph joinVerticesToVerticesOf(Graph other)
    {
        return GraphService.joinVerticesToVerticesOf(this, other);
    }


    public OrionSet<Vertex> getNeighbourVerticesOf(Vertex vertex)
    {
        return GraphService.getNeighbourVerticesOf(this, vertex);
    }


    public OrionSet<Edge> getNeighbourEdgesOf(Vertex vertex)
    {
        return GraphService.getNeighbourEdgesOf(this, vertex);
    }


    public Pair<OrionSet<Vertex>, OrionSet<Edge>> getNeighbourhoodOf(Vertex vertex)
    {
        return GraphService.getNeighbourhoodOf(this, vertex);
    }


    public ANumber getDegreeOf(Vertex vertex)
    {
        return GraphService.getDegreeOf(this, vertex);
    }


    public ANumber getIndegreeOf(Vertex vertex)
    {
        return GraphService.getIndegreeOf(this, vertex);
    }


    public ANumber getOutdegreeOf(Vertex vertex)
    {
        return GraphService.getOutdegreeOf(this, vertex);
    }


    public boolean isVertexIsolated(Vertex vertex)
    {
        return GraphService.isVertexIsolated(this, vertex);
    }


    public ANumber[] getDegrees()
    {
        return GraphService.getDegrees(this);
    }


    public ANumber getMinimumDegree()
    {
        return GraphService.getMinimumDegree(this);
    }


    public ANumber getMinimumIndegree()
    {
        return GraphService.getMinimumIndegree(this);
    }


    public ANumber getMinimumOutdegree()
    {
        return GraphService.getMinimumOutdegree(this);
    }


    public ANumber getMaximumDegree()
    {
        return GraphService.getMaximumDegree(this);
    }


    public ANumber getMaximumIndegree()
    {
        return GraphService.getMaximumIndegree(this);
    }


    public ANumber getMaximumOutdegree()
    {
        return GraphService.getMaximumOutdegree(this);
    }


    public boolean isRegular()
    {
        return GraphService.isRegular(this);
    }


    public ANumber getAverageDegree()
    {
        return GraphService.getAverageDegree(this);
    }


    public ANumber getAverageIndegree()
    {
        return GraphService.getAverageIndegree(this);
    }


    public ANumber getAverageOutdegree()
    {
        return GraphService.getAverageOutdegree(this);
    }


    public boolean containsVertex(Vertex vertex)
    {
        return GraphService.containsVertex(this, vertex);
    }


    public boolean notContainsVertex(Vertex vertex)
    {
        return GraphService.notContainsVertex(this, vertex);
    }


    public boolean containsVertices(OrionSet<Vertex> vertices)
    {
        return GraphService.containsVertices(this, vertices);
    }


    public boolean notContainsVertices(OrionSet<Vertex> vertices)
    {
        return GraphService.notContainsVertices(this, vertices);
    }


    public boolean containsEdge(Edge edge)
    {
        return GraphService.containsEdge(this, edge);
    }


    public boolean notContainsEdge(Edge edge)
    {
        return GraphService.notContainsEdge(this, edge);
    }


    public boolean containsEdges(OrionSet<Edge> edges)
    {
        return GraphService.containsEdges(this, edges);
    }


    public boolean notContainsEdges(OrionSet<Edge> edges)
    {
        return GraphService.notContainsEdges(this, edges);
    }


    public Path[] getCycles()
    {
        return GraphService.getCycles(this);
    }


    public Edge[] getEdgesThatIncludeVertex(Vertex vertex)
    {
        return GraphService.getEdgesThatIncludeVertex(this, vertex);
    }


    public OrionList<Edge> getEdgesThatIncludeVertexAsList(Vertex vertex)
    {
        return OrionArrayList.<Edge>of(getEdgesThatIncludeVertex(vertex));
    }


    public Edge[] getEdgesThatIncludeVertexAsFirst(Vertex vertex)
    {
        return GraphService.getEdgesThatIncludeVertexAsFirst(this, vertex);
    }


    public OrionList<Edge> getEdgesThatIncludeVertexAsFirstAsList(Vertex vertex)
    {
        return OrionArrayList.<Edge>of(getEdgesThatIncludeVertexAsFirst(vertex));
    }


    public Edge[] getEdgesThatIncludeVertexAsSecond(Vertex vertex)
    {
        return GraphService.getEdgesThatIncludeVertexAsSecond(this, vertex);
    }


    public OrionList<Edge> getEdgesThatIncludeVertexAsSecondAsList(Vertex vertex)
    {
        return OrionArrayList.<Edge>of(getEdgesThatIncludeVertexAsSecond(vertex));
    }


    public ANumber getGirth()
    {
        return GraphService.getGirth(this);
    }


    public ANumber getCircumference()
    {
        return GraphService.getCircumference(this);
    }


    public Path[] getPathsBetween(Vertex v1, Vertex v2)
    {
        return GraphService.getPathsBetween(this, v1, v2);
    }


    public ANumber getNumberOfPathsBetween(Vertex v1, Vertex v2)
    {
        return GraphService.getNumberOfPathsBetween(this, v1, v2);
    }


    public ANumber getDistanceBetween(Vertex v1, Vertex v2)
    {
        return GraphService.getDistanceBetween(this, v1, v2);
    }


    public ANumber getLargestDistanceBetween(Vertex v1, Vertex v2)
    {
        return GraphService.getLargestDistanceBetween(this, v1, v2);
    }


    public ANumber getDiameter()
    {
        return GraphService.getDiameter(this);
    }


    public Pair<Vertex, Vertex> get2VerticesWithDistance(ANumber distance)
    {
        return GraphService.get2VerticesWithDistance(this, distance);
    }


    public Pair<Vertex, Vertex> get2VerticesWithDistanceAtLeast(ANumber distance)
    {
        return GraphService.get2VerticesWithDistanceAtLeast(this, distance);
    }


    public Pair<Vertex, Vertex> get2VerticesWithDistanceLessThan(ANumber distance)
    {
        return GraphService.get2VerticesWithDistanceLessThan(this, distance);
    }


    public Pair<Vertex, Vertex> get2VerticesWithDistanceLessThanOrEqualTo(ANumber distance)
    {
        return GraphService.get2VerticesWithDistanceLessThanOrEqualTo(this, distance);
    }


    public Vertex[] getCentralVertices()
    {
        return GraphService.getCentralVertices(this);
    }


    public boolean isVertexCentral(Vertex vertex)
    {
        return GraphService.isVertexCentral(this, vertex);
    }


    public ANumber getEccentricityOfVertex(Vertex vertex)
    {
        return GraphService.getEccentricityOfVertex(this, vertex);
    }


    public ANumber getRadius()
    {
        return GraphService.getRadius(this);
    }


    public Vertex[] getVerticesWithGivenDistanceFromVertex(ANumber distance, Vertex vertex)
    {
        return GraphService.getVerticesWithGivenDistanceFromVertex(this, distance, vertex);
    }


    public Vertex[] getVerticesWithDistanceFromVertexLessThanGivenDistance(ANumber distance, Vertex vertex)
    {
        return GraphService.getVerticesWithDistanceFromVertexLessThanGivenDistance(this, distance, vertex);
    }


    public Vertex[] getVerticesWithDistanceFromVertexLessThanOrEqualToGivenDistance(ANumber distance, Vertex vertex)
    {
        return GraphService.getVerticesWithDistanceFromVertexLessThanOrEqualToGivenDistance(this, distance, vertex);
    }


    public Vertex[] getVerticesWithDistanceFromVertexGreaterThanGivenDistance(ANumber distance, Vertex vertex)
    {
        return GraphService.getVerticesWithDistanceFromVertexGreaterThanGivenDistance(this, distance, vertex);
    }


    public Vertex[] getVerticesWithDistanceFromVertexGreaterThanOrEqualToGivenDistance(ANumber distance, Vertex vertex)
    {
        return GraphService.getVerticesWithDistanceFromVertexGreaterThanOrEqualToGivenDistance(this, distance, vertex);
    }


    public boolean isTherePathBetween(Vertex v1, Vertex v2)
    {
        return GraphService.isTherePathBetween(this, v1, v2);
    }


    public boolean isConnected()
    {
        return GraphService.isConnected(this);
    }


    public boolean isNotConnected()
    {
        return GraphService.isNotConnected(this);
    }


    public boolean isComponent(Graph subgraph)
    {
        return GraphService.isComponent(this, subgraph);
    }


    public Graph[] getAllPossibleSubgraphs()
    {
        return GraphService.getAllPossibleSubgraphs(this);
    }


    public OrionList<Graph> getAllPossibleSubgraphsAsList()
    {
        return OrionArrayList.<Graph>of(getAllPossibleSubgraphs());
    }


    public Graph[] getComponents()
    {
        return GraphService.getComponents(this);
    }


    public boolean isCutvertex(Graph component, Vertex vertex)
    {
        return GraphService.isCutvertex(this, component, vertex);
    }


    public boolean isNotCutvertex(Graph component, Vertex vertex)
    {
        return GraphService.isNotCutvertex(this, component, vertex);
    }


    public boolean areCutvertices(Graph component, OrionSet<Vertex> vertices)
    {
        return GraphService.areCutvertices(this, component, vertices);
    }


    public boolean isBridge(Graph component, Edge edge)
    {
        return GraphService.isBridge(this, component, edge);
    }


    public boolean isNotBridge(Graph component, Edge edge)
    {
        return GraphService.isNotBridge(this, component, edge);
    }


    public boolean areBridges(Graph component, OrionSet<Edge> edges)
    {
        return GraphService.areBridges(this, component, edges);
    }


    public Vertex[] getCutvertices()
    {
        return GraphService.getCutvertices(this);
    }


    public Edge[] getBridges()
    {
        return GraphService.getBridges(this);
    }


    public boolean isKConnected(ANumber k)
    {
        return GraphService.isKConnected(this, k);
    }


    public ANumber getConnectivity()
    {
        return GraphService.getConnectivity(this);
    }


    public boolean isLEdgeConnected(ANumber l)
    {
        return GraphService.isLEdgeConnected(this, l);
    }


    public ANumber getEdgeConnectivity()
    {
        return GraphService.getEdgeConnectivity(this);
    }


    public ANumber getNumberOfCycles()
    {
        return GraphService.getNumberOfCycles(this);
    }


    public boolean isAcyclic()
    {
        return GraphService.isAcyclic(this);
    }


    public boolean isForest()
    {
        return GraphService.isForest(this);
    }


    public boolean isTree()
    {
        return GraphService.isTree(this);
    }


    public boolean isBipartite()
    {
        return GraphService.isBipartite(this);
    }


    public Graph contractEdge(Edge edge)
    {
        return GraphService.contractEdge(this, edge);
    }


    public boolean isEulerian()
    {
        return GraphService.isEulerian(this);
    }


    public boolean doEdgesBelongToCycleSpace(OrionSet<Edge> edges)
    {
        return GraphService.doEdgesBelongToCycleSpace(this, edges);
    }


    public ANumber getDimensionsOfCycleSpace()
    {
        return GraphService.getDimensionsOfCycleSpace(this);
    }


    public ANumber getDimensionsOfCutSpace()
    {
        return GraphService.getDimensionsOfCutSpace(this);
    }


    public ANumber getNumberOfEdgesThatInclude(Vertex v1, Vertex v2)
    {
        return GraphService.getNumberOfEdgesThatInclude(this, v1, v2);
    }


    public boolean areAdjacentByMultipleEdges(Vertex v1, Vertex v2)
    {
        return GraphService.areAdjacentByMultipleEdges(this, v1, v2);
    }


    public Edge[] getEdgesThatInclude(Vertex v1, Vertex v2)
    {
        return GraphService.getEdgesThatInclude(this, v1, v2);
    }


    public ANumber getNumberOfLoops()
    {
        return GraphService.getNumberOfLoops(this);
    }


    public Edge[] getLoops()
    {
        return GraphService.getLoops(this);
    }


    public ANumber getNumberOfMultipleEdges()
    {
        return GraphService.getNumberOfMultipleEdges(this);
    }


    public Vertex getRandomVertex()
    {
        return GraphService.getRandomVertex(this);
    }


    public Vertex getNonisolatedRandomVertex()
    {
        return GraphService.getNonisolatedRandomVertex(this);
    }


    public Vertex[] getIsolatedVertices()
    {
        return GraphService.getIsolatedVertices(this);
    }


    public void doDepthFirstTraversal(Consumer<Vertex> action)
    {
        GraphService.doDepthFirstTraversal(this, action);
    }


    public void doDepthFirstTraversal(Vertex startVertex, Consumer<Vertex> action)
    {
        GraphService.doDepthFirstTraversal(this, startVertex, action);
    }


    public void doBreadthFirstTraversal(Consumer<Vertex> action)
    {
        GraphService.doBreadthFirstTraversal(this, action);
    }


    public void doBreadthFirstTraversal(Vertex startVertex, Consumer<Vertex> action)
    {
        GraphService.doBreadthFirstTraversal(this, startVertex, action);
    }


    public boolean areEdgesIndependent(OrionSet<Edge> edges)
    {
        return GraphService.areEdgesIndependent(this, edges);
    }


    public boolean areVerticesIndependent(OrionSet<Vertex> vertices)
    {
        return GraphService.areVerticesIndependent(this, vertices);
    }


    public boolean isAMatching(OrionSet<Edge> edges)
    {
        return GraphService.isAMatching(this, edges);
    }


    public boolean isPerfectMatching(OrionSet<Edge> edges)
    {
        return GraphService.isPerfectMatching(this, edges);
    }


    public ANumber getMatchingNumber()
    {
        return GraphService.getMatchingNumber(this);
    }


    public boolean isAMatchingOfVertices(OrionSet<Edge> edges, OrionSet<Vertex> vertices)
    {
        return GraphService.isAMatchingOfVertices(this, edges, vertices);
    }


    public boolean areVerticesMatchedByEdges(OrionSet<Vertex> vertices, OrionSet<Edge> edges)
    {
        return GraphService.areVerticesMatchedByEdges(this, vertices, edges);
    }


    public boolean areVerticesACover(OrionSet<Vertex> vertices)
    {
        return GraphService.areVerticesACover(this, vertices);
    }


    public boolean doesPathBelongToGraph(Path path)
    {
        return GraphService.doesPathBelongToGraph(this, path);
    }


    public boolean doesPathNotBelongToGraph(Path path)
    {
        return GraphService.doesPathNotBelongToGraph(this, path);
    }


    public boolean isPathCover(OrionSet<Path> paths)
    {
        return GraphService.isPathCover(this, paths);
    }


    public boolean isSimpleGraph()
    {
        return GraphService.isSimpleGraph(this);
    }


    public boolean isMultigraph()
    {
        return GraphService.isMultigraph(this);
    }


    public boolean isPseudograph()
    {
        return GraphService.isPseudograph(this);
    }


    public ANumber getMultiplicityOfEdge(Edge edge)
    {
        return GraphService.getMultiplicityOfEdge(this, edge);
    }


    public boolean isVertexPendant(Vertex vertex)
    {
        return GraphService.isVertexPendant(this, vertex);
    }


    public Edge[] getWheel(Path cycle, Vertex vertex)
    {
        return GraphService.getWheel(this, cycle, vertex);
    }


    public OrionList<ANumber> getSequenceOfDegrees()
    {
        return GraphService.getSequenceOfDegrees(this);
    }


    public boolean isSequenceOfDegreesGraphic()
    {
        return GraphService.isSequenceOfDegreesGraphic(this);
    }


    public Map<Vertex, List<Vertex>> getAdjacencyList()
    {
        return GraphService.getAdjacencyList(this);
    }


    public Matrix getAdjacencyMatrix()
    {
        return GraphService.getAdjacencyMatrix(this);
    }


    public Matrix getIncidenceMatrix()
    {
        return GraphService.getIncidenceMatrix(this);
    }


    public boolean areVerticesAdjacent(Vertex v1, Vertex v2)
    {
        return GraphService.areVerticesAdjacent(this, v1, v2);
    }


    public boolean isGraphIsomorphicTo(Graph other)
    {
        return GraphService.isGraphIsomorphicTo(this, other);
    }


    public boolean isSelfComplementary()
    {
        return GraphService.isSelfComplementary(this);
    }


    public boolean isHamiltonPath(Path path)
    {
        return GraphService.isHamiltonPath(this, path);
    }


    public boolean doesGraphHaveAHamiltonCircuit()
    {
        return GraphService.doesGraphHaveAHamiltonCircuit(this);
    }


    public boolean isWeightedGraph()
    {
        return GraphService.isWeightedGraph(this);
    }


    public Path getShortestPathBetween2VerticesOnWeightedGraph(Vertex v1, Vertex v2)
    {
        return GraphService.getShortestPathBetween2VerticesOnWeightedGraph(this, v1, v2);
    }


    public ANumber getLengthOfShortestPathBetween2VerticesForSimpleConnectedWeightedGraph(Vertex v1, Vertex v2)
    {
        return GraphService.getLengthOfShortestPathBetween2VerticesForSimpleConnectedWeightedGraph(this, v1, v2);
    }


    public ANumber getNumberOfRegionsForPlanarRepresentation()
    {
        return GraphService.getNumberOfRegionsForPlanarRepresentation(this);
    }


    public ANumber getNumberOfProperColorings(int numberOfColors)
    {
        return GraphService.getNumberOfProperColorings(this, numberOfColors);
    }


    public Tree getAsTree()
    {
        return (isTree()) ? Tree.of(vertices, edges) : null;
    }


    public GraphType getType()
    {
        return Vertices.getType(getVertices());
    }


    public int getNumberOfVertices()
    {
        return getVertices().getSize();
    }


    public ANumber getNumberOfVerticesAsNumber()
    {
        return ANumber.of(getNumberOfVertices());
    }


    public int getNumberOfEdges()
    {
        return getEdges().getSize();
    }


    public ANumber getNumberOfEdgesAsNumber()
    {
        return ANumber.of(getNumberOfEdges());
    }


    public Vertex[] getVerticesAsArray()
    {
        return getVertices().getAsList().toArray(new Vertex[0]);
    }


    public Vertex[] getVerticesAsArrayCopy()
    {
        return getVertices().getAsOrionList().getCopy().toArray(new Vertex[0]);
    }


    public OrionList<Vertex> getVerticesAsList()
    {
        return getVertices().getAsOrionList();
    }


    public OrionList<Vertex> getVerticesAsListCopy()
    {
        return getVertices().getAsOrionList().getCopy();
    }


    public OrionSet<Vertex> getVerticesCopy()
    {
        return getVertices().getCopy();
    }


    public OrionSet<Edge> getEdgesCopy()
    {
        return getEdges().getCopy();
    }


    public Edge[] getEdgesAsArray()
    {
        return getEdges().getAsList().toArray(new Edge[0]);
    }


    public Edge[] getEdgesAsArrayCopy()
    {
        return getEdges().getAsOrionList().getCopy().toArray(new Edge[0]);
    }


    public OrionList<Edge> getEdgesAsList()
    {
        return getEdges().getAsOrionList();
    }


    public OrionList<Edge> getEdgesAsListCopy()
    {
        return getEdges().getAsOrionList().getCopy();
    }


    @Override
    public int hashCode()
    {
        return GraphInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return GraphInternalService.equals(this, object);
    }


    @Override
    public Graph clone() throws CloneNotSupportedException
    {
        return (Graph)CloningService.clone(this);
    }


    public Graph getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    public OrionSet<Vertex> getVertices()
    {
        return this.vertices;
    }


    public OrionSet<Edge> getEdges()
    {
        return this.edges;
    }


    public boolean isEmpty()
    {
        return this.isEmpty;
    }


    protected void setVertices(OrionSet<Vertex> vertices)
    {
        this.vertices = vertices;
    }


    protected void setEdges(OrionSet<Edge> edges)
    {
        this.edges = edges;
    }


    protected void setEmpty(boolean isEmpty)
    {
        this.isEmpty = isEmpty;
    }
}