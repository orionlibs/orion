package com.orion.math.geometry.point.generic;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;

public class GenericPoint implements MathObject, Cloneable
{
    private Object[] coordinates;


    public GenericPoint(Object x, Object y)
    {
        GenericPointRules.isValid(x, y);
        this.coordinates = new Object[]
        {x, y};
    }


    public GenericPoint(Object x, Object y, Object z)
    {
        GenericPointRules.isValid(x, y, z);
        this.coordinates = new Object[]
        {x, y, z};
    }


    public GenericPoint(Object[] coordinates)
    {
        GenericPointRules.isValid(coordinates);
        this.coordinates = coordinates;
    }


    public static GenericPoint of(Object x, Object y)
    {
        return new GenericPoint(x, y);
    }


    public static GenericPoint of(Object x, Object y, Object z)
    {
        return new GenericPoint(x, y, z);
    }


    public static GenericPoint of(Object[] coordinates)
    {
        return new GenericPoint(coordinates);
    }


    public Object get(int index)
    {
        return getCoordinates()[index];
    }


    public void set(int index, Object element)
    {
        getCoordinates()[index] = element;
    }


    public int getDimensions()
    {
        return coordinates.length;
    }


    public Object getX()
    {
        return (getDimensions() == 0) ? null : coordinates[0];
    }


    public Object getY()
    {
        return (getDimensions() <= 1) ? null : coordinates[1];
    }


    public Object getZ()
    {
        return (getDimensions() <= 2) ? null : coordinates[2];
    }


    public Object[] getCoordinatesCopy()
    {
        Object[] newCoordinates = new Object[getDimensions()];
        System.arraycopy(getCoordinates(), 0, newCoordinates, 0, getDimensions());
        return newCoordinates;
    }


    @Override
    public int hashCode()
    {
        return GenericPointInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return GenericPointInternalService.equals(this, object);
    }


    @Override
    public GenericPoint clone() throws CloneNotSupportedException
    {
        return (GenericPoint)CloningService.clone(this);
    }


    public GenericPoint getCopy()
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


    public Object[] getCoordinates()
    {
        return this.coordinates;
    }
}