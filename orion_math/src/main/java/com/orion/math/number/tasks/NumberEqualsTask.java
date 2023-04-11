package com.orion.math.number.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;

public class NumberEqualsTask extends Orion
{
    public static boolean run(ANumber x, Object y)
    {
        NumberRules.isNotNull(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            ANumber other = (ANumber)y;
            boolean areRealValuesEqual = false;
            boolean areImaginaryValuesEqual = false;
            areRealValuesEqual = Numbers.equal(x.get(), other.get());
            areImaginaryValuesEqual = Numbers.equal(x.getImaginaryValue(), other.getImaginaryValue());
            return areRealValuesEqual && areImaginaryValuesEqual;
        }

    }
}