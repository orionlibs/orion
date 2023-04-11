package com.orion.core.computation.parallelism;

public class Reference<T>
{
    private T variable;


    public T get()
    {
        return variable;
    }


    public T set(T newValue)
    {
        T oldValue = variable;
        variable = newValue;
        return oldValue;
    }
}