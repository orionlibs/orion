package com.orion.web.core.cookie;

import com.orion.core.abstraction.OrionEnumeration;

public enum CookieName implements OrionEnumeration
{
    JWTAccessToken("orion_access_token"),
    JWTAccessTokenDev("orion_access_token_dev");


    private String name;


    private CookieName(String name)
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
        return other instanceof CookieName && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof CookieName && this != other;
    }


    public static boolean valueExists(String other)
    {
        CookieName[] values = values();

        for(CookieName value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static CookieName getEnumForValue(String other)
    {
        CookieName[] values = values();

        for(CookieName value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}