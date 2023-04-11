package com.orion.math.graph.path;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class Path implements MathObject, Cloneable
{
    private OrionList<Edge> edges;
    private Vertex[] vertices;


    public Path(OrionList<Edge> edges)
    {
        PathRules.isValid(edges);
        this.edges = edges;
        this.vertices = PathService.getVertices(this);
    }


    public static Path of(OrionList<Edge> edges)
    {
        return new Path(edges);
    }


    public Pair<Vertex, Vertex> getEnds()
    {
        return Pair.of(getEdges().getFirst().getFirst(), getEdges().getLast().getSecond());
    }


    public Vertex getFirstVertex()
    {
        return getEdges().getFirst().getFirst();
    }


    public Vertex getLastVertex()
    {
        return getEdges().getLast().getSecond();
    }


    public Edge getEdge(int index)
    {
        return getEdges().get(index);
    }


    public Vertex getVertex(int index)
    {
        return getVertices()[index];
    }


    public Vertex getVertexCopy(int index)
    {
        return getVertex(index).getCopy();
    }


    public OrionList<Vertex> getVerticesAsList()
    {
        return OrionArrayList.<Vertex>of(getVertices());
    }


    public OrionList<Vertex> getVerticesAsListCopy()
    {
        return getVerticesAsList().getCopy();
    }


    public OrionSet<Vertex> getVerticesAsSet()
    {
        return OrionHashSet.<Vertex>of(getVertices());
    }


    public OrionSet<Vertex> getVerticesAsSetCopy()
    {
        return getVerticesAsSet().getCopy();
    }


    public Vertex[] getInnerVertices()
    {
        return PathService.getInnerVertices(this);
    }


    public Vertex[] getInnerVerticesCopy()
    {
        Vertex[] innerVertices = getInnerVertices();
        Vertex[] innerVerticesCopy = new Vertex[innerVertices.length];
        IntStream.range(0, innerVertices.length).forEach(i -> innerVerticesCopy[i] = innerVertices[i].getCopy());
        return innerVerticesCopy;
    }


    public OrionList<Vertex> getInnerVerticesAsList()
    {
        return OrionArrayList.<Vertex>of(getInnerVertices());
    }


    public OrionList<Vertex> getInnerVerticesAsListCopy()
    {
        return getInnerVerticesAsList().getCopy();
    }


    public OrionSet<Vertex> getInnerVerticesAsSet()
    {
        return OrionHashSet.<Vertex>of(getInnerVertices());
    }


    public OrionSet<Vertex> getInnerVerticesAsSetCopy()
    {
        return getInnerVerticesAsSet().getCopy();
    }


    public int getNumberOfVertices()
    {
        return getVertices().length;
    }


    public int getNumberOfEdges()
    {
        return getEdges().getSize();
    }


    public ANumber getLength()
    {
        return ANumber.of(getLengthAsInt());
    }


    public int getLengthAsInt()
    {
        return getEdges().getSize();
    }


    public Path getSubpath(Vertex fromVertex, Vertex toVertex)
    {
        return PathService.getSubpath(this, fromVertex, toVertex);
    }


    public boolean isVertexInPath(Vertex vertex)
    {
        return PathService.isVertexInPath(this, vertex);
    }


    public boolean isVertexNotInPath(Vertex vertex)
    {
        return PathService.isVertexNotInPath(this, vertex);
    }


    public int getIndexOfVertex(Vertex vertex)
    {
        return PathService.getIndexOfVertex(this, vertex);
    }


    public Path getUnion(Path other, Vertex connectingVertex)
    {
        return PathService.getUnion(this, other, connectingVertex);
    }


    public boolean isIndependentFrom(Path other)
    {
        return PathService.isIndependentFrom(this, other);
    }


    public boolean isTrivial()
    {
        return PathService.isTrivial(this);
    }


    public boolean isNotTrivial()
    {
        return PathService.isNotTrivial(this);
    }


    public boolean isHPath(Graph graph)
    {
        return PathService.isHPath(this, graph);
    }


    public boolean isCycle()
    {
        return PathService.isCycle(this);
    }


    public boolean isCircuit()
    {
        return PathService.isCircuit(this);
    }


    public boolean isClosedWalk()
    {
        return PathService.isClosedWalk(this);
    }


    public boolean isOddCycle()
    {
        return PathService.isOddCycle(this);
    }


    public boolean isEvenCycle()
    {
        return PathService.isEvenCycle(this);
    }


    public boolean isChordOfCycle(Edge edge)
    {
        return PathService.isChordOfCycle(this, edge);
    }


    public boolean isKCycle(ANumber k)
    {
        return PathService.isKCycle(this, k);
    }


    public Graph getGraph()
    {
        return Graph.of(getVerticesAsSetCopy(), getEdgesCopy());
    }


    public boolean isInducedCycleOfGraph(Graph graph)
    {
        return PathService.isInducedCycle(this, graph);
    }


    public boolean isEdgeInPath(Edge edge)
    {
        return PathService.isEdgeInPath(this, edge);
    }


    public boolean isNotEdgeInPath(Edge edge)
    {
        return PathService.isNotEdgeInPath(this, edge);
    }


    public boolean isSimple()
    {
        return PathService.isSimple(this);
    }


    public boolean isTrail()
    {
        return PathService.isTrail(this);
    }


    public GraphType getType()
    {
        return PathService.getType(this);
    }


    public OrionList<Edge> getEdgesCopy()
    {
        return getEdges().getCopy();
    }


    public OrionSet<Edge> getEdgesAsSet()
    {
        return edges.getAsOrionSet();
    }


    @Override
    public int hashCode()
    {
        return PathInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return PathInternalService.equals(this, object);
    }


    @Override
    public Path clone() throws CloneNotSupportedException
    {
        return (Path)CloningService.clone(this);
    }


    public Path getCopy()
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


    public OrionList<Edge> getEdges()
    {
        return this.edges;
    }


    public Vertex[] getVertices()
    {
        return this.vertices;
    }
}