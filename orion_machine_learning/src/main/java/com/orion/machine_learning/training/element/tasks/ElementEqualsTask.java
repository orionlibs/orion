package com.orion.machine_learning.training.element.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.training.element.Element;
import com.orion.machine_learning.training.element.ElementRules;

public class ElementEqualsTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static boolean run(Element x, Object y)
    {
        ElementRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            return x.getCharacteristics().equals(((Element)y).getCharacteristics());
        }

    }
}