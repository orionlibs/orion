package com.orion.math.statistics.frequency.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.frequency.FrequencyOfObjects;
import com.orion.math.statistics.frequency.FrequencyOfObjectsRules;
import java.util.ArrayList;
import java.util.List;

public class GetMostFrequentObjectsTask extends Orion
{
    public static List<Object> run(FrequencyOfObjects frequencies)
    {
        FrequencyOfObjectsRules.isValid(frequencies);
        List<Object> result = new ArrayList<Object>();
        ANumber highestFrequency = frequencies.getHighestFrequency();
        frequencies.getFrequenciesMapper().entrySet().stream()
                        .filter(e -> highestFrequency.equal(e.getValue()))
                        .forEach(e -> result.add(e.getKey()));
        return result;
    }
}