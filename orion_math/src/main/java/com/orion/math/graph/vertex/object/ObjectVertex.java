package com.orion.math.graph.vertex.object;

import com.orion.core.object.CloningService;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;

public class ObjectVertex extends Vertex
{
    private Object object;


    public ObjectVertex()
    {
        setEmpty(true);
    }


    public ObjectVertex(Object object)
    {
        ObjectVertexRules.isValid(object);
        this.object = object;
        setVertexPoint(object);
    }


    public static ObjectVertex of()
    {
        return new ObjectVertex();
    }


    public static ObjectVertex of(Object object)
    {
        return new ObjectVertex(object);
    }


    @Override
    public void setNewPoint(Vertex vertex)
    {
        VertexRules.haveSameType(this, vertex);
        this.object = ((ObjectVertex)vertex).getObject();
        setVertexPoint(vertex.getVertexPoint());
    }


    @Override
    public int hashCode()
    {
        return ObjectVertexInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return ObjectVertexInternalService.equals(this, object);
    }


    public boolean notEquals(Object object)
    {
        return !equals(object);
    }


    @Override
    public ObjectVertex clone() throws CloneNotSupportedException
    {
        return (ObjectVertex)CloningService.clone(this);
    }


    public ObjectVertex getCopy()
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


    public Object getObject()
    {
        return this.object;
    }
}