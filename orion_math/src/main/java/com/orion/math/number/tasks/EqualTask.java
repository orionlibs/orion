package com.orion.math.number.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class EqualTask extends Orion
{
    public static boolean run(ANumber x, ANumber y)
    {
        NumberRules.isNotNull(x);

        if(y == null)
        {
            return false;
        }
        else
        {
            boolean areRealValuesEqual = x.get().compareTo(y.get()) == 0;
            boolean areImaginaryValuesEqual = x.getImaginaryValue().compareTo(y.getImaginaryValue()) == 0;
            return areRealValuesEqual && areImaginaryValuesEqual;
        }

    }
}