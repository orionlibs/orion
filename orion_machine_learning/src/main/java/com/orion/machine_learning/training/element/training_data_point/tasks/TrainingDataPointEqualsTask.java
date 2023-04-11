package com.orion.machine_learning.training.element.training_data_point.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPoint;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPointRules;

public class TrainingDataPointEqualsTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static boolean run(TrainingDataPoint x, Object y)
    {
        TrainingDataPointRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            return x.getValue().equals(((TrainingDataPoint)y).getValue());
        }

    }
}