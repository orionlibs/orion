package com.orion.math.graph.vertex.number;

import com.orion.core.object.CloningService;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;
import com.orion.math.number.ANumber;

public class NumberVertex extends Vertex
{
    private ANumber point;


    public NumberVertex()
    {
        setEmpty(true);
    }


    public NumberVertex(ANumber point)
    {
        NumberVertexRules.isValid(point);
        this.point = point;
        setVertexPoint(point);
    }


    public NumberVertex(Number point)
    {
        ANumber temp = ANumber.of(point);
        NumberVertexRules.isValid(temp);
        this.point = temp;
        setVertexPoint(temp);
    }


    public static NumberVertex of()
    {
        return new NumberVertex();
    }


    public static NumberVertex of(ANumber point)
    {
        return new NumberVertex(point);
    }


    public static NumberVertex of(Number point)
    {
        return new NumberVertex(point);
    }


    @Override
    public void setNewPoint(Vertex vertex)
    {
        VertexRules.haveSameType(this, vertex);
        this.point = ((NumberVertex)vertex).getPoint();
        setVertexPoint(vertex.getVertexPoint());
    }


    @Override
    public int hashCode()
    {
        return NumberVertexInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return NumberVertexInternalService.equals(this, object);
    }


    public boolean notEquals(Object object)
    {
        return !equals(object);
    }


    @Override
    public NumberVertex clone() throws CloneNotSupportedException
    {
        return (NumberVertex)CloningService.clone(this);
    }


    public NumberVertex getCopy()
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


    public ANumber getPoint()
    {
        return this.point;
    }
}