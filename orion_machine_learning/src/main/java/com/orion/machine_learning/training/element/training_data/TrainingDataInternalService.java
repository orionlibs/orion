package com.orion.machine_learning.training.element.training_data;

import com.orion.machine_learning.training.element.training_data.tasks.TrainingDataEqualsTask;
import com.orion.machine_learning.training.element.training_data.tasks.TrainingDataHashCodeTask;
import com.orion.math.MathObject;

class TrainingDataInternalService implements MathObject
{
    @SuppressWarnings("rawtypes")
    static boolean equals(TrainingData x, Object y)
    {
        return TrainingDataEqualsTask.run(x, y);
    }


    @SuppressWarnings("rawtypes")
    static int hashCode(TrainingData x)
    {
        return TrainingDataHashCodeTask.run(x);
    }
}