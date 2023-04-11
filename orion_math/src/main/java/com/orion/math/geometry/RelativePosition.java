package com.orion.math.geometry;

import com.orion.core.abstraction.OrionEnumeration;

public enum RelativePosition implements OrionEnumeration
{
    Left,
    Right,
    On;


    @Override
    public String get()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean is(OrionEnumeration other)
    {
        return other instanceof RelativePosition && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof RelativePosition && this != other;
    }


    public static boolean valueExists(String other)
    {
        RelativePosition[] values = values();

        for(RelativePosition value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static RelativePosition getEnumForValue(String other)
    {
        RelativePosition[] values = values();

        for(RelativePosition value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}