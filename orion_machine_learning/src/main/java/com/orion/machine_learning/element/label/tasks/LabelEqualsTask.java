package com.orion.machine_learning.element.label.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.element.label.Label;
import com.orion.machine_learning.element.label.LabelRules;

public class LabelEqualsTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static boolean run(Label x, Object y)
    {
        LabelRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            return x.getValue().equals(((Label)y).getValue());
        }

    }
}