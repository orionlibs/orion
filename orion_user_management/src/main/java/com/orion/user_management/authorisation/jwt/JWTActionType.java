package com.orion.user_management.authorisation.jwt;

import com.orion.core.abstraction.OrionEnumeration;

public enum JWTActionType implements OrionEnumeration
{
    JWT("jwt");


    private String name;


    private JWTActionType(String name)
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
        return other instanceof JWTActionType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof JWTActionType && this != other;
    }


    public static boolean valueExists(String other)
    {
        JWTActionType[] values = values();

        for(JWTActionType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static JWTActionType getEnumForValue(String other)
    {
        JWTActionType[] values = values();

        for(JWTActionType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}