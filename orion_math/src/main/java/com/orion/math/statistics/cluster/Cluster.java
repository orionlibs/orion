package com.orion.math.statistics.cluster;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.math.MathObject;

public class Cluster implements MathObject, Cloneable
{
    private OrionSet<Object> points;
    private Object center;


    public Cluster(Object center)
    {
        ClusterRules.isValid(points, center);
        this.points = OrionHashSet.<Object>of();
    }


    public Cluster(OrionSet<Object> points, Object center)
    {
        ClusterRules.isValid(points, center);
        this.points = points;
    }


    public static Cluster of(Object center)
    {
        return new Cluster(center);
    }


    public static Cluster of(OrionSet<Object> points, Object center)
    {
        return new Cluster(points, center);
    }


    public void add(Object point)
    {
        points.add(point);
    }


    @Override
    public Cluster clone() throws CloneNotSupportedException
    {
        return (Cluster)CloningService.clone(this);
    }


    public Cluster getCopy()
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


    public OrionSet<Object> getPoints()
    {
        return this.points;
    }


    public Object getCenter()
    {
        return this.center;
    }
}