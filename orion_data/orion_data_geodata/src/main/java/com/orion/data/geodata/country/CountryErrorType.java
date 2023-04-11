package com.orion.data.geodata.country;

import com.orion.core.abstraction.OrionEnumeration;

public enum CountryErrorType implements OrionEnumeration
{
    AvailableCountries("country.available.countries");


    private String name;


    private CountryErrorType(String name)
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
        return other instanceof CountryErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof CountryErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        CountryErrorType[] values = values();

        for(CountryErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static CountryErrorType getEnumForValue(String other)
    {
        CountryErrorType[] values = values();

        for(CountryErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}