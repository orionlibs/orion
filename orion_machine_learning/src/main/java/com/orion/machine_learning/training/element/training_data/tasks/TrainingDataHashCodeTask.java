package com.orion.machine_learning.training.element.training_data.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.training.element.training_data.TrainingData;
import com.orion.machine_learning.training.element.training_data.TrainingDataRules;

public class TrainingDataHashCodeTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static int run(TrainingData x)
    {
        TrainingDataRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getTrainingDataPoints().hashCode();
    }
}