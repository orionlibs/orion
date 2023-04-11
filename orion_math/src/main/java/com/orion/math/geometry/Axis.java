package com.orion.math.geometry;

import com.orion.core.abstraction.OrionEnumeration;

public enum Axis implements OrionEnumeration
{
    X(1),
    Y(2),
    Z(3);


    private int axisNumber;


    private Axis(int axisNumber)
    {
        this.axisNumber = axisNumber;
    }


    public static Axis of(int value)
    {

        if(value == 1)
        {
            return Axis.X;
        }
        else if(value == 2)
        {
            return Axis.Y;
        }
        else if(value == 3)
        {
            return Axis.Z;
        }

        return null;
    }


    @Override
    public String get()
    {
        return Integer.toString(axisNumber);
    }


    public int getInt()
    {
        return this.axisNumber;
    }


    @Override
    public boolean is(OrionEnumeration other)
    {
        return other instanceof Axis && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof Axis && this != other;
    }


    public static boolean valueExists(String other)
    {
        Axis[] values = values();

        for(Axis value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static Axis getEnumForValue(String other)
    {
        Axis[] values = values();

        for(Axis value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}