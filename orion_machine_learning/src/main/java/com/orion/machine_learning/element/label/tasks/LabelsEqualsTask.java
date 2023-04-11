package com.orion.machine_learning.element.label.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.element.label.Labels;
import com.orion.machine_learning.element.label.LabelsRules;

public class LabelsEqualsTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static boolean run(Labels x, Object y)
    {
        LabelsRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            return x.getLabels().equals(((Labels)y).getLabels());
        }

    }
}