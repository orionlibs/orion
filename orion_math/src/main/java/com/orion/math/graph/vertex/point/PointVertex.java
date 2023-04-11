package com.orion.math.graph.vertex.point;

import com.orion.core.object.CloningService;
import com.orion.math.geometry.point.Point;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;

public class PointVertex extends Vertex
{
    private Point point;


    public PointVertex()
    {
        setEmpty(true);
    }


    public PointVertex(Point point)
    {
        PointVertexRules.isValid(point);
        this.point = point;
        setVertexPoint(point);
    }


    public static PointVertex of()
    {
        return new PointVertex();
    }


    public static PointVertex of(Point point)
    {
        return new PointVertex(point);
    }


    @Override
    public void setNewPoint(Vertex vertex)
    {
        VertexRules.haveSameType(this, vertex);
        this.point = ((PointVertex)vertex).getPoint();
        setVertexPoint(vertex.getVertexPoint());
    }


    @Override
    public int hashCode()
    {
        return PointVertexInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return PointVertexInternalService.equals(this, object);
    }


    public boolean notEquals(Object object)
    {
        return !equals(object);
    }


    @Override
    public PointVertex clone() throws CloneNotSupportedException
    {
        return (PointVertex)CloningService.clone(this);
    }


    public PointVertex getCopy()
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


    public Point getPoint()
    {
        return this.point;
    }
}