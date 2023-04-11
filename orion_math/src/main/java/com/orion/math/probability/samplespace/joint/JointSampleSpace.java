package com.orion.math.probability.samplespace.joint;

import com.orion.math.probability.event.joint.JointEvent;
import com.orion.math.probability.samplespace.SampleSpace;
import java.util.List;

public class JointSampleSpace<T> extends SampleSpace<T>
{
    private List<JointEvent<T>> events;


    public JointSampleSpace(List<JointEvent<T>> events)
    {
        JointSampleSpaceRules.isValid(events);
        this.events = events;
    }


    public static <T> JointSampleSpace<T> of(List<JointEvent<T>> events)
    {
        return new JointSampleSpace<T>(events);
    }


    public List<JointEvent<T>> getEvents()
    {
        return this.events;
    }
}