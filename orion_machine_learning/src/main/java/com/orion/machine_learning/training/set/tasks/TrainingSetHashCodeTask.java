package com.orion.machine_learning.training.set.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.training.set.TrainingSet;
import com.orion.machine_learning.training.set.TrainingSetRules;

public class TrainingSetHashCodeTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static int run(TrainingSet x)
    {
        TrainingSetRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getElements().hashCode();
    }
}