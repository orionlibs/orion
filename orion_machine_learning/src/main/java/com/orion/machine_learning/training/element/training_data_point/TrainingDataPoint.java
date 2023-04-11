package com.orion.machine_learning.training.element.training_data_point;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;

public class TrainingDataPoint<T> extends Orion implements Cloneable
{
    private T value;


    public TrainingDataPoint(T value)
    {
        TrainingDataPointRules.isValid(value);
        this.value = value;
    }


    public static <T> TrainingDataPoint<T> of(T value)
    {
        return new TrainingDataPoint<T>(value);
    }


    @Override
    public int hashCode()
    {
        return TrainingDataPointInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return TrainingDataPointInternalService.equals(this, object);
    }


    @SuppressWarnings("unchecked")
    @Override
    public TrainingDataPoint<T> clone() throws CloneNotSupportedException
    {
        return (TrainingDataPoint<T>)CloningService.clone(this);
    }


    public TrainingDataPoint<T> getCopy()
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