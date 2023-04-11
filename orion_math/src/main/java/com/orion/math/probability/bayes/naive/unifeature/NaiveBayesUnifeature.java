package com.orion.math.probability.bayes.naive.unifeature;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.number.ANumber;
import com.orion.math.probability.bayes.BayesianAnalysisService;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;
import java.util.Map;

public class NaiveBayesUnifeature extends Orion
{
    private UnifeatureTrainingSet trainingSet;
    private Map<ANumber, ANumber> probabilityOfEachClass;
    private Map<Pair<ANumber, ANumber>, ANumber> probabilityOfEachDataPointGivenClass;
    private Map<Pair<ANumber, ANumber>, ANumber> probabilityOfEachFeatureGivenClass;
    private Map<ANumber, ANumber> probabilityOfEachDataPoint;


    @SuppressWarnings("unchecked")
    public NaiveBayesUnifeature(UnifeatureTrainingSet trainingSet)
    {
        NaiveBayesUnifeatureRules.isValid(trainingSet);
        this.trainingSet = trainingSet;
        this.probabilityOfEachClass = BayesianAnalysisService.calculateProbabilityOfEachClass(trainingSet);
        this.probabilityOfEachDataPointGivenClass = BayesianAnalysisService.calculateProbabilityOfEachDataPointGivenClass(trainingSet);
        this.probabilityOfEachFeatureGivenClass = (Map<Pair<ANumber, ANumber>, ANumber>)CloningService.clone(probabilityOfEachDataPointGivenClass);
        this.probabilityOfEachDataPoint = BayesianAnalysisService.calculateProbabilityOfEachDataPoint(trainingSet, probabilityOfEachClass, probabilityOfEachFeatureGivenClass);
    }


    public static NaiveBayesUnifeature of(UnifeatureTrainingSet trainingSet)
    {
        return new NaiveBayesUnifeature(trainingSet);
    }


    public UnifeatureTrainingSet getTrainingSet()
    {
        return this.trainingSet;
    }


    public Map<ANumber, ANumber> getProbabilityOfEachClass()
    {
        return this.probabilityOfEachClass;
    }


    public Map<ANumber, ANumber> getProbabilityOfEachDataPoint()
    {
        return this.probabilityOfEachDataPoint;
    }


    public Map<Pair<ANumber, ANumber>, ANumber> getProbabilityOfEachDataPointGivenClass()
    {
        return this.probabilityOfEachDataPointGivenClass;
    }


    public Map<Pair<ANumber, ANumber>, ANumber> getProbabilityOfEachFeatureGivenClass()
    {
        return this.probabilityOfEachFeatureGivenClass;
    }
}