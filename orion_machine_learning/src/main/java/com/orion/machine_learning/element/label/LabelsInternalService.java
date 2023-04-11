package com.orion.machine_learning.element.label;

import com.orion.machine_learning.element.label.tasks.LabelsEqualsTask;
import com.orion.machine_learning.element.label.tasks.LabelsHashCodeTask;
import com.orion.math.MathObject;

class LabelsInternalService implements MathObject
{
    @SuppressWarnings("rawtypes")
    static boolean equals(Labels x, Object y)
    {
        return LabelsEqualsTask.run(x, y);
    }


    @SuppressWarnings("rawtypes")
    static int hashCode(Labels x)
    {
        return LabelsHashCodeTask.run(x);
    }
}