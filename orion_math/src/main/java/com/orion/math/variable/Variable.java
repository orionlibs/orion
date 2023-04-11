package com.orion.math.variable;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.function.onevariable.Function1x1;

public abstract class Variable<T> extends Orion implements MathObject
{
    private T value;
    private Function1x1<T, T> function = Function1x1.of(x -> x);


    public Variable()
    {
    }


    public Variable(T value)
    {
        VariableRules.isValid(value);
        this.value = value;
    }


    public T getValue()
    {
        return this.value;
    }


    public void setValue(T value)
    {
        VariableRules.isValid(value);
        this.value = value;
    }


    public Function1x1<T, T> getFunction()
    {
        return this.function;
    }
}