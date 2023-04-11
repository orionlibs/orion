package com.orion.user_management.user;

import com.orion.core.abstraction.OrionEnumeration;

public enum UserErrorType implements OrionEnumeration
{
    APIUser("user.api");


    private String name;


    private UserErrorType(String name)
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
        return other instanceof UserErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof UserErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        UserErrorType[] values = values();

        for(UserErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static UserErrorType getEnumForValue(String other)
    {
        UserErrorType[] values = values();

        for(UserErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}