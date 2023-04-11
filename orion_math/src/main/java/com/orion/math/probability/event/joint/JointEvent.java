package com.orion.math.probability.event.joint;

import com.orion.math.probability.event.Event;
import java.util.List;

public class JointEvent<T> extends Event<T>
{
    private List<T> values;


    public JointEvent(List<T> values)
    {
        JointEventRules.isValid(values);
        this.values = values;
    }


    public static <T> JointEvent<T> of(List<T> values)
    {
        return new JointEvent<T>(values);
    }


    public List<T> getValues()
    {
        return this.values;
    }
}