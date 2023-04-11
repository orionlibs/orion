package com.orion.math.variable;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;

public class VariableRules extends MathRule
{
    public static void isValid(Object value)
    {
        Assert.notNull(value, "The given value cannot be null.");
    }


    public static void isValid(Variable x)
    {
        Assert.notNull(x, "The given variable cannot be null.");
        isValid(x.getValue());
    }
}