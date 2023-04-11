package com.orion.math.statistics.data.frequencydistribution;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.statistics.classes.StatisticalClasses;
import com.orion.math.statistics.classes.StatisticalClassesRules;

public class DataFrequencyDistributionRules extends MathRule
{
    public static void isValid(StatisticalClasses statisticalClasses)
    {
        StatisticalClassesRules.isValid(statisticalClasses);
    }


    public static void isValid(DataFrequencyDistribution dataFrequencyDistribution)
    {
        Assert.notNull(dataFrequencyDistribution, "The dataFrequencyDistribution input cannor be null.");
        isValid(dataFrequencyDistribution.getStatisticalClasses());
    }
}