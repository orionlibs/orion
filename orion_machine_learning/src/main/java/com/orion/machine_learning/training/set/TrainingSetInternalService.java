package com.orion.machine_learning.training.set;

import com.orion.machine_learning.training.set.tasks.TrainingSetEqualsTask;
import com.orion.machine_learning.training.set.tasks.TrainingSetHashCodeTask;
import com.orion.math.MathObject;

class TrainingSetInternalService implements MathObject
{
    @SuppressWarnings("rawtypes")
    static boolean equals(TrainingSet x, Object y)
    {
        return TrainingSetEqualsTask.run(x, y);
    }


    @SuppressWarnings("rawtypes")
    static int hashCode(TrainingSet x)
    {
        return TrainingSetHashCodeTask.run(x);
    }
}