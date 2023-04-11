package com.orion.math.statistics.frequency.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.statistics.frequency.FrequencyOfObjects;
import com.orion.math.statistics.frequency.FrequencyOfObjectsRules;

public class FrequencyOfObjectsEqualsTask extends Orion
{
    public static boolean run(FrequencyOfObjects x, Object y)
    {
        FrequencyOfObjectsRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            FrequencyOfObjects other = (FrequencyOfObjects)y;
            return x.getFrequenciesMapper().equals(other.getFrequenciesMapper());
        }

    }
}