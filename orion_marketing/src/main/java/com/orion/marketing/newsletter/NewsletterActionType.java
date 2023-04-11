package com.orion.marketing.newsletter;

import com.orion.core.abstraction.OrionEnumeration;

public enum NewsletterActionType implements OrionEnumeration
{
    Newsletter("marketing.newsletter");


    private String name;


    private NewsletterActionType(String name)
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
        return other instanceof NewsletterActionType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof NewsletterActionType && this != other;
    }


    public static boolean valueExists(String other)
    {
        NewsletterActionType[] values = values();

        for(NewsletterActionType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static NewsletterActionType getEnumForValue(String other)
    {
        NewsletterActionType[] values = values();

        for(NewsletterActionType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}