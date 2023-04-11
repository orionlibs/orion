package com.orion.math.statistics.frequency.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.frequency.FrequencyOfObjects;
import com.orion.math.statistics.frequency.FrequencyOfObjectsRules;

public class GetFrequencyPercentageForObjectTask extends Orion
{
    public static ANumber run(FrequencyOfObjects frequencies, Object object)
    {
        FrequencyOfObjectsRules.isValid(frequencies);
        ANumber sumOfFrequencies = frequencies.getSumOfFrequencies();

        if(sumOfFrequencies.isZero())
        {
            return ANumber.ofNaN();
        }

        return frequencies.getFrequency(object).divideGET(sumOfFrequencies);
    }
}