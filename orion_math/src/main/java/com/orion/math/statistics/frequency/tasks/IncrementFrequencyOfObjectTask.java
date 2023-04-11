package com.orion.math.statistics.frequency.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.frequency.FrequencyOfObjects;
import com.orion.math.statistics.frequency.FrequencyOfObjectsRules;

public class IncrementFrequencyOfObjectTask extends Orion
{
    public static void run(FrequencyOfObjects frequencies, Object object, ANumber frequency)
    {
        FrequencyOfObjectsRules.isValid(frequencies);
        ANumber count = frequencies.getFrequenciesMapper().get(object);

        if(count == null)
        {
            frequencies.getFrequenciesMapper().put(object, frequency);
        }
        else
        {
            frequencies.getFrequenciesMapper().put(object, count.addGET(frequency));
        }

    }
}