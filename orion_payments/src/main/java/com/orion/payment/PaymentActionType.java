package com.orion.payment;

import com.orion.core.abstraction.OrionEnumeration;

public enum PaymentActionType implements OrionEnumeration
{
    Payment("payment"),
    PaymentStripe("payment.stripe");


    private String name;


    private PaymentActionType(String name)
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
        return other instanceof PaymentActionType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof PaymentActionType && this != other;
    }


    public static boolean valueExists(String other)
    {
        PaymentActionType[] values = values();

        for(PaymentActionType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static PaymentActionType getEnumForValue(String other)
    {
        PaymentActionType[] values = values();

        for(PaymentActionType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}