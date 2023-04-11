package com.orion.machine_learning.training.element.characteristics.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.training.element.characteristics.ElementCharacteristics;
import com.orion.machine_learning.training.element.characteristics.ElementCharacteristicsRules;

public class ElementCharacteristicsHashCodeTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static int run(ElementCharacteristics x)
    {
        ElementCharacteristicsRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getDomainSet().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getLabels().hashCode();
    }
}