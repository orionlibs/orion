package com.orion.machine_learning.element.label.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.element.label.Labels;
import com.orion.machine_learning.element.label.LabelsRules;

public class LabelsHashCodeTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static int run(Labels x)
    {
        LabelsRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getLabels().hashCode();
    }
}