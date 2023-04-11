package com.orion.machine_learning.training.element.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.training.element.Element;
import com.orion.machine_learning.training.element.ElementRules;

public class ElementHashCodeTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static int run(Element x)
    {
        ElementRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getCharacteristics().hashCode();
    }
}