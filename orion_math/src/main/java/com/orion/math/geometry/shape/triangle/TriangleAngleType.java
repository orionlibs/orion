package com.orion.math.geometry.shape.triangle;

import com.orion.core.abstraction.OrionEnumeration;

public enum TriangleAngleType implements OrionEnumeration
{
    Acute,
    Right,
    Obtuse;


    @Override
    public String get()
    {
        return null;
    }


    @Override
    public boolean is(OrionEnumeration other)
    {
        return other instanceof TriangleAngleType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof TriangleAngleType && this != other;
    }


    public static boolean valueExists(String other)
    {
        TriangleAngleType[] values = values();

        for(TriangleAngleType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static TriangleAngleType getEnumForValue(String other)
    {
        TriangleAngleType[] values = values();

        for(TriangleAngleType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}