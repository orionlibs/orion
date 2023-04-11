package com.orion.machine_learning.training.element;

import com.orion.machine_learning.training.element.tasks.ElementEqualsTask;
import com.orion.machine_learning.training.element.tasks.ElementHashCodeTask;
import com.orion.math.MathObject;

class ElementInternalService implements MathObject
{
    @SuppressWarnings("rawtypes")
    static boolean equals(Element x, Object y)
    {
        return ElementEqualsTask.run(x, y);
    }


    @SuppressWarnings("rawtypes")
    static int hashCode(Element x)
    {
        return ElementHashCodeTask.run(x);
    }
}