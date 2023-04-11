package com.orion.marketing.newsletter;

import com.orion.core.abstraction.OrionEnumeration;

public enum NewsletterErrorType implements OrionEnumeration
{
    NewsletterSubscription("newsletter.subscription"),
    NewsletterUnsubscription("newsletter.unsubscription");


    private String name;


    private NewsletterErrorType(String name)
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
        return other instanceof NewsletterErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof NewsletterErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        NewsletterErrorType[] values = values();

        for(NewsletterErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static NewsletterErrorType getEnumForValue(String other)
    {
        NewsletterErrorType[] values = values();

        for(NewsletterErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}