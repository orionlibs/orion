package com.orion.math.probability.samplespace.simple;

import com.orion.math.probability.event.simple.SimpleEvent;
import com.orion.math.probability.samplespace.SampleSpace;
import java.util.List;

public class SimpleSampleSpace<T> extends SampleSpace<T>
{
    private List<SimpleEvent<T>> events;


    public SimpleSampleSpace(List<SimpleEvent<T>> events)
    {
        SimpleSampleSpaceRules.isValid(events);
        this.events = events;
    }


    public static <T> SimpleSampleSpace<T> of(List<SimpleEvent<T>> events)
    {
        return new SimpleSampleSpace<T>(events);
    }


    public List<SimpleEvent<T>> getEvents()
    {
        return this.events;
    }
}