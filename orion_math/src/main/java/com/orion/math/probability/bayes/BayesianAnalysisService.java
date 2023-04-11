package com.orion.math.probability.bayes;

import com.orion.core.abstraction.OrionService;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.probability.bayes.function.BayesRuleFunction;
import com.orion.math.probability.bayes.function.BayesRuleFunctionRules;
import com.orion.math.probability.bayes.tasks.CalculateProbabilityOfEachDataPointForBayesTask;
import com.orion.math.probability.bayes.tasks.CalculateProbabilityOfEachDataPointGivenClassForBayesTask;
import com.orion.math.probability.bayes.tasks.CalculateProbabilityOfEachFeatureGivenClassForBayesTask;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;
import com.orion.math.statistics.trainingset.TrainingSet;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;
import java.util.HashMap;
import java.util.Map;

public class BayesianAnalysisService extends OrionService
{
    public static Map<ANumber, ANumber> calculateProbabilityOfEachClass(TrainingSet trainingSet)
    {
        Map<ANumber, ANumber> mapper = new HashMap<ANumber, ANumber>(trainingSet.getNumberOfClasses());
        ANumber n = trainingSet.getSizeAsNumber();
        trainingSet.getClasses()
                        .forEach(class1 -> mapper.put(class1, trainingSet.getNumberOfDataPointsWithClass(class1).divideGET(n)));
        return mapper;
    }


    public static Map<Pair<ANumber, ANumber>, ANumber> calculateProbabilityOfEachDataPointGivenClass(UnifeatureTrainingSet trainingSet)
    {
        return CalculateProbabilityOfEachDataPointGivenClassForBayesTask.run(trainingSet);
    }


    public static Map<Pair<Vector, ANumber>, ANumber> calculateProbabilityOfEachDataPointGivenClass(MultifeatureTrainingSet trainingSet)
    {
        return CalculateProbabilityOfEachDataPointGivenClassForBayesTask.run(trainingSet);
    }


    public static Map<Pair<ANumber, ANumber>, ANumber> calculateProbabilityOfEachFeatureGivenClass(MultifeatureTrainingSet trainingSet)
    {
        return CalculateProbabilityOfEachFeatureGivenClassForBayesTask.run(trainingSet);
    }


    public static Map<ANumber, ANumber> calculateProbabilityOfEachDataPoint(UnifeatureTrainingSet trainingSet, Map<ANumber, ANumber> probabilityOfEachClass, Map<Pair<ANumber, ANumber>, ANumber> probabilityOfEachFeatureGivenClass)
    {
        return CalculateProbabilityOfEachDataPointForBayesTask.run(trainingSet, probabilityOfEachClass, probabilityOfEachFeatureGivenClass);
    }


    public static Map<Vector, ANumber> calculateProbabilityOfEachDataPoint(MultifeatureTrainingSet trainingSet, Map<ANumber, ANumber> probabilityOfEachClass, Map<Pair<Vector, ANumber>, ANumber> probabilityOfEachDataPointGivenClass)
    {
        return CalculateProbabilityOfEachDataPointForBayesTask.run(trainingSet, probabilityOfEachClass, probabilityOfEachDataPointGivenClass);
    }


    public static ANumber getProbabilityOfXGivenY(ANumber probabilityOfYGivenX, ANumber probabilityOfY, ANumber probabilityOfX)
    {
        BayesRuleFunctionRules.isValidToGetProbabilityOfXGivenY(probabilityOfYGivenX, probabilityOfY, probabilityOfX);
        return BayesRuleFunction.getProbabilityOfXGivenY(probabilityOfYGivenX, probabilityOfY, probabilityOfX);
    }


    public static ANumber getProbabilityOfYGivenX(ANumber probabilityOfXGivenY, ANumber probabilityOfY, ANumber probabilityOfX)
    {
        BayesRuleFunctionRules.isValidToGetProbabilityOfYGivenX(probabilityOfXGivenY, probabilityOfY, probabilityOfX);
        return BayesRuleFunction.getProbabilityOfYGivenX(probabilityOfXGivenY, probabilityOfY, probabilityOfX);
    }


    public static ANumber getProbabilityOfX(ANumber probabilityOfYGivenX, ANumber probabilityOfY, ANumber probabilityOfXGivenY)
    {
        BayesRuleFunctionRules.isValidToGetProbabilityOfX(probabilityOfYGivenX, probabilityOfY, probabilityOfXGivenY);
        return BayesRuleFunction.getProbabilityOfX(probabilityOfYGivenX, probabilityOfY, probabilityOfXGivenY);
    }


    public static ANumber getProbabilityOfY(ANumber probabilityOfXGivenY, ANumber probabilityOfX, ANumber probabilityOfYGivenX)
    {
        BayesRuleFunctionRules.isValidToGetProbabilityOfY(probabilityOfXGivenY, probabilityOfX, probabilityOfYGivenX);
        return BayesRuleFunction.getProbabilityOfY(probabilityOfXGivenY, probabilityOfX, probabilityOfYGivenX);
    }
}