package com.orion.math.statemachine;

import com.orion.core.abstraction.Orion;
import com.orion.core.runnable.functions.OrionFunction2x1;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;

public class TransitionFunction extends Orion implements MathObject
{
    private OrionFunction2x1<State, Object, State> function;


    public TransitionFunction(OrionFunction2x1<State, Object, State> function)
    {
        TransitionFunctionRules.isValid(function);
        this.function = function;
    }


    public static TransitionFunction of(OrionFunction2x1<State, Object, State> function)
    {
        return new TransitionFunction(function);
    }


    public Pair<State, Object> run(State state, Object inputValueFromInputAlphabet)
    {
        //the null is supposed to be a value that belongs to the OutputSlphabet
        return Pair.<State, Object>of(function.run(state, inputValueFromInputAlphabet), null);
    }


    public OrionFunction2x1<State, Object, State> getFunction()
    {
        return this.function;
    }
}