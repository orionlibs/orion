package com.orion.math.statistics.data.percentagedistribution;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.statistics.data.frequencydistribution.DataFrequencyDistribution;
import com.orion.math.statistics.data.frequencydistribution.DataFrequencyDistributionRules;

public class DataPercentageDistributionRules extends MathRule
{
    public static void isValid(DataFrequencyDistribution dataFrequencyDistribution)
    {
        DataFrequencyDistributionRules.isValid(dataFrequencyDistribution);
    }


    public static void isValid(DataPercentageDistribution dataPercentageDistribution)
    {
        Assert.notNull(dataPercentageDistribution, "The dataPercentageDistribution input cannor be null.");
        isValid(dataPercentageDistribution.getDataFrequencyDistribution());
    }
}