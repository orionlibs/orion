package com.orion.math.probability.distribution.continuous.exponential;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class ExponentialDistributionRules extends MathRule
{
    public static void isValid(ANumber lambda)
    {
        NumberRules.isPositive(lambda);
    }


    public static void isValid(ExponentialDistribution distribution)
    {
        Assert.notNull(distribution, "the ExponentialDistribution input cannot be null.");
        isValid(distribution.getLambda());
    }
}