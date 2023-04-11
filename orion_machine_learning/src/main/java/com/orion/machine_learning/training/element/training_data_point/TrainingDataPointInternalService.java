package com.orion.machine_learning.training.element.training_data_point;

import com.orion.machine_learning.training.element.training_data_point.tasks.TrainingDataPointEqualsTask;
import com.orion.machine_learning.training.element.training_data_point.tasks.TrainingDataPointHashCodeTask;
import com.orion.math.MathObject;

class TrainingDataPointInternalService implements MathObject
{
    @SuppressWarnings("rawtypes")
    static boolean equals(TrainingDataPoint x, Object y)
    {
        return TrainingDataPointEqualsTask.run(x, y);
    }


    @SuppressWarnings("rawtypes")
    static int hashCode(TrainingDataPoint x)
    {
        return TrainingDataPointHashCodeTask.run(x);
    }
}