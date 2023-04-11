package com.orion.user_management.authentication.logout;

import com.orion.core.abstraction.OrionEnumeration;

public enum LogoutErrorType implements OrionEnumeration
{
    APILogout("logout.api");


    private String name;


    private LogoutErrorType(String name)
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
        return other instanceof LogoutErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof LogoutErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        LogoutErrorType[] values = values();

        for(LogoutErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static LogoutErrorType getEnumForValue(String other)
    {
        LogoutErrorType[] values = values();

        for(LogoutErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}