package com.orion.math.graph.edge;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.number.ANumber;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Edge implements MathObject, Cloneable
{
    private Pair<Vertex, Vertex> pair;
    private ANumber weight;


    public abstract void setVertices(Pair<Vertex, Vertex> pair);


    public abstract void setVertices(Vertex vertex1, Vertex vertex2);


    public void reverseDirection()
    {
        setVertices(getSecond(), getFirst());
    }


    public Edge reverseDirectionGET()
    {
        Edge copy = getCopy();
        copy.setVertices(getSecond(), getFirst());
        return copy;
    }


    public boolean isIncidentAt(Vertex vertex)
    {
        return EdgeService.isIncidentAt(this, vertex);
    }


    public boolean isVertexFirst(Vertex vertex)
    {
        return pair.getFirst().equals(vertex);
    }


    public boolean isVertexSecond(Vertex vertex)
    {
        return pair.getSecond().equals(vertex);
    }


    public boolean isIncidentAt(Vertex v1, Vertex v2)
    {
        return EdgeService.isIncidentAt(this, v1, v2);
    }


    public boolean isAdjacentTo(Edge other)
    {
        return EdgeService.isAdjacentTo(this, other);
    }


    public boolean isAdjacentTo(Edge... others)
    {
        return EdgeService.isAdjacentTo(this, others);
    }


    public boolean isAdjacentTo(OrionSet<Edge> others)
    {
        return EdgeService.isAdjacentTo(this, others);
    }


    public boolean isNotAdjacentTo(Edge other)
    {
        return EdgeService.isNotAdjacentTo(this, other);
    }


    public boolean isNotAdjacentTo(Edge... others)
    {
        return EdgeService.isNotAdjacentTo(this, others);
    }


    public boolean isNotAdjacentTo(OrionSet<Edge> others)
    {
        return EdgeService.isNotAdjacentTo(this, others);
    }


    public boolean isIndependentFrom(Edge other)
    {
        return EdgeService.isIndependentFrom(this, other);
    }


    public boolean isIndependentFrom(Edge... others)
    {
        return EdgeService.isIndependentFrom(this, others);
    }


    public boolean isIndependentFrom(OrionSet<Edge> others)
    {
        return EdgeService.isIndependentFrom(this, others);
    }


    public boolean isNotIndependentFrom(Edge other)
    {
        return EdgeService.isNotIndependentFrom(this, other);
    }


    public boolean isParallelTo(Edge other)
    {
        return EdgeService.isParallelTo(this, other);
    }


    public boolean isNotParallelTo(Edge other)
    {
        return EdgeService.isNotParallelTo(this, other);
    }


    public boolean isParallelTo(Edge... others)
    {
        return EdgeService.isParallelTo(this, others);
    }


    public boolean isLoop()
    {
        return EdgeService.isLoop(this);
    }


    public Vertex getFirst()
    {
        return getPair().getFirst();
    }


    public Vertex getSecond()
    {
        return getPair().getSecond();
    }


    public Vertex[] getAsArray()
    {
        Vertex[] vertices = new Vertex[2];
        vertices[0] = getFirst();
        vertices[1] = getSecond();
        return vertices;
    }


    public Vertex[] getAsArrayCopy()
    {
        Vertex[] vertices = new Vertex[2];
        vertices[0] = getFirst().getCopy();
        vertices[1] = getSecond().getCopy();
        return vertices;
    }


    public List<Vertex> getAsList()
    {
        return Arrays.asList(getFirst(), getSecond());
    }


    public List<Vertex> getAsListCopy()
    {
        return Arrays.asList(getFirst().getCopy(), getSecond().getCopy());
    }


    public Set<Vertex> getAsSet()
    {
        Set<Vertex> set = new HashSet<Vertex>();
        set.add(getFirst());
        set.add(getSecond());
        return set;
    }


    public Set<Vertex> getAsSetCopy()
    {
        Set<Vertex> set = new HashSet<Vertex>();
        set.add(getFirst().getCopy());
        set.add(getSecond().getCopy());
        return set;
    }


    public OrionSet<Vertex> getAsOrionSet()
    {
        return OrionHashSet.<Vertex>of(getAsSet());
    }


    public OrionSet<Vertex> getAsOrionSetCopy()
    {
        return OrionHashSet.<Vertex>of(getAsSetCopy());
    }


    @Override
    public int hashCode()
    {
        return EdgeInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return EdgeInternalService.equals(this, object);
    }


    public boolean notEquals(Object object)
    {
        return !equals(object);
    }


    @Override
    public Edge clone() throws CloneNotSupportedException
    {
        return (Edge)CloningService.clone(this);
    }


    public Edge getCopy()
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


    public Pair<Vertex, Vertex> getPair()
    {
        return this.pair;
    }


    protected void setPair(Pair<Vertex, Vertex> pair)
    {
        this.pair = pair;
    }


    public ANumber getWeight()
    {
        return this.weight;
    }


    protected void setWeight(ANumber weight)
    {
        this.weight = weight;
    }
}