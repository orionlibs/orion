package com.orion.math.statistics.data.cumulativepercentagedistribution.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import com.orion.math.statistics.classes.aclass.StatisticalClassRules;
import com.orion.math.statistics.data.cumulativepercentagedistribution.DataCumulativePercentageDistribution;
import com.orion.math.statistics.data.cumulativepercentagedistribution.DataCumulativePercentageDistributionRules;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetCumulativePercentageUpToStatisticalClassTask extends Orion
{
    public static ANumber run(DataCumulativePercentageDistribution dataCumulativePercentageDistribution, StatisticalClass statisticalClass)
    {
        DataCumulativePercentageDistributionRules.isValid(dataCumulativePercentageDistribution);
        StatisticalClassRules.isValid(statisticalClass);
        ANumber sum = ANumber.of(0);
        LinkedHashMap<StatisticalClass, ANumber> orderedRelativePercentages = dataCumulativePercentageDistribution.getDataPercentageDistribution().getClassRelativePercentageOrderedByIntervalMapper();

        for(Map.Entry<StatisticalClass, ANumber> entry : orderedRelativePercentages.entrySet())
        {
            sum.add(entry.getValue());

            if(entry.getKey().equals(statisticalClass))
            {
                break;
            }

        }

        return sum;
    }
}