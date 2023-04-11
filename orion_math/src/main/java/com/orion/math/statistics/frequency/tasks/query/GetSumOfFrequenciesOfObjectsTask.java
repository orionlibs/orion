package com.orion.math.statistics.frequency.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.frequency.FrequencyOfObjects;
import com.orion.math.statistics.frequency.FrequencyOfObjectsRules;
import java.util.Iterator;

public class GetSumOfFrequenciesOfObjectsTask extends Orion
{
    public static ANumber run(FrequencyOfObjects frequencies)
    {
        FrequencyOfObjectsRules.isValid(frequencies);
        ANumber result = ANumber.of(0);
        Iterator<ANumber> iterator = frequencies.getValuesIterator();

        while(iterator.hasNext())
        {
            result.add(iterator.next());
        }

        return result;
    }
}