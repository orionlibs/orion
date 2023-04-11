package com.orion.math.probability.distribution.sampling;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.statistics.StatisticsService;

public class SampleMeanDistribution extends Orion
{
    private Vector population;
    private Vector sample;
    private ANumber sampleMean;
    private ANumber populationMean;
    private ANumber standardErrorOfMean;
    private ANumber populationStandardDeviation;
    private ANumber sampleSize;
    private ANumber populationSize;


    public SampleMeanDistribution(Vector population, Vector sample)
    {
        SampleMeanDistributionRules.isValid(population, sample);
        this.population = population;
        this.sample = sample;
        this.sampleMean = sample.getArithmeticAverage();
        this.populationMean = population.getArithmeticAverage();
        this.sampleSize = sample.getDimensionsAsNumber();
        this.populationSize = population.getDimensionsAsNumber();
        this.standardErrorOfMean = StatisticsService.getStandardErrorOfMean(population, sampleSize);
        this.populationStandardDeviation = StatisticsService.getPopulationStandardDeviation(population);
    }


    public static SampleMeanDistribution of(Vector population, Vector sample)
    {
        return new SampleMeanDistribution(population, sample);
    }


    public ANumber getZValueOfSampleMean()
    {
        return sampleMean.subtractGET(populationMean).divideGET(standardErrorOfMean);
    }


    public ANumber getStandardErrorOfSampleProportion(ANumber numberOfPopulationItemsThatHaveTheDesiredCharacteristic)
    {
        NumberRules.isLessThanOrEqual(numberOfPopulationItemsThatHaveTheDesiredCharacteristic, populationSize);
        return numberOfPopulationItemsThatHaveTheDesiredCharacteristic.multiplyGET(ANumber.of(1).subtractGET(numberOfPopulationItemsThatHaveTheDesiredCharacteristic)).divideGET(sampleSize).getSquareRoot();
    }


    public ANumber getZValueOfSampleProportion(ANumber numberOfPopulationItemsThatHaveTheDesiredCharacteristic, ANumber numberOfSampleItemsThatHaveTheDesiredCharacteristic)
    {
        NumberRules.isLessThanOrEqual(numberOfPopulationItemsThatHaveTheDesiredCharacteristic, populationSize);
        NumberRules.isLessThanOrEqual(numberOfSampleItemsThatHaveTheDesiredCharacteristic, sampleSize);
        ANumber sampleProportion = numberOfSampleItemsThatHaveTheDesiredCharacteristic.divideGET(sampleSize);
        ANumber populationProportion = numberOfPopulationItemsThatHaveTheDesiredCharacteristic.divideGET(populationSize);
        ANumber a = sampleProportion.subtractGET(populationProportion);
        return a.divideGET(getStandardErrorOfSampleProportion(numberOfPopulationItemsThatHaveTheDesiredCharacteristic));
    }


    public ANumber getSampleMean()
    {
        return this.sampleMean;
    }


    public ANumber getPopulationMean()
    {
        return this.populationMean;
    }


    public ANumber getStandardErrorOfMean()
    {
        return this.standardErrorOfMean;
    }


    public ANumber getPopulationStandardDeviation()
    {
        return this.populationStandardDeviation;
    }


    public ANumber getSampleSize()
    {
        return this.sampleSize;
    }


    public Vector getPopulation()
    {
        return this.population;
    }


    public Vector getSample()
    {
        return this.sample;
    }


    public ANumber getPopulationSize()
    {
        return this.populationSize;
    }
}