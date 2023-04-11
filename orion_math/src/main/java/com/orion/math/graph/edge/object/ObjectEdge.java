package com.orion.math.graph.edge.object;

import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.object.ObjectVertex;
import com.orion.math.number.ANumber;
import java.util.Arrays;
import java.util.List;

public class ObjectEdge extends Edge
{
    private Pair<ObjectVertex, ObjectVertex> pairOfVertices;


    public ObjectEdge(Pair<ObjectVertex, ObjectVertex> pairOfVertices)
    {
        ObjectEdgeRules.isValid(pairOfVertices);
        this.pairOfVertices = Pair.of(pairOfVertices.getFirst(), pairOfVertices.getSecond());
        setPair(Pair.of(pairOfVertices.getFirst(), pairOfVertices.getSecond()));
    }


    public ObjectEdge(Pair<ObjectVertex, ObjectVertex> pairOfVertices, ANumber weight)
    {
        ObjectEdgeRules.isValid(pairOfVertices, weight);
        this.pairOfVertices = Pair.of(pairOfVertices.getFirst(), pairOfVertices.getSecond());
        setPair(Pair.of(pairOfVertices.getFirst(), pairOfVertices.getSecond()));
        setWeight(weight);
    }


    public ObjectEdge(ObjectVertex vertex1, ObjectVertex vertex2)
    {
        ObjectEdgeRules.isValid(vertex1, vertex2);
        this.pairOfVertices = Pair.of(vertex1, vertex2);
        setPair(Pair.of((Vertex)vertex1, (Vertex)vertex2));
    }


    public ObjectEdge(ObjectVertex vertex1, ObjectVertex vertex2, ANumber weight)
    {
        ObjectEdgeRules.isValid(vertex1, vertex2, weight);
        this.pairOfVertices = Pair.of(vertex1, vertex2);
        setPair(Pair.of((Vertex)vertex1, (Vertex)vertex2));
        setWeight(weight);
    }


    public static ObjectEdge of(Pair<ObjectVertex, ObjectVertex> pairOfVertices)
    {
        return new ObjectEdge(pairOfVertices);
    }


    public static ObjectEdge of(Pair<ObjectVertex, ObjectVertex> pairOfVertices, ANumber weight)
    {
        return new ObjectEdge(pairOfVertices, weight);
    }


    public static ObjectEdge of(ObjectVertex vertex1, ObjectVertex vertex2)
    {
        return new ObjectEdge(vertex1, vertex2);
    }


    public static ObjectEdge of(ObjectVertex vertex1, ObjectVertex vertex2, ANumber weight)
    {
        return new ObjectEdge(vertex1, vertex2, weight);
    }


    @Override
    public void setVertices(Pair<Vertex, Vertex> pairOfVertices)
    {
        ObjectEdgeRules.isValidGenericEdge(pairOfVertices);
        ObjectVertex vertex1 = (ObjectVertex)pairOfVertices.getFirst();
        ObjectVertex vertex2 = (ObjectVertex)pairOfVertices.getSecond();
        this.pairOfVertices = Pair.of(vertex1, vertex2);
        setPair(Pair.of(pairOfVertices.getFirst(), pairOfVertices.getSecond()));
    }


    @Override
    public void setVertices(Vertex vertex1, Vertex vertex2)
    {
        ObjectEdgeRules.isValidGenericEdge(vertex1, vertex2);
        this.pairOfVertices = Pair.of((ObjectVertex)vertex1, (ObjectVertex)vertex2);
        setPair(Pair.of(vertex1, vertex2));
    }


    public ObjectVertex getFirst()
    {
        return getPairOfVertices().getFirst();
    }


    public ObjectVertex getSecond()
    {
        return getPairOfVertices().getSecond();
    }


    public ObjectVertex[] getAsArray()
    {
        ObjectVertex[] vertices = new ObjectVertex[2];
        vertices[0] = getFirst();
        vertices[1] = getSecond();
        return vertices;
    }


    public ObjectVertex[] getAsArrayCopy()
    {
        ObjectVertex[] vertices = new ObjectVertex[2];
        vertices[0] = getFirst().getCopy();
        vertices[1] = getSecond().getCopy();
        return vertices;
    }


    public List<ObjectVertex> getAsObjectVertexList()
    {
        return Arrays.asList(getFirst(), getSecond());
    }


    public List<ObjectVertex> getAsObjectVertexListCopy()
    {
        return Arrays.asList(getFirst().getCopy(), getSecond().getCopy());
    }


    @Override
    public int hashCode()
    {
        return ObjectEdgeInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return ObjectEdgeInternalService.equals(this, object);
    }


    @Override
    public ObjectEdge clone() throws CloneNotSupportedException
    {
        return (ObjectEdge)CloningService.clone(this);
    }


    public ObjectEdge getCopy()
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


    public Pair<ObjectVertex, ObjectVertex> getPairOfVertices()
    {
        return this.pairOfVertices;
    }
}