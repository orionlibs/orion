package com.orion.user_management.authentication.csrf;

import com.orion.core.abstraction.OrionEnumeration;

public enum CSRFErrorType implements OrionEnumeration
{
    CSRF("CSRF");


    private String name;


    private CSRFErrorType(String name)
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
        return other instanceof CSRFErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof CSRFErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        CSRFErrorType[] values = values();

        for(CSRFErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static CSRFErrorType getEnumForValue(String other)
    {
        CSRFErrorType[] values = values();

        for(CSRFErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}