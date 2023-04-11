package com.orion.math.graph;

import com.orion.core.abstraction.OrionEnumeration;

public enum GraphType implements OrionEnumeration
{
    Number,
    Point,
    Object,
    Either;


    @Override
    public String get()
    {
        return null;
    }


    @Override
    public boolean is(OrionEnumeration other)
    {
        return other instanceof GraphType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof GraphType && this != other;
    }


    public static boolean valueExists(String other)
    {
        GraphType[] values = values();

        for(GraphType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static GraphType getEnumForValue(String other)
    {
        GraphType[] values = values();

        for(GraphType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}