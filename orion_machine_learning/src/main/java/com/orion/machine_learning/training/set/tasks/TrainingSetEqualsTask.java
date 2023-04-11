package com.orion.machine_learning.training.set.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.training.set.TrainingSet;
import com.orion.machine_learning.training.set.TrainingSetRules;

public class TrainingSetEqualsTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static boolean run(TrainingSet x, Object y)
    {
        TrainingSetRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            return x.getElements().equals(((TrainingSet)y).getElements());
        }

    }
}