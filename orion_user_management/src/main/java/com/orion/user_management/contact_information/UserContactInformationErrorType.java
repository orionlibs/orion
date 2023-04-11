package com.orion.user_management.contact_information;

import com.orion.core.abstraction.OrionEnumeration;

public enum UserContactInformationErrorType implements OrionEnumeration
{
    UserContactInformation("user.contact.information");


    private String name;


    private UserContactInformationErrorType(String name)
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
        return other instanceof UserContactInformationErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof UserContactInformationErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        UserContactInformationErrorType[] values = values();

        for(UserContactInformationErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static UserContactInformationErrorType getEnumForValue(String other)
    {
        UserContactInformationErrorType[] values = values();

        for(UserContactInformationErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}