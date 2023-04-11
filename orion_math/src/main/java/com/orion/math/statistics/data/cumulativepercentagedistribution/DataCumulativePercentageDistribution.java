package com.orion.math.statistics.data.cumulativepercentagedistribution;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import com.orion.math.statistics.data.percentagedistribution.DataPercentageDistribution;

public class DataCumulativePercentageDistribution extends Orion
{
    private DataPercentageDistribution dataPercentageDistribution;


    public DataCumulativePercentageDistribution(DataPercentageDistribution dataPercentageDistribution)
    {
        DataCumulativePercentageDistributionRules.isValid(dataPercentageDistribution);
        this.dataPercentageDistribution = dataPercentageDistribution;
    }


    public static DataCumulativePercentageDistribution of(DataPercentageDistribution dataPercentageDistribution)
    {
        return new DataCumulativePercentageDistribution(dataPercentageDistribution);
    }


    public ANumber getCumulativePercentageUpToClass(StatisticalClass statisticalClass)
    {
        return DataCumulativePercentageDistributionService.getCumulativePercentageUpToClass(this, statisticalClass);
    }


    public DataPercentageDistribution getDataPercentageDistribution()
    {
        return this.dataPercentageDistribution;
    }
}