package com.orion.user_management.email_validation;

import com.orion.core.abstraction.OrionEnumeration;

public enum EmailValidationErrorType implements OrionEnumeration
{
    AccountReactivationValidation("account.reactivation.validation"),
    EmailValidation("email.validation");


    private String name;


    private EmailValidationErrorType(String name)
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
        return other instanceof EmailValidationErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof EmailValidationErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        EmailValidationErrorType[] values = values();

        for(EmailValidationErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static EmailValidationErrorType getEnumForValue(String other)
    {
        EmailValidationErrorType[] values = values();

        for(EmailValidationErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}