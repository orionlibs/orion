package com.orion.user_management.user;

import com.orion.core.abstraction.OrionEnumeration;

public enum UserActionType implements OrionEnumeration
{
    User("user");


    private String name;


    private UserActionType(String name)
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
        return other instanceof UserActionType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof UserActionType && this != other;
    }


    public static boolean valueExists(String other)
    {
        UserActionType[] values = values();

        for(UserActionType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static UserActionType getEnumForValue(String other)
    {
        UserActionType[] values = values();

        for(UserActionType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}