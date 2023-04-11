package com.orion.user_management.forgot_password;

import com.orion.core.abstraction.OrionEnumeration;

public enum ForgotPasswordErrorType implements OrionEnumeration
{
    Request("forgot.password.request");


    private String name;


    private ForgotPasswordErrorType(String name)
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
        return other instanceof ForgotPasswordErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof ForgotPasswordErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        ForgotPasswordErrorType[] values = values();

        for(ForgotPasswordErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static ForgotPasswordErrorType getEnumForValue(String other)
    {
        ForgotPasswordErrorType[] values = values();

        for(ForgotPasswordErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}