package com.orion.math.geometry;

import com.orion.core.abstraction.OrionEnumeration;

public enum Orientation implements OrionEnumeration
{
    Collinear,
    Clockwise,
    Counterclockwise;


    @Override
    public String get()
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean is(OrionEnumeration other)
    {
        return other instanceof Orientation && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof Orientation && this != other;
    }


    public static boolean valueExists(String other)
    {
        Orientation[] values = values();

        for(Orientation value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static Orientation getEnumForValue(String other)
    {
        Orientation[] values = values();

        for(Orientation value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}