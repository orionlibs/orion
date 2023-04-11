package com.orion.math.probability.distribution.continuous.uniform;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;

public class UniformDistributionRules extends MathRule
{
    public static void isValid(ANumber minimum, ANumber maximum)
    {
        Assert.isFalse(Numbers.isGreaterThanOrEqual(minimum, maximum), "minimum has to be < maximum.");
    }


    public static void isValid(UniformDistribution distribution)
    {
        Assert.notNull(distribution, "the UniformDistribution input cannot be null.");
        isValid(distribution.getMinimum(), distribution.getMaximum());
    }
}