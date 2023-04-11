package com.orion.math.probability.distribution.continuous.normal;

import com.orion.math.number.ANumber;

public class SpecialGaussianDistribution extends GaussianDistribution
{
    public static ANumber getProbability(ANumber x)
    {
        return GaussianDistribution.getProbability(x, ANumber.of(1), ANumber.of(0));
    }


    public static ANumber transformVariableToStandardisedForm(ANumber x)
    {
        return GaussianDistribution.transformVariableToStandardisedForm(x, ANumber.of(1), ANumber.of(0));
    }


    public static ANumber getXValue(ANumber x)
    {
        return GaussianDistribution.getXValue(x, ANumber.of(1), ANumber.of(0));
    }
}