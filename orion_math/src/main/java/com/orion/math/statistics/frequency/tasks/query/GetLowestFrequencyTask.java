package com.orion.math.statistics.frequency.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.frequency.FrequencyOfObjects;
import com.orion.math.statistics.frequency.FrequencyOfObjectsRules;

public class GetLowestFrequencyTask extends Orion
{
    public static ANumber run(FrequencyOfObjects frequencies)
    {
        FrequencyOfObjectsRules.isValid(frequencies);
        ANumber result = ANumber.ofMax();

        for(ANumber frequency : frequencies.getFrequenciesMapper().values())
        {

            if(frequency.isLessThan(result))
            {
                result = frequency.getCopy();
            }

        }

        return result;
    }
}