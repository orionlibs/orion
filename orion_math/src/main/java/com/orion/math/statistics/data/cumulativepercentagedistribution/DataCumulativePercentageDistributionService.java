package com.orion.math.statistics.data.cumulativepercentagedistribution;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import com.orion.math.statistics.data.cumulativepercentagedistribution.tasks.GetCumulativePercentageUpToStatisticalClassTask;

public class DataCumulativePercentageDistributionService extends OrionService
{
    public static ANumber getCumulativePercentageUpToClass(DataCumulativePercentageDistribution dataCumulativePercentageDistribution, StatisticalClass statisticalClass)
    {
        return GetCumulativePercentageUpToStatisticalClassTask.run(dataCumulativePercentageDistribution, statisticalClass);
    }
}