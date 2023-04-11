package com.orion.machine_learning.training.element.characteristics;

import com.orion.machine_learning.training.element.characteristics.tasks.ElementCharacteristicsEqualsTask;
import com.orion.machine_learning.training.element.characteristics.tasks.ElementCharacteristicsHashCodeTask;
import com.orion.math.MathObject;

class ElementCharacteristicsInternalService implements MathObject
{
    @SuppressWarnings("rawtypes")
    static boolean equals(ElementCharacteristics x, Object y)
    {
        return ElementCharacteristicsEqualsTask.run(x, y);
    }


    @SuppressWarnings("rawtypes")
    static int hashCode(ElementCharacteristics x)
    {
        return ElementCharacteristicsHashCodeTask.run(x);
    }
}