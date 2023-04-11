package com.orion.math.probability.bayes.naive.unifeature;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.statistics.trainingset.TrainingSetRules;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;

public class NaiveBayesUnifeatureRules extends MathRule
{
    public static void isValid(UnifeatureTrainingSet trainingSet)
    {
        TrainingSetRules.isValid(trainingSet);
    }


    public static void isValid(NaiveBayesUnifeature naiveBayes)
    {
        Assert.notNull(naiveBayes, "the naiveBayes input cannot be null.");
        isValid(naiveBayes.getTrainingSet());
    }
}