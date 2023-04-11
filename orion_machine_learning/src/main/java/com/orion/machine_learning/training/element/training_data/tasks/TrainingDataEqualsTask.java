package com.orion.machine_learning.training.element.training_data.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.training.element.training_data.TrainingData;
import com.orion.machine_learning.training.element.training_data.TrainingDataRules;

public class TrainingDataEqualsTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static boolean run(TrainingData x, Object y)
    {
        TrainingDataRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            return x.getTrainingDataPoints().equals(((TrainingData)y).getTrainingDataPoints());
        }

    }
}