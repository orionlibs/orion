package com.orion.machine_learning.element.label;

import com.orion.core.abstraction.Orion;

public class LabelRules<T> extends Orion
{
    public static <T> void isValid(T value)
    {

        if(value == null)
        {
            throw new NullLabelException("Value is null.");
        }

    }


    public static <T> void isValid(Label<T> label)
    {

        if(label == null)
        {
            throw new NullLabelException("Label is null.");
        }

        isValid(label.getValue());
    }
}