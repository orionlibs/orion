package com.orion.math.statistics.frequency;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class FrequencyOfObjectsRules extends MathRule
{
    public static void isValid(Set<Map.Entry<Object, ANumber>> frequencies)
    {
        Assert.notEmpty(frequencies, "The frequencies input cannor be null/empty.");
    }


    public static void isValid(SortedMap<Object, ANumber> frequenciesMapper)
    {
        Assert.notEmpty(frequenciesMapper, "The frequenciesMapper input cannor be null/empty.");
    }


    public static void isValid(Collection<?> objects)
    {
        Assert.notEmpty(objects, "The objects input cannor be null/empty.");
    }


    public static void isValid(FrequencyOfObjects frequencies)
    {
        Assert.notNull(frequencies, "The FrequencyOfObjects input cannor be null.");
        isValid(frequencies.getFrequenciesMapper());
    }
}