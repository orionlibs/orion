package com.orion.math.statemachine;

import com.orion.core.exception.Assert;
import com.orion.core.runnable.functions.OrionFunction2x1;
import com.orion.math.MathRule;

public class OutputFunctionRules extends MathRule
{
    public static void isValid(OrionFunction2x1<State, Object, Object> function)
    {
        Assert.notNull(function, "The function input cannot be null.");
    }


    public static void isValid(OutputFunction outputFunction)
    {
        Assert.notNull(outputFunction, "The outputFunction input cannot be null.");
        isValid(outputFunction.getFunction());
    }
}