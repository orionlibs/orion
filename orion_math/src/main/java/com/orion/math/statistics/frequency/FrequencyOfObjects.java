package com.orion.math.statistics.frequency;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.number.ANumber;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class FrequencyOfObjects implements MathObject, Cloneable
{
    private SortedMap<Object, ANumber> frequenciesMapper;


    public FrequencyOfObjects(Collection<?> objects)
    {
        FrequencyOfObjectsRules.isValid(objects);
        SortedMap<Object, ANumber> frequenciesMapperTemp = new TreeMap<>();

        for(Object object : objects)
        {

            if(frequenciesMapperTemp.get(object) != null)
            {
                frequenciesMapperTemp.put(object, frequenciesMapperTemp.get(object).addOneGET());
            }
            else
            {
                frequenciesMapperTemp.put(object, ANumber.of(1));
            }

        }

        this.frequenciesMapper = frequenciesMapperTemp;
    }


    public FrequencyOfObjects(SortedMap<Object, ANumber> frequenciesMapper)
    {
        FrequencyOfObjectsRules.isValid(frequenciesMapper);
        this.frequenciesMapper = frequenciesMapper;
    }


    public FrequencyOfObjects(Set<Map.Entry<Object, ANumber>> frequencies)
    {
        FrequencyOfObjectsRules.isValid(frequencies);
        this.frequenciesMapper = new TreeMap<Object, ANumber>();
        frequencies.forEach(entry -> frequenciesMapper.put(entry.getKey(), entry.getValue()));
    }


    public FrequencyOfObjects(Comparator<Object> comparator)
    {
        this.frequenciesMapper = new TreeMap<Object, ANumber>(comparator);
    }


    public static FrequencyOfObjects of(Collection<?> objects)
    {
        return new FrequencyOfObjects(objects);
    }


    public static FrequencyOfObjects of(SortedMap<Object, ANumber> frequenciesMapper)
    {
        return new FrequencyOfObjects(frequenciesMapper);
    }


    public static FrequencyOfObjects of(Set<Map.Entry<Object, ANumber>> frequencies)
    {
        return new FrequencyOfObjects(frequencies);
    }


    public static FrequencyOfObjects of(Comparator<Object> comparator)
    {
        return new FrequencyOfObjects(comparator);
    }


    public Set<?> getUniqueElements()
    {
        return frequenciesMapper.keySet();
    }


    public int getSize()
    {
        return frequenciesMapper.size();
    }


    public void incrementFrequency(Object object)
    {
        incrementFrequency(object, ANumber.of(1));
    }


    public void incrementFrequency(Object object, ANumber frequency)
    {
        FrequencyOfObjectsService.incrementFrequency(this, object, frequency);
    }


    public void clear()
    {
        frequenciesMapper.clear();
    }


    public Iterator<Object> getKeysIterator()
    {
        return frequenciesMapper.keySet().iterator();
    }


    public Iterator<ANumber> getValuesIterator()
    {
        return frequenciesMapper.values().iterator();
    }


    public Iterator<Map.Entry<Object, ANumber>> getEntriesIterator()
    {
        return frequenciesMapper.entrySet().iterator();
    }


    public ANumber getSumOfFrequencies()
    {
        return FrequencyOfObjectsService.getSumOfFrequencies(this);
    }


    public ANumber getFrequency(Object x)
    {
        return FrequencyOfObjectsService.getFrequency(this, x);
    }


    public ANumber getFrequencyPercentageFor(Object x)
    {
        return FrequencyOfObjectsService.getFrequencyPercentageFor(this, x);
    }


    public ANumber getCumulativeFrequencyLessThanOrEqualTo(Object x)
    {
        return FrequencyOfObjectsService.getCumulativeFrequencyLessThanOrEqualTo(this, x);
    }


    public ANumber getNormalisedCumulativeFrequencyLessThanOrEqualTo(Object x)
    {
        return FrequencyOfObjectsService.getNormalisedCumulativeFrequencyLessThanOrEqualTo(this, x);
    }


    public ANumber getLowestFrequency()
    {
        return FrequencyOfObjectsService.getLowestFrequency(this);
    }


    public ANumber getHighestFrequency()
    {
        return FrequencyOfObjectsService.getHighestFrequency(this);
    }


    public List<Object> getMostFrequentObjects()
    {
        return FrequencyOfObjectsService.getMostFrequentObjects(this);
    }


    public List<Object> getLeastFrequentObjects()
    {
        return FrequencyOfObjectsService.getLeastFrequentObjects(this);
    }


    public void merge(FrequencyOfObjects other)
    {
        FrequencyOfObjectsService.merge(this, other);
    }


    public FrequencyOfObjects mergeGET(FrequencyOfObjects other)
    {
        return FrequencyOfObjectsService.mergeGET(this, other);
    }


    @Override
    public FrequencyOfObjects clone() throws CloneNotSupportedException
    {
        return (FrequencyOfObjects)CloningService.clone(this);
    }


    public FrequencyOfObjects getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public int hashCode()
    {
        return FrequencyOfObjectsInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return FrequencyOfObjectsInternalService.equals(this, object);
    }


    public SortedMap<Object, ANumber> getFrequenciesMapper()
    {
        return this.frequenciesMapper;
    }
}