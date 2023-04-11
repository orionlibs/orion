package com.orion.user_management.security_question;

import com.orion.core.abstraction.OrionEnumeration;

public enum SecurityQuestionErrorType implements OrionEnumeration
{
    SecurityQuestion("security.question");


    private String name;


    private SecurityQuestionErrorType(String name)
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
        return other instanceof SecurityQuestionErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof SecurityQuestionErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        SecurityQuestionErrorType[] values = values();

        for(SecurityQuestionErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static SecurityQuestionErrorType getEnumForValue(String other)
    {
        SecurityQuestionErrorType[] values = values();

        for(SecurityQuestionErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}