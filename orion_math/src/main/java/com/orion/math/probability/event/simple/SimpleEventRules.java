package com.orion.math.probability.event.simple;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;

public class SimpleEventRules<T> extends MathRule
{
    public static <T> void isValid(T value)
    {
        Assert.notNull(value, "The SimpleEvent value input cannot be null.");
    }


    public static <T> void isValid(SimpleEvent<T> event)
    {
        Assert.notNull(event, "The SimpleEvent input cannot be null.");
        isValid(event.getValue());
    }
}