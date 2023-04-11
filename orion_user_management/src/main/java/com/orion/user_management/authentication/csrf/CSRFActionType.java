package com.orion.user_management.authentication.csrf;

import com.orion.core.abstraction.OrionEnumeration;

public enum CSRFActionType implements OrionEnumeration
{
    CSRF("csrf");


    private String name;


    private CSRFActionType(String name)
    {
        setName(name);
    }


    @Override
    public String get()
    {
        return getName();
    }


    public String getName()
    {
        return this.name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    @Override
    public boolean is(OrionEnumeration other)
    {
        return other instanceof CSRFActionType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof CSRFActionType && this != other;
    }


    public static boolean valueExists(String other)
    {
        CSRFActionType[] values = values();

        for(CSRFActionType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static CSRFActionType getEnumForValue(String other)
    {
        CSRFActionType[] values = values();

        for(CSRFActionType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}