package com.orion.math.statistics.data.frequencydistribution;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.StatisticalClasses;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataFrequencyDistribution extends Orion
{
    private StatisticalClasses statisticalClasses;
    private Map<StatisticalClass, ANumber> classRelativeFrequencyMapper;
    private LinkedHashMap<StatisticalClass, ANumber> classRelativeFrequencyOrderedByIntervalMapper;


    public DataFrequencyDistribution(StatisticalClasses statisticalClasses)
    {
        DataFrequencyDistributionRules.isValid(statisticalClasses);
        this.statisticalClasses = statisticalClasses;
        this.classRelativeFrequencyMapper = calculateRelativeFrequencyOfEachClass();
        this.classRelativeFrequencyOrderedByIntervalMapper = orderClassRelativeFrequencyMapperByInterval();
    }


    public static DataFrequencyDistribution of(StatisticalClasses statisticalClasses)
    {
        return new DataFrequencyDistribution(statisticalClasses);
    }


    private Map<StatisticalClass, ANumber> calculateRelativeFrequencyOfEachClass()
    {
        Map<StatisticalClass, ANumber> temp = new HashMap<StatisticalClass, ANumber>();
        statisticalClasses.getStatisticalClasses()
                        .forAll(sc -> temp.put(sc, getRelativeFrequency(sc)));
        return temp;
    }


    private LinkedHashMap<StatisticalClass, ANumber> orderClassRelativeFrequencyMapperByInterval()
    {
        LinkedHashMap<StatisticalClass, ANumber> temp = new LinkedHashMap<StatisticalClass, ANumber>();
        OrionList<StatisticalClass> orderedClasses = statisticalClasses.getStatisticalClassesOrderedByInterval();
        orderedClasses.forAll(sc -> temp.put(sc, classRelativeFrequencyMapper.get(sc)));
        return temp;
    }


    public ANumber getRelativeFrequency(StatisticalClass statisticalClass)
    {
        return DataFrequencyDistributionService.getRelativeFrequency(this, statisticalClass);
    }


    public ANumber getProportion(StatisticalClass statisticalClass)
    {
        return getRelativeFrequency(statisticalClass);
    }


    public int getNumberOfElementsInClass(StatisticalClass statisticalClass)
    {
        return statisticalClasses.getNumberOfElementsInClass(statisticalClass);
    }


    public ANumber getNumberOfElementsInClassAsNumber(StatisticalClass statisticalClass)
    {
        return ANumber.of(getNumberOfElementsInClass(statisticalClass));
    }


    public int getNumberOfValues()
    {
        return statisticalClasses.getNumberOfValues();
    }


    public ANumber getNumberOfValuesAsNumber()
    {
        return ANumber.of(getNumberOfValues());
    }


    public int getNumberOfclasses()
    {
        return statisticalClasses.getNumberOfclasses();
    }


    public Map<StatisticalClass, ANumber> getClassRelativeFrequencyMapper()
    {
        return this.classRelativeFrequencyMapper;
    }


    public StatisticalClasses getStatisticalClasses()
    {
        return this.statisticalClasses;
    }


    public LinkedHashMap<StatisticalClass, ANumber> getClassRelativeFrequencyOrderedByIntervalMapper()
    {
        return this.classRelativeFrequencyOrderedByIntervalMapper;
    }
}