package com.orion.math.statistics.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetModeTask extends Orion
{
    public static List<ANumber> run(Vector numbers)
    {
        VectorRules.isValid(numbers);
        List<ANumber> modes = new ArrayList<ANumber>();
        Map<ANumber, Integer> numberToFrequencyMapper = new HashMap<ANumber, Integer>(numbers.getDimensions());
        numbers.forAll(x ->
        {

            if(numberToFrequencyMapper.get(x) != null)
            {
                numberToFrequencyMapper.put(x, numberToFrequencyMapper.get(x) + 1);
            }
            else
            {
                numberToFrequencyMapper.put(x, 1);
            }

        });

        if(numbers.getDimensions() != numberToFrequencyMapper.size())
        {
            int maximumNumberFrequency = Collections.max(numberToFrequencyMapper.values());
            modes = numberToFrequencyMapper.entrySet().stream()
                            .filter(entry -> entry.getValue().equals(maximumNumberFrequency))
                            .map(Map.Entry::getKey).collect(Collectors.toList());
        }

        return modes;
    }
}