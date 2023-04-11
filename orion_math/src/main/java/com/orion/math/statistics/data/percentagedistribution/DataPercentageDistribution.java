package com.orion.math.statistics.data.percentagedistribution;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.StatisticalClasses;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import com.orion.math.statistics.data.frequencydistribution.DataFrequencyDistribution;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataPercentageDistribution extends Orion
{
    private DataFrequencyDistribution dataFrequencyDistribution;
    private Map<StatisticalClass, ANumber> classRelativePercentageMapper;
    private LinkedHashMap<StatisticalClass, ANumber> classRelativePercentageOrderedByIntervalMapper;


    public DataPercentageDistribution(DataFrequencyDistribution dataFrequencyDistribution)
    {
        DataPercentageDistributionRules.isValid(dataFrequencyDistribution);
        this.dataFrequencyDistribution = dataFrequencyDistribution;
        this.classRelativePercentageMapper = calculateRelativePercentageOfEachClass();
        this.classRelativePercentageOrderedByIntervalMapper = orderClassRelativePercentageMapperByInterval();
    }


    public static DataPercentageDistribution of(DataFrequencyDistribution dataFrequencyDistribution)
    {
        return new DataPercentageDistribution(dataFrequencyDistribution);
    }


    private Map<StatisticalClass, ANumber> calculateRelativePercentageOfEachClass()
    {
        Map<StatisticalClass, ANumber> temp = new HashMap<StatisticalClass, ANumber>();
        dataFrequencyDistribution.getStatisticalClasses().getStatisticalClasses()
                        .forAll(sc -> temp.put(sc, dataFrequencyDistribution.getRelativeFrequency(sc).multiplyGET(100)));
        return temp;
    }


    private LinkedHashMap<StatisticalClass, ANumber> orderClassRelativePercentageMapperByInterval()
    {
        LinkedHashMap<StatisticalClass, ANumber> temp = new LinkedHashMap<StatisticalClass, ANumber>();
        OrionList<StatisticalClass> orderedClasses = getStatisticalClasses().getStatisticalClassesOrderedByInterval();
        orderedClasses.forAll(sc -> temp.put(sc, classRelativePercentageMapper.get(sc)));
        return temp;
    }


    public ANumber getRelativePercentage(StatisticalClass statisticalClass)
    {
        return classRelativePercentageMapper.get(statisticalClass);
    }


    public Map<StatisticalClass, ANumber> getClassRelativePercentageMapper()
    {
        return this.classRelativePercentageMapper;
    }


    public StatisticalClasses getStatisticalClasses()
    {
        return dataFrequencyDistribution.getStatisticalClasses();
    }


    public DataFrequencyDistribution getDataFrequencyDistribution()
    {
        return this.dataFrequencyDistribution;
    }


    public LinkedHashMap<StatisticalClass, ANumber> getClassRelativePercentageOrderedByIntervalMapper()
    {
        return this.classRelativePercentageOrderedByIntervalMapper;
    }
}