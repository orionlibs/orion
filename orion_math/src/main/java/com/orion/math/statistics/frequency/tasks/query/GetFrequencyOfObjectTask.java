package com.orion.math.statistics.frequency.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.frequency.FrequencyOfObjects;
import com.orion.math.statistics.frequency.FrequencyOfObjectsRules;

public class GetFrequencyOfObjectTask extends Orion
{
    public static ANumber run(FrequencyOfObjects frequencies, Object object)
    {
        FrequencyOfObjectsRules.isValid(frequencies);
        ANumber result = ANumber.of(0);
        ANumber count = frequencies.getFrequenciesMapper().get(object);

        if(count != null)
        {
            result = count.getCopy();
        }

        return result;
    }
}