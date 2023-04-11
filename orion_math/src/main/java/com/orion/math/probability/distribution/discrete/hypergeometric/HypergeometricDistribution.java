package com.orion.math.probability.distribution.discrete.hypergeometric;

import com.orion.core.abstraction.Orion;
import com.orion.math.combinatorics.CombinatoricsService;
import com.orion.math.function.fourvariables.Function4x1;
import com.orion.math.function.fourvariables.Function4x1IF;
import com.orion.math.number.ANumber;

public class HypergeometricDistribution extends Orion
{
    private ANumber sampleSize;
    private ANumber populationSize;
    private ANumber numberOfEventsOfInterestInThePopulation;
    private ANumber numberOfEventsthatAreNotOfInterestInThePopulation;
    private Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> formula;


    public HypergeometricDistribution(ANumber sampleSize, ANumber populationSize, ANumber numberOfEventsOfInterestInThePopulation)
    {
        HypergeometricDistributionRules.isValid(sampleSize, populationSize, numberOfEventsOfInterestInThePopulation);
        this.sampleSize = sampleSize;
        this.populationSize = populationSize;
        this.numberOfEventsOfInterestInThePopulation = numberOfEventsOfInterestInThePopulation;
        this.numberOfEventsthatAreNotOfInterestInThePopulation = populationSize.subtractGET(numberOfEventsOfInterestInThePopulation);
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> f = (ANumber numberOfEventsOfInterestInTheSample, ANumber sampleSize1, ANumber populationSize1, ANumber numberOfEventsOfInterestInThePopulation1) ->
        {
            HypergeometricDistributionRules.isValidForProbability(this, numberOfEventsOfInterestInTheSample);
            ANumber combinations1 = CombinatoricsService.getNumberOfCombinations(numberOfEventsOfInterestInThePopulation1, numberOfEventsOfInterestInTheSample);
            ANumber combinations2 = CombinatoricsService.getNumberOfCombinations(populationSize1.subtractGET(numberOfEventsOfInterestInThePopulation1), sampleSize1.subtractGET(numberOfEventsOfInterestInTheSample));
            ANumber combinations3 = CombinatoricsService.getNumberOfCombinations(populationSize1, sampleSize1);
            return combinations1.multiplyGET(combinations2).divideGET(combinations3);
        };
        formula = Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(f);
    }


    public static HypergeometricDistribution of(ANumber sampleSize, ANumber populationSize, ANumber numberOfEventsOfInterestInThePopulation)
    {
        return new HypergeometricDistribution(sampleSize, populationSize, numberOfEventsOfInterestInThePopulation);
    }


    public ANumber getProbability(ANumber numberOfEventsOfInterestInTheSample)
    {
        return formula.run(numberOfEventsOfInterestInTheSample, sampleSize, populationSize, numberOfEventsOfInterestInThePopulation);
    }


    public ANumber getExpectedValue()
    {
        return sampleSize.multiplyGET(numberOfEventsOfInterestInThePopulation).divideGET(populationSize);
    }


    public ANumber getVariance()
    {
        ANumber a = sampleSize.multiplyGET(numberOfEventsOfInterestInThePopulation);
        ANumber b = populationSize.subtractGET(numberOfEventsOfInterestInThePopulation);
        ANumber c = populationSize.squareGET();
        ANumber d = populationSize.subtractGET(sampleSize);
        ANumber e = populationSize.subtractOneGET();
        return a.multiplyGET(b).multiplyGET(d).divideGET(c.multiplyGET(e));
    }


    public ANumber getStandardDeviation()
    {
        return getVariance().getSquareRoot();
    }


    public ANumber getSampleSize()
    {
        return this.sampleSize;
    }


    public ANumber getPopulationSize()
    {
        return this.populationSize;
    }


    public ANumber getNumberOfEventsOfInterestInThePopulation()
    {
        return this.numberOfEventsOfInterestInThePopulation;
    }


    public ANumber getNumberOfEventsthatAreNotOfInterestInThePopulation()
    {
        return this.numberOfEventsthatAreNotOfInterestInThePopulation;
    }
}