package com.orion.math.statistics.frequency;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.frequency.tasks.IncrementFrequencyOfObjectTask;
import com.orion.math.statistics.frequency.tasks.query.GetCumulativeFrequencyLessThanOrEqualToTask;
import com.orion.math.statistics.frequency.tasks.query.GetFrequencyOfObjectTask;
import com.orion.math.statistics.frequency.tasks.query.GetFrequencyPercentageForObjectTask;
import com.orion.math.statistics.frequency.tasks.query.GetHighestFrequencyTask;
import com.orion.math.statistics.frequency.tasks.query.GetLeastFrequentObjectsTask;
import com.orion.math.statistics.frequency.tasks.query.GetLowestFrequencyTask;
import com.orion.math.statistics.frequency.tasks.query.GetMostFrequentObjectsTask;
import com.orion.math.statistics.frequency.tasks.query.GetNormalisedCumulativeFrequencyLessThanOrEqualToTask;
import com.orion.math.statistics.frequency.tasks.query.GetSumOfFrequenciesOfObjectsTask;
import java.util.List;

public class FrequencyOfObjectsService extends OrionService
{
    public static void incrementFrequency(FrequencyOfObjects frequencies, Object object, ANumber frequency)
    {
        IncrementFrequencyOfObjectTask.run(frequencies, object, frequency);
    }


    public static ANumber getSumOfFrequencies(FrequencyOfObjects frequencies)
    {
        return GetSumOfFrequenciesOfObjectsTask.run(frequencies);
    }


    public static ANumber getFrequency(FrequencyOfObjects frequencies, Object object)
    {
        return GetFrequencyOfObjectTask.run(frequencies, object);
    }


    public static ANumber getFrequencyPercentageFor(FrequencyOfObjects frequencies, Object object)
    {
        return GetFrequencyPercentageForObjectTask.run(frequencies, object);
    }


    public static ANumber getCumulativeFrequencyLessThanOrEqualTo(FrequencyOfObjects frequencies, Object object)
    {
        return GetCumulativeFrequencyLessThanOrEqualToTask.run(frequencies, object);
    }


    public static ANumber getNormalisedCumulativeFrequencyLessThanOrEqualTo(FrequencyOfObjects frequencies, Object object)
    {
        return GetNormalisedCumulativeFrequencyLessThanOrEqualToTask.run(frequencies, object);
    }


    public static ANumber getLowestFrequency(FrequencyOfObjects frequencies)
    {
        return GetLowestFrequencyTask.run(frequencies);
    }


    public static ANumber getHighestFrequency(FrequencyOfObjects frequencies)
    {
        return GetHighestFrequencyTask.run(frequencies);
    }


    public static List<Object> getMostFrequentObjects(FrequencyOfObjects frequencies)
    {
        return GetMostFrequentObjectsTask.run(frequencies);
    }


    public static List<Object> getLeastFrequentObjects(FrequencyOfObjects frequencies)
    {
        return GetLeastFrequentObjectsTask.run(frequencies);
    }


    public static void merge(FrequencyOfObjects frequencies, FrequencyOfObjects other)
    {
        FrequencyOfObjectsRules.isValid(frequencies);
        FrequencyOfObjectsRules.isValid(other);
        other.getFrequenciesMapper().entrySet()
                        .forEach(e -> frequencies.incrementFrequency(e.getKey(), e.getValue()));
    }


    public static FrequencyOfObjects mergeGET(FrequencyOfObjects frequencies, FrequencyOfObjects other)
    {
        FrequencyOfObjectsRules.isValid(frequencies);
        FrequencyOfObjectsRules.isValid(other);
        FrequencyOfObjects newObject = frequencies.getCopy();
        newObject.merge(other);
        return newObject;
    }
}