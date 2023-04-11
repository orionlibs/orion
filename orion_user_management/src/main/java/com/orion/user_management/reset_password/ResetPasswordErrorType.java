package com.orion.user_management.reset_password;

import com.orion.core.abstraction.OrionEnumeration;

public enum ResetPasswordErrorType implements OrionEnumeration
{
    InvalidCode("reset.password.invalid.code"),
    Code("reset.password.code"),
    ResetPassword("reset.password");


    private String name;


    private ResetPasswordErrorType(String name)
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
        return other instanceof ResetPasswordErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof ResetPasswordErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        ResetPasswordErrorType[] values = values();

        for(ResetPasswordErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static ResetPasswordErrorType getEnumForValue(String other)
    {
        ResetPasswordErrorType[] values = values();

        for(ResetPasswordErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}