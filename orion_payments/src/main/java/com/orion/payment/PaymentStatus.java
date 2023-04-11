package com.orion.payment;

import com.orion.core.abstraction.OrionEnumeration;

public enum PaymentStatus implements OrionEnumeration
{
    Succeeded("succeeded"),
    RequiresCapture("requires_capture"),
    RequiresPaymentMethod("requires_payment_method"),
    Canceled("canceled");


    private String name;


    private PaymentStatus(String name)
    {
        setName(name);
    }


    @Override
    public String get()
    {
        return getName();
    }


    public int getAsInt()
    {
        return Integer.parseInt(getName());
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
        return other instanceof PaymentStatus && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof PaymentStatus && this != other;
    }


    public static boolean valueExists(String other)
    {
        PaymentStatus[] values = values();

        for(PaymentStatus value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static PaymentStatus getEnumForValue(String other)
    {
        PaymentStatus[] values = values();

        for(PaymentStatus value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}