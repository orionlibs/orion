package com.orion.math.probability.distribution.discrete;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.StatisticsService;
import java.util.Map;

public class ProbabilityDistributionOfDiscreteNumericalVariable extends Orion
{
    private Vector values;
    private Map<ANumber, ANumber> probabilityOfEachValueMapper;


    public ProbabilityDistributionOfDiscreteNumericalVariable(Vector values, Map<ANumber, ANumber> probabilityOfEachValueMapper)
    {
        ProbabilityDistributionOfDiscreteNumericalVariableRules.isValid(values, probabilityOfEachValueMapper);
        this.values = values;
        this.probabilityOfEachValueMapper = probabilityOfEachValueMapper;
    }


    public static ProbabilityDistributionOfDiscreteNumericalVariable of(Vector values, Map<ANumber, ANumber> probabilityOfEachValueMapper)
    {
        return new ProbabilityDistributionOfDiscreteNumericalVariable(values, probabilityOfEachValueMapper);
    }


    public ANumber getExpectedValue()
    {
        return StatisticsService.getExpectedValue(values, probabilityOfEachValueMapper);
    }


    public ANumber getVariance()
    {
        return StatisticsService.getVariance(values, probabilityOfEachValueMapper);
    }


    public ANumber getstandardDeviation()
    {
        return getVariance().getSquareRoot();
    }


    public ANumber getCovariance(Vector otherValues, Map<ANumber, ANumber> probabilityOfEachOtherValueMapper, Map<Integer, ANumber> jointProbabilityOfVector1And2)
    {
        return StatisticsService.getCovariance(values, probabilityOfEachValueMapper, otherValues, probabilityOfEachOtherValueMapper, jointProbabilityOfVector1And2);
    }


    public ANumber getExpectedValueOfSumOf2Variables(Vector values2, Map<ANumber, ANumber> probabilityOfEachValueMapper2)
    {
        return StatisticsService.getExpectedValueOfSumOf2Variables(values, probabilityOfEachValueMapper, values2, probabilityOfEachValueMapper2);
    }


    public ANumber getVarianceOfSumOf2Variables(Vector values2, Map<ANumber, ANumber> probabilityOfEachValueMapper2, Map<Integer, ANumber> jointProbabilityOfVector1And2)
    {
        return StatisticsService.getVarianceOfSumOf2Variables(values, probabilityOfEachValueMapper, values2, probabilityOfEachValueMapper2, jointProbabilityOfVector1And2);
    }


    public ANumber getStandardDeviationOfSumOf2Variables(Vector values2, Map<ANumber, ANumber> probabilityOfEachValueMapper2, Map<Integer, ANumber> jointProbabilityOfVector1And2)
    {
        return StatisticsService.getStandardDeviationOfSumOf2Variables(values, probabilityOfEachValueMapper, values2, probabilityOfEachValueMapper2, jointProbabilityOfVector1And2);
    }


    public int getNumberOfValues()
    {
        return values.getDimensions();
    }


    public Vector getValues()
    {
        return this.values;
    }


    public Map<ANumber, ANumber> getProbabilityOfEachValueMapper()
    {
        return this.probabilityOfEachValueMapper;
    }
}