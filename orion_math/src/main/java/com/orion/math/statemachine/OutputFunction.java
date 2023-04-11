package com.orion.math.statemachine;

import com.orion.core.abstraction.Orion;
import com.orion.core.runnable.functions.OrionFunction2x1;
import com.orion.math.MathObject;

public class OutputFunction extends Orion implements MathObject
{
    private OrionFunction2x1<State, Object, Object> function;


    public OutputFunction(OrionFunction2x1<State, Object, Object> function)
    {
        OutputFunctionRules.isValid(function);
        this.function = function;
    }


    public static OutputFunction of(OrionFunction2x1<State, Object, Object> function)
    {
        return new OutputFunction(function);
    }


    public Object run(State state, Object inputValueFromInputAlphabet)
    {
        return function.run(state, inputValueFromInputAlphabet);
    }


    public OrionFunction2x1<State, Object, Object> getFunction()
    {
        return this.function;
    }
}