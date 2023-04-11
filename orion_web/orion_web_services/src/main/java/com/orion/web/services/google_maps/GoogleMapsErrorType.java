package com.orion.web.services.google_maps;

import com.orion.core.abstraction.OrionEnumeration;

public enum GoogleMapsErrorType implements OrionEnumeration
{
    GoogleMaps("google.maps");


    private String name;


    private GoogleMapsErrorType(String name)
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
        return other instanceof GoogleMapsErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof GoogleMapsErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        GoogleMapsErrorType[] values = values();

        for(GoogleMapsErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static GoogleMapsErrorType getEnumForValue(String other)
    {
        GoogleMapsErrorType[] values = values();

        for(GoogleMapsErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}