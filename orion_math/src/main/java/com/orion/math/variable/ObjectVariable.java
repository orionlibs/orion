package com.orion.math.variable;

public class ObjectVariable<T> extends Variable<T>
{
    public ObjectVariable()
    {
        super();
    }


    public ObjectVariable(T value)
    {
        super(value);
    }


    public static <T> ObjectVariable<T> of()
    {
        return new ObjectVariable<T>();
    }


    public static <T> ObjectVariable<T> of(T value)
    {
        return new ObjectVariable<T>(value);
    }
}