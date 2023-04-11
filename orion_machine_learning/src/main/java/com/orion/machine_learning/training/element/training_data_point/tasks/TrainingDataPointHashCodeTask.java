package com.orion.machine_learning.training.element.training_data_point.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPoint;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPointRules;

public class TrainingDataPointHashCodeTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static int run(TrainingDataPoint x)
    {
        TrainingDataPointRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getValue().hashCode();
    }
}