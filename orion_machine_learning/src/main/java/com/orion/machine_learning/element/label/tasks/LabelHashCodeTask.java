package com.orion.machine_learning.element.label.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.element.label.Label;
import com.orion.machine_learning.element.label.LabelRules;

public class LabelHashCodeTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static int run(Label x)
    {
        LabelRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getValue().hashCode();
    }
}