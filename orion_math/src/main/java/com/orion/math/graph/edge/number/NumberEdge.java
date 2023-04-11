package com.orion.math.graph.edge.number;

import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.number.ANumber;
import java.util.Arrays;
import java.util.List;

public class NumberEdge extends Edge
{
    private Pair<NumberVertex, NumberVertex> pairOfVertices;


    public NumberEdge(Pair<NumberVertex, NumberVertex> pairOfVertices)
    {
        NumberEdgeRules.isValid(pairOfVertices);
        this.pairOfVertices = pairOfVertices;
        setPair(Pair.of(pairOfVertices.getFirst(), pairOfVertices.getSecond()));
    }


    public NumberEdge(Pair<NumberVertex, NumberVertex> pairOfVertices, ANumber weight)
    {
        NumberEdgeRules.isValid(pairOfVertices, weight);
        this.pairOfVertices = pairOfVertices;
        setPair(Pair.of(pairOfVertices.getFirst(), pairOfVertices.getSecond()));
        setWeight(weight);
    }


    public NumberEdge(NumberVertex vertex1, NumberVertex vertex2)
    {
        NumberEdgeRules.isValid(vertex1, vertex2);
        this.pairOfVertices = Pair.of(vertex1, vertex2);
        setPair(Pair.of((Vertex)vertex1, (Vertex)vertex2));
    }


    public NumberEdge(NumberVertex vertex1, NumberVertex vertex2, ANumber weight)
    {
        NumberEdgeRules.isValid(vertex1, vertex2, weight);
        this.pairOfVertices = Pair.of(vertex1, vertex2);
        setPair(Pair.of((Vertex)vertex1, (Vertex)vertex2));
        setWeight(weight);
    }


    public static NumberEdge of(Pair<NumberVertex, NumberVertex> pairOfVertices)
    {
        return new NumberEdge(pairOfVertices);
    }


    public static NumberEdge of(Pair<NumberVertex, NumberVertex> pairOfVertices, ANumber weight)
    {
        return new NumberEdge(pairOfVertices, weight);
    }


    public static NumberEdge of(NumberVertex vertex1, NumberVertex vertex2)
    {
        return new NumberEdge(vertex1, vertex2);
    }


    public static NumberEdge of(NumberVertex vertex1, NumberVertex vertex2, ANumber weight)
    {
        return new NumberEdge(vertex1, vertex2, weight);
    }


    @Override
    public void setVertices(Pair<Vertex, Vertex> pairOfVertices)
    {
        NumberEdgeRules.isValidGenericEdge(pairOfVertices);
        NumberVertex vertex1 = (NumberVertex)pairOfVertices.getFirst();
        NumberVertex vertex2 = (NumberVertex)pairOfVertices.getSecond();
        this.pairOfVertices = Pair.of(vertex1, vertex2);
        setPair(Pair.of(pairOfVertices.getFirst(), pairOfVertices.getSecond()));
    }


    @Override
    public void setVertices(Vertex vertex1, Vertex vertex2)
    {
        NumberEdgeRules.isValidGenericEdge(vertex1, vertex2);
        this.pairOfVertices = Pair.of((NumberVertex)vertex1, (NumberVertex)vertex2);
        setPair(Pair.of(vertex1, vertex2));
    }


    public NumberVertex getFirst()
    {
        return getPairOfVertices().getFirst();
    }


    public NumberVertex getSecond()
    {
        return getPairOfVertices().getSecond();
    }


    public NumberVertex[] getAsArray()
    {
        NumberVertex[] vertices = new NumberVertex[2];
        vertices[0] = getFirst();
        vertices[1] = getSecond();
        return vertices;
    }


    public NumberVertex[] getAsArrayCopy()
    {
        NumberVertex[] vertices = new NumberVertex[2];
        vertices[0] = getFirst().getCopy();
        vertices[1] = getSecond().getCopy();
        return vertices;
    }


    public List<NumberVertex> getAsNumberVertexList()
    {
        return Arrays.asList(getFirst(), getSecond());
    }


    public List<NumberVertex> getAsNumberVertexListCopy()
    {
        return Arrays.asList(getFirst().getCopy(), getSecond().getCopy());
    }


    @Override
    public int hashCode()
    {
        return NumberEdgeInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return NumberEdgeInternalService.equals(this, object);
    }


    @Override
    public NumberEdge clone() throws CloneNotSupportedException
    {
        return (NumberEdge)CloningService.clone(this);
    }


    public NumberEdge getCopy()
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


    public Pair<NumberVertex, NumberVertex> getPairOfVertices()
    {
        return this.pairOfVertices;
    }
}