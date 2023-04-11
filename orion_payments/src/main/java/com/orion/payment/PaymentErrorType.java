package com.orion.payment;

import com.orion.core.abstraction.OrionEnumeration;

public enum PaymentErrorType implements OrionEnumeration
{
    Payment("payment"),
    Stripe("payment.stripe");


    private String name;


    private PaymentErrorType(String name)
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
        return other instanceof PaymentErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof PaymentErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        PaymentErrorType[] values = values();

        for(PaymentErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static PaymentErrorType getEnumForValue(String other)
    {
        PaymentErrorType[] values = values();

        for(PaymentErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}