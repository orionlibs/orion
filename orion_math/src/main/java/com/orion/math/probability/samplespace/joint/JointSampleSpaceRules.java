package com.orion.math.probability.samplespace.joint;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.probability.event.joint.JointEvent;
import java.util.List;

public class JointSampleSpaceRules extends MathRule
{
    public static <T> void isValid(List<JointEvent<T>> events)
    {
        Assert.notEmpty(events, "The JointSampleSpace events input cannot be null/empty.");
    }


    public static <T> void isValid(JointSampleSpace<T> sampleSpace)
    {
        Assert.notNull(sampleSpace, "The JointSampleSpace input cannot be null.");
        isValid(sampleSpace.getEvents());
    }
}