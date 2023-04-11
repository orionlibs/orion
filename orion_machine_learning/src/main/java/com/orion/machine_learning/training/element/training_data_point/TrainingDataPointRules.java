package com.orion.machine_learning.training.element.training_data_point;

import com.orion.core.abstraction.Orion;

public class TrainingDataPointRules<T> extends Orion
{
    public static <T> void isValid(T value)
    {

        if(value == null)
        {
            throw new NullTrainingDataPointException("Feature value is null.");
        }

    }


    public static <T> void isValid(TrainingDataPoint<T> feature)
    {

        if(feature == null)
        {
            throw new NullTrainingDataPointException("Feature is null.");
        }

        isValid(feature.getValue());
    }
}