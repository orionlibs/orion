package com.orion.user_management.contact_us;

import com.orion.core.abstraction.OrionEnumeration;

public enum ContactUsActionType implements OrionEnumeration
{
    ContactUs("contact.us");


    private String name;


    private ContactUsActionType(String name)
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
        return other instanceof ContactUsActionType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof ContactUsActionType && this != other;
    }


    public static boolean valueExists(String other)
    {
        ContactUsActionType[] values = values();

        for(ContactUsActionType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static ContactUsActionType getEnumForValue(String other)
    {
        ContactUsActionType[] values = values();

        for(ContactUsActionType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}