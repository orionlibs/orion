package com.orion.machine_learning.training.element.characteristics.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.training.element.characteristics.ElementCharacteristics;
import com.orion.machine_learning.training.element.characteristics.ElementCharacteristicsRules;

public class ElementCharacteristicsEqualsTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static boolean run(ElementCharacteristics x, Object y)
    {
        ElementCharacteristicsRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            ElementCharacteristics other = (ElementCharacteristics)y;
            return x.getDomainSet().equals(other.getDomainSet())
                            && x.getLabels().equals(other.getLabels());
        }

    }
}