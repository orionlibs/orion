package com.orion.user_management.account;

import com.orion.core.abstraction.OrionEnumeration;

public enum UserAccountErrorType implements OrionEnumeration
{
    UserAccount("user.account");


    private String name;


    private UserAccountErrorType(String name)
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
        return other instanceof UserAccountErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof UserAccountErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        UserAccountErrorType[] values = values();

        for(UserAccountErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static UserAccountErrorType getEnumForValue(String other)
    {
        UserAccountErrorType[] values = values();

        for(UserAccountErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}