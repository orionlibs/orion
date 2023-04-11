package com.orion.math.number.interval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class IntervalHashCodeTask extends Orion
{
    public static int run(Interval x)
    {
        IntervalRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getLeftEndpoint().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getRightEndpoint().hashCode();
    }
}