package com.orion.math.probability.distribution.discrete.poisson;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class PoissonDistributionRules extends MathRule
{
    public static void isValid(ANumber lambda)
    {
        NumberRules.hasNaturalNumberValue(lambda);
    }


    public static void isValidForProbabilityForEventsLessThanOrEqualTo(ANumber event)
    {
        NumberRules.isNonNegativeInteger(event);
    }


    public static void isValid(PoissonDistribution distribution)
    {
        Assert.notNull(distribution, "The PoissonDistribution input cannot be null.");
        isValid(distribution.getLambda());
    }
}