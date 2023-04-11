package com.orion.math.probability.bayes.naive.multifeature;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;
import com.orion.math.statistics.trainingset.TrainingSetRules;

public class NaiveBayesMultifeatureRules extends MathRule
{
    public static void isValid(MultifeatureTrainingSet trainingSet)
    {
        TrainingSetRules.isValid(trainingSet);
    }


    public static void isValid(NaiveBayesMultifeature naiveBayes)
    {
        Assert.notNull(naiveBayes, "the naiveBayes input cannot be null.");
        isValid(naiveBayes.getTrainingSet());
    }
}