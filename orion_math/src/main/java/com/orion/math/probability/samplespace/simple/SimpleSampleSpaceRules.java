package com.orion.math.probability.samplespace.simple;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.probability.event.simple.SimpleEvent;
import java.util.List;

public class SimpleSampleSpaceRules extends MathRule
{
    public static <T> void isValid(List<SimpleEvent<T>> events)
    {
        Assert.notEmpty(events, "The SimpleSampleSpace events input cannot be null/empty.");
    }


    public static <T> void isValid(SimpleSampleSpace<T> sampleSpace)
    {
        Assert.notNull(sampleSpace, "The SimpleSampleSpace input cannot be null.");
        isValid(sampleSpace.getEvents());
    }
}