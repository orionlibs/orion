package com.orion.user_management.authorisation.jwt;

import com.orion.core.abstraction.OrionEnumeration;

public enum JWTErrorType implements OrionEnumeration
{
    JWT("JWT");


    private String name;


    private JWTErrorType(String name)
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
        return other instanceof JWTErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof JWTErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        JWTErrorType[] values = values();

        for(JWTErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static JWTErrorType getEnumForValue(String other)
    {
        JWTErrorType[] values = values();

        for(JWTErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}