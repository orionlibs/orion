package com.orion.user_management.authentication.login;

import com.orion.core.abstraction.OrionEnumeration;

public enum LoginErrorType implements OrionEnumeration
{
    APILogin("login.api");


    private String name;


    private LoginErrorType(String name)
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
        return other instanceof LoginErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof LoginErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        LoginErrorType[] values = values();

        for(LoginErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static LoginErrorType getEnumForValue(String other)
    {
        LoginErrorType[] values = values();

        for(LoginErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}