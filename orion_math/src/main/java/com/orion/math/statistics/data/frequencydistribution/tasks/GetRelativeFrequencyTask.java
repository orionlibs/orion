package com.orion.math.statistics.data.frequencydistribution.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import com.orion.math.statistics.data.frequencydistribution.DataFrequencyDistribution;

public class GetRelativeFrequencyTask extends Orion
{
    public static ANumber run(DataFrequencyDistribution dataFrequencyDistribution, StatisticalClass statisticalClass)
    {
        return dataFrequencyDistribution.getNumberOfElementsInClassAsNumber(statisticalClass).divideGET(dataFrequencyDistribution.getNumberOfValuesAsNumber());
    }
}