package com.orion.payment;

import com.orion.core.abstraction.OrionEnumeration;

public enum PaymentMethod implements OrionEnumeration
{
    Card("Card"),
    PayPal("PayPal"),
    BACSDirectDebit("bacs_debit");


    private String name;


    private PaymentMethod(String name)
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
        return other instanceof PaymentMethod && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof PaymentMethod && this != other;
    }


    public static boolean valueExists(String other)
    {
        PaymentMethod[] values = values();

        for(PaymentMethod value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static PaymentMethod getEnumForValue(String other)
    {
        PaymentMethod[] values = values();

        for(PaymentMethod value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}