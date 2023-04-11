package com.orion.math.graph.vertex;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.graph.edge.Edge;

public abstract class Vertex implements MathObject, Cloneable
{
    private Object vertexPoint;
    private boolean isEmpty;


    public boolean isIncident(Edge edge)
    {
        return VertexService.isIncident(this, edge);
    }


    public abstract void setNewPoint(Vertex vertex);


    public boolean notEquals(Vertex other)
    {
        return !equals(other);
    }


    @Override
    public Vertex clone() throws CloneNotSupportedException
    {
        return (Vertex)CloningService.clone(this);
    }


    public Vertex getCopy()
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


    public Object getVertexPoint()
    {
        return this.vertexPoint;
    }


    protected void setVertexPoint(Object vertexPoint)
    {
        this.vertexPoint = vertexPoint;
    }


    public boolean isEmpty()
    {
        return this.isEmpty;
    }


    public boolean isNotEmpty()
    {
        return !isEmpty();
    }


    protected void setEmpty(boolean isEmpty)
    {
        this.isEmpty = isEmpty;
    }
}