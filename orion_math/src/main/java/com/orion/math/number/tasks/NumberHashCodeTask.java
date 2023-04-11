package com.orion.math.number.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class NumberHashCodeTask extends Orion
{
    public static int run(ANumber x)
    {
        NumberRules.isNotNull(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.get().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getImaginaryValue().hashCode();
    }
}