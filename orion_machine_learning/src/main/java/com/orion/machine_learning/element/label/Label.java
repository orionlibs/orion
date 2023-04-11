package com.orion.machine_learning.element.label;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;

public class Label<T> extends Orion implements Cloneable
{
    private T value;


    public Label(T value)
    {
        LabelRules.isValid(value);
        this.value = value;
    }


    public static <T> Label<T> of(T value)
    {
        return new Label<T>(value);
    }


    @Override
    public int hashCode()
    {
        return LabelInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return LabelInternalService.equals(this, object);
    }


    @SuppressWarnings("unchecked")
    @Override
    public Label<T> clone() throws CloneNotSupportedException
    {
        return (Label<T>)CloningService.clone(this);
    }


    public Label<T> getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    public T getValue()
    {
        return this.value;
    }
}