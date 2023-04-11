package com.orion.math.probability.bayes.naive.multifeature;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.probability.bayes.BayesianAnalysisService;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;
import java.util.Map;

public class NaiveBayesMultifeature extends Orion
{
    private MultifeatureTrainingSet trainingSet;
    private Map<ANumber, ANumber> probabilityOfEachClass;
    private Map<Pair<Vector, ANumber>, ANumber> probabilityOfEachDataPointGivenClass;
    private Map<Pair<ANumber, ANumber>, ANumber> probabilityOfEachFeatureGivenClass;
    private Map<Vector, ANumber> probabilityOfEachDataPoint;


    public NaiveBayesMultifeature(MultifeatureTrainingSet trainingSet)
    {
        NaiveBayesMultifeatureRules.isValid(trainingSet);
        this.trainingSet = trainingSet;
        this.probabilityOfEachClass = BayesianAnalysisService.calculateProbabilityOfEachClass(trainingSet);
        this.probabilityOfEachDataPointGivenClass = BayesianAnalysisService.calculateProbabilityOfEachDataPointGivenClass(trainingSet);
        this.probabilityOfEachFeatureGivenClass = BayesianAnalysisService.calculateProbabilityOfEachFeatureGivenClass(trainingSet);
        this.probabilityOfEachDataPoint = BayesianAnalysisService.calculateProbabilityOfEachDataPoint(trainingSet, probabilityOfEachClass, probabilityOfEachDataPointGivenClass);
    }


    public static NaiveBayesMultifeature of(MultifeatureTrainingSet trainingSet)
    {
        return new NaiveBayesMultifeature(trainingSet);
    }


    public MultifeatureTrainingSet getTrainingSet()
    {
        return this.trainingSet;
    }


    public Map<ANumber, ANumber> getProbabilityOfEachClass()
    {
        return this.probabilityOfEachClass;
    }


    public Map<Pair<Vector, ANumber>, ANumber> getProbabilityOfEachDataPointGivenClass()
    {
        return this.probabilityOfEachDataPointGivenClass;
    }


    public Map<Pair<ANumber, ANumber>, ANumber> getProbabilityOfEachFeatureGivenClass()
    {
        return this.probabilityOfEachFeatureGivenClass;
    }


    public Map<Vector, ANumber> getProbabilityOfEachDataPoint()
    {
        return this.probabilityOfEachDataPoint;
    }
}