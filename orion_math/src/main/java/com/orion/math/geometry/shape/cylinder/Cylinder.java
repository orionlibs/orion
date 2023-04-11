package com.orion.math.geometry.shape.cylinder;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.number.ANumber;

public class Cylinder implements MathObject, Cloneable
{
    private ANumber radius;
    private ANumber height;


    public Cylinder(ANumber radius, ANumber height)
    {
        CylinderRules.isValid(radius, height);
        this.radius = radius;
        this.height = height;
    }


    public static Cylinder of(ANumber radius, ANumber height)
    {
        return new Cylinder(radius, height);
    }


    public ANumber getSurfaceArea()
    {
        return CylinderService.getSurfaceArea(this);
    }


    public ANumber getVolume()
    {
        return CylinderService.getVolume(this);
    }


    @Override
    public Cylinder clone() throws CloneNotSupportedException
    {
        return (Cylinder)CloningService.clone(this);
    }


    public Cylinder getCopy()
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


    @Override
    public int hashCode()
    {
        return CylinderInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return CylinderInternalService.equals(this, object);
    }


    public ANumber getRadius()
    {
        return this.radius;
    }


    public ANumber getHeight()
    {
        return this.height;
    }
}