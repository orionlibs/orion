package com.orion.math.geometry.shape.triangle;

import com.orion.core.abstraction.OrionEnumeration;

public enum TriangleSideType implements OrionEnumeration
{
    Equilateral,
    Isosceles,
    Scalene;


    @Override
    public String get()
    {
        return null;
    }


    @Override
    public boolean is(OrionEnumeration other)
    {
        return other instanceof TriangleSideType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof TriangleSideType && this != other;
    }


    public static boolean valueExists(String other)
    {
        TriangleSideType[] values = values();

        for(TriangleSideType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static TriangleSideType getEnumForValue(String other)
    {
        TriangleSideType[] values = values();

        for(TriangleSideType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}