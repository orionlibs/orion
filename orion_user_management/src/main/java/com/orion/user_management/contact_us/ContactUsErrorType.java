package com.orion.user_management.contact_us;

import com.orion.core.abstraction.OrionEnumeration;

public enum ContactUsErrorType implements OrionEnumeration
{
    ReasonsOfContact("contact.us.reason.of.contact"),
    Form("contact.us.form");


    private String name;


    private ContactUsErrorType(String name)
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
        return other instanceof ContactUsErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof ContactUsErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        ContactUsErrorType[] values = values();

        for(ContactUsErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static ContactUsErrorType getEnumForValue(String other)
    {
        ContactUsErrorType[] values = values();

        for(ContactUsErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}