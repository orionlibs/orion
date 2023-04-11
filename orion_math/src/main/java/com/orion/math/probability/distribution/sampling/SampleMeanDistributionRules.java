package com.orion.math.probability.distribution.sampling;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;

public class SampleMeanDistributionRules extends MathRule
{
    public static void isValid(Vector population, Vector sample)
    {
        VectorRules.areValid(population, sample);
    }


    public static void isValid(SampleMeanDistribution distribution)
    {
        Assert.notNull(distribution, "The SampleMeanDistribution input cannot be null.");
        isValid(distribution.getPopulation(), distribution.getSample());
    }
}