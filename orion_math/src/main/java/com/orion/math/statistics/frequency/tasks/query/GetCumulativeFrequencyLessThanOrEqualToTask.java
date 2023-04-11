package com.orion.math.statistics.frequency.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.frequency.FrequencyOfObjects;
import com.orion.math.statistics.frequency.FrequencyOfObjectsRules;
import java.util.Iterator;

public class GetCumulativeFrequencyLessThanOrEqualToTask extends Orion
{
    public static ANumber run(FrequencyOfObjects frequencies, Object object)
    {
        FrequencyOfObjectsRules.isValid(frequencies);
        ANumber result = ANumber.of(0);
        ANumber sumOfFrequencies = frequencies.getSumOfFrequencies();

        if(sumOfFrequencies.isZero())
        {
            return ANumber.of(0);
        }
        else
        {
            Iterator<ANumber> iterator = frequencies.getValuesIterator();
            ANumber frequencyToCheck = frequencies.getFrequenciesMapper().get(object);

            while(iterator.hasNext())
            {
                ANumber nextValue = iterator.next();

                if(nextValue.isLessThanOrEqual(frequencyToCheck))
                {
                    result.add(nextValue);
                }
                else
                {
                    break;
                }

            }

        }

        return result;
    }
}