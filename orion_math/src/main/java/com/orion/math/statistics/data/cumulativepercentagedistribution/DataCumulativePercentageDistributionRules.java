package com.orion.math.statistics.data.cumulativepercentagedistribution;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.statistics.data.percentagedistribution.DataPercentageDistribution;
import com.orion.math.statistics.data.percentagedistribution.DataPercentageDistributionRules;

public class DataCumulativePercentageDistributionRules extends MathRule
{
    public static void isValid(DataPercentageDistribution dataPercentageDistribution)
    {
        DataPercentageDistributionRules.isValid(dataPercentageDistribution);
    }


    public static void isValid(DataCumulativePercentageDistribution dataCumulativePercentageDistribution)
    {
        Assert.notNull(dataCumulativePercentageDistribution, "The dataCumulativePercentageDistribution input cannor be null.");
        isValid(dataCumulativePercentageDistribution.getDataPercentageDistribution());
    }
}