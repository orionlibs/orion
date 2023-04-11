package com.orion.math.probability.distribution.discrete.hypergeometric;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;

public class HypergeometricDistributionRules extends MathRule
{
    public static void isValid(ANumber sampleSize, ANumber populationSize, ANumber numberOfEventsOfInterestInThePopulation)
    {
        NumberRules.haveNaturalNumberValue(sampleSize, populationSize, numberOfEventsOfInterestInThePopulation);
    }


    public static void isValidForProbability(HypergeometricDistribution distribution, ANumber numberOfEventsOfInterestInTheSample)
    {
        NumberRules.hasNaturalNumberValue(numberOfEventsOfInterestInTheSample);
        Assert.isFalse(Numbers.isGreaterThan(numberOfEventsOfInterestInTheSample, distribution.getNumberOfEventsOfInterestInThePopulation()), "numberOfEventsOfInterestInTheSample has to be <= numberOfEventsOfInterestInThePopulation.");
        Assert.isFalse(Numbers.isGreaterThan(numberOfEventsOfInterestInTheSample, distribution.getSampleSize()), "numberOfEventsOfInterestInTheSample has to be <= sampleSize.");
    }


    public static void isValid(HypergeometricDistribution distribution)
    {
        Assert.notNull(distribution, "The HypergeometricDistribution input cannot be null.");
        isValid(distribution.getSampleSize(), distribution.getPopulationSize(), distribution.getNumberOfEventsOfInterestInThePopulation());
    }
}