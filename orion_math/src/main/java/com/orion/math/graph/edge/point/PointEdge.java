package com.orion.math.graph.edge.point;

import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.point.PointVertex;
import com.orion.math.number.ANumber;
import java.util.Arrays;
import java.util.List;

public class PointEdge extends Edge
{
    private Pair<PointVertex, PointVertex> pairOfVertices;


    public PointEdge(Pair<PointVertex, PointVertex> pairOfVertices)
    {
        PointEdgeRules.isValid(pairOfVertices);
        this.pairOfVertices = pairOfVertices;
        setPair(Pair.of((Vertex)pairOfVertices.getFirst(), (Vertex)pairOfVertices.getSecond()));
    }


    public PointEdge(Pair<PointVertex, PointVertex> pairOfVertices, ANumber weight)
    {
        PointEdgeRules.isValid(pairOfVertices, weight);
        this.pairOfVertices = pairOfVertices;
        setPair(Pair.of((Vertex)pairOfVertices.getFirst(), (Vertex)pairOfVertices.getSecond()));
        setWeight(weight);
    }


    public PointEdge(PointVertex vertex1, PointVertex vertex2)
    {
        PointEdgeRules.isValid(vertex1, vertex2);
        this.pairOfVertices = Pair.of(vertex1, vertex2);
        setPair(Pair.of((Vertex)vertex1, (Vertex)vertex2));
    }


    public PointEdge(PointVertex vertex1, PointVertex vertex2, ANumber weight)
    {
        PointEdgeRules.isValid(vertex1, vertex2, weight);
        this.pairOfVertices = Pair.of(vertex1, vertex2);
        setPair(Pair.of((Vertex)vertex1, (Vertex)vertex2));
        setWeight(weight);
    }


    public static PointEdge of(Pair<PointVertex, PointVertex> pairOfVertices)
    {
        return new PointEdge(pairOfVertices);
    }


    public static PointEdge of(Pair<PointVertex, PointVertex> pairOfVertices, ANumber weight)
    {
        return new PointEdge(pairOfVertices, weight);
    }


    public static PointEdge of(PointVertex vertex1, PointVertex vertex2)
    {
        return new PointEdge(vertex1, vertex2);
    }


    public static PointEdge of(PointVertex vertex1, PointVertex vertex2, ANumber weight)
    {
        return new PointEdge(vertex1, vertex2, weight);
    }


    @Override
    public void setVertices(Pair<Vertex, Vertex> pairOfVertices)
    {
        PointEdgeRules.isValidGenericEdge(pairOfVertices);
        this.pairOfVertices = Pair.of((PointVertex)pairOfVertices.getFirst(), (PointVertex)pairOfVertices.getSecond());
        setPair(Pair.of(pairOfVertices.getFirst(), pairOfVertices.getSecond()));
    }


    @Override
    public void setVertices(Vertex vertex1, Vertex vertex2)
    {
        PointEdgeRules.isValidGenericEdge(vertex1, vertex2);
        this.pairOfVertices = Pair.of((PointVertex)vertex1, (PointVertex)vertex2);
        setPair(Pair.of(vertex1, vertex2));
    }


    public PointVertex getFirst()
    {
        return getPairOfVertices().getFirst();
    }


    public PointVertex getSecond()
    {
        return getPairOfVertices().getSecond();
    }


    public PointVertex[] getAsArray()
    {
        PointVertex[] vertices = new PointVertex[2];
        vertices[0] = getFirst();
        vertices[1] = getSecond();
        return vertices;
    }


    public PointVertex[] getAsArrayCopy()
    {
        PointVertex[] vertices = new PointVertex[2];
        vertices[0] = getFirst().getCopy();
        vertices[1] = getSecond().getCopy();
        return vertices;
    }


    public List<PointVertex> getAsPointVertexList()
    {
        return Arrays.asList(getFirst(), getSecond());
    }


    public List<PointVertex> getAsPointVertexListCopy()
    {
        return Arrays.asList(getFirst().getCopy(), getSecond().getCopy());
    }


    @Override
    public int hashCode()
    {
        return PointEdgeInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return PointEdgeInternalService.equals(this, object);
    }


    @Override
    public PointEdge clone() throws CloneNotSupportedException
    {
        return (PointEdge)CloningService.clone(this);
    }


    public PointEdge getCopy()
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


    public Pair<PointVertex, PointVertex> getPairOfVertices()
    {
        return this.pairOfVertices;
    }
}