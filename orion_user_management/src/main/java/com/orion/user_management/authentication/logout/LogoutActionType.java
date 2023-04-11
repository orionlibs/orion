package com.orion.user_management.authentication.logout;

import com.orion.core.abstraction.OrionEnumeration;

public enum LogoutActionType implements OrionEnumeration
{
    Logout("logout");


    private String name;


    private LogoutActionType(String name)
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
        return other instanceof LogoutActionType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof LogoutActionType && this != other;
    }


    public static boolean valueExists(String other)
    {
        LogoutActionType[] values = values();

        for(LogoutActionType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static LogoutActionType getEnumForValue(String other)
    {
        LogoutActionType[] values = values();

        for(LogoutActionType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}