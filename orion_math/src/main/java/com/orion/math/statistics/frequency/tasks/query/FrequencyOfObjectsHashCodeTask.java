package com.orion.math.statistics.frequency.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.statistics.frequency.FrequencyOfObjects;
import com.orion.math.statistics.frequency.FrequencyOfObjectsRules;

public class FrequencyOfObjectsHashCodeTask extends Orion
{
    public static int run(FrequencyOfObjects x)
    {
        FrequencyOfObjectsRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getFrequenciesMapper().hashCode();
    }
}