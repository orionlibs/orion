package com.orion.math.statemachine;

import com.orion.core.exception.Assert;
import com.orion.core.runnable.functions.OrionFunction2x1;
import com.orion.math.MathRule;

public class TransitionFunctionRules extends MathRule
{
    public static void isValid(OrionFunction2x1<State, Object, State> function)
    {
        Assert.notNull(function, "The function input cannot be null.");
    }


    public static void isValid(TransitionFunction transitionFunction)
    {
        Assert.notNull(transitionFunction, "The transitionFunction input cannot be null.");
        isValid(transitionFunction.getFunction());
    }
}