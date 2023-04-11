package com.orion.math.probability.event.simple;

import com.orion.math.probability.event.Event;

public class SimpleEvent<T> extends Event<T>
{
    private T value;


    public SimpleEvent(T value)
    {
        SimpleEventRules.isValid(value);
        this.value = value;
    }


    public static <T> SimpleEvent<T> of(T value)
    {
        return new SimpleEvent<T>(value);
    }


    public T getValue()
    {
        return this.value;
    }
}