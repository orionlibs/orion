package com.orion.user_management.authentication.logout.model;

import com.orion.core.abstraction.OrionEnumeration;

public enum LogoutCause implements OrionEnumeration
{
    User("user"),
    System("system");


    private String name;


    private LogoutCause(String name)
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
        return other instanceof LogoutCause && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof LogoutCause && this != other;
    }


    public static boolean valueExists(String other)
    {
        LogoutCause[] values = values();

        for(LogoutCause value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static LogoutCause getEnumForValue(String other)
    {
        LogoutCause[] values = values();

        for(LogoutCause value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}