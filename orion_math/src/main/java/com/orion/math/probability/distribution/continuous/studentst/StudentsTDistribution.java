package com.orion.math.probability.distribution.continuous.studentst;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.StatisticsService;
import java.util.Map;

public class StudentsTDistribution extends Orion
{
    private Vector population;
    private Vector sample;
    private ANumber sampleMean;
    private ANumber populationMean;
    private ANumber sampleVariance;
    private ANumber sampleSize;
    private Map<ANumber, ANumber> probabilityOfEachValueMapper;


    public StudentsTDistribution(Vector population, Vector sample)
    {
        StudentsTDistributionRules.isValid(population, sample);
        initialise(population, sample);
        this.sampleVariance = StatisticsService.getSampleVariance(sample);
    }


    public StudentsTDistribution(Vector population, Vector sample, Map<ANumber, ANumber> probabilityOfEachValueMapper)
    {
        StudentsTDistributionRules.isValid(population, sample, probabilityOfEachValueMapper);
        initialise(population, sample);
        this.sampleVariance = StatisticsService.getVariance(sample, probabilityOfEachValueMapper);
    }


    public static StudentsTDistribution of(Vector population, Vector sample)
    {
        return new StudentsTDistribution(population, sample);
    }


    public static StudentsTDistribution of(Vector population, Vector sample, Map<ANumber, ANumber> probabilityOfEachValueMapper)
    {
        return new StudentsTDistribution(population, sample, probabilityOfEachValueMapper);
    }


    private void initialise(Vector population, Vector sample)
    {
        this.population = population;
        this.sample = sample;
        this.sampleMean = sample.getArithmeticAverage();
        this.populationMean = population.getArithmeticAverage();
        this.sampleSize = sample.getDimensionsAsNumber();
    }


    public ANumber getT()
    {
        return sampleMean.subtractGET(populationMean).divideGET(sampleVariance.divideGET(sampleSize.getSquareRoot()));
    }


    public ANumber getDegreesOfFreedom()
    {
        return sampleSize.subtractOneGET();
    }


    public ANumber getSampleMean()
    {
        return this.sampleMean;
    }


    public ANumber getPopulationMean()
    {
        return this.populationMean;
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


    public ANumber getSampleVariance()
    {
        return this.sampleVariance;
    }


    public Map<ANumber, ANumber> getProbabilityOfEachValueMapper()
    {
        return this.probabilityOfEachValueMapper;
    }
}