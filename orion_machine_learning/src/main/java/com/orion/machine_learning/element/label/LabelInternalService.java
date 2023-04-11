package com.orion.machine_learning.element.label;

import com.orion.machine_learning.element.label.tasks.LabelEqualsTask;
import com.orion.machine_learning.element.label.tasks.LabelHashCodeTask;
import com.orion.math.MathObject;

class LabelInternalService implements MathObject
{
    @SuppressWarnings("rawtypes")
    static boolean equals(Label x, Object y)
    {
        return LabelEqualsTask.run(x, y);
    }


    @SuppressWarnings("rawtypes")
    static int hashCode(Label x)
    {
        return LabelHashCodeTask.run(x);
    }
}