package com.orion.math.statistics.data.frequencydistribution;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import com.orion.math.statistics.data.frequencydistribution.tasks.GetRelativeFrequencyTask;

public class DataFrequencyDistributionService extends OrionService
{
    public static ANumber getRelativeFrequency(DataFrequencyDistribution dataFrequencyDistribution, StatisticalClass statisticalClass)
    {
        return GetRelativeFrequencyTask.run(dataFrequencyDistribution, statisticalClass);
    }
}