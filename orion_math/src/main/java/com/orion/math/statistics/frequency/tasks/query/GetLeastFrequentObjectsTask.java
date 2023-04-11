package com.orion.math.statistics.frequency.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.frequency.FrequencyOfObjects;
import com.orion.math.statistics.frequency.FrequencyOfObjectsRules;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetLeastFrequentObjectsTask extends Orion
{
    public static List<Object> run(FrequencyOfObjects frequencies)
    {
        FrequencyOfObjectsRules.isValid(frequencies);
        ANumber minimumFrequency = ANumber.ofMax();
        List<Object> result = new ArrayList<Object>();

        for(Map.Entry<Object, ANumber> entry : frequencies.getFrequenciesMapper().entrySet())
        {

            if(entry.getValue().isLessThan(minimumFrequency))
            {
                minimumFrequency = entry.getValue();
                result.add(entry.getKey());
            }

        }

        return result;
    }
}