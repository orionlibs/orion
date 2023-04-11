package com.orion.user_management.authentication.login;

import com.orion.core.abstraction.OrionEnumeration;

public enum LoginActionType implements OrionEnumeration
{
    Login("login");


    private String name;


    private LoginActionType(String name)
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
        return other instanceof LoginActionType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof LoginActionType && this != other;
    }


    public static boolean valueExists(String other)
    {
        LoginActionType[] values = values();

        for(LoginActionType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static LoginActionType getEnumForValue(String other)
    {
        LoginActionType[] values = values();

        for(LoginActionType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}