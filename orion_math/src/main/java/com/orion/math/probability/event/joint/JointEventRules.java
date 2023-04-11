package com.orion.math.probability.event.joint;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import java.util.List;

public class JointEventRules<T> extends MathRule
{
    public static <T> void isValid(List<T> values)
    {
        Assert.notEmpty(values, "The values input cannot be null/empty.");
    }


    public static <T> void isValid(JointEvent<T> event)
    {
        Assert.notNull(event, "The event input cannot be null.");
        isValid(event.getValues());
    }
}