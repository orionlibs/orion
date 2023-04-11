package com.orion.math.statistics.regression.linear.simple;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.statistics.trainingset.TrainingSetRules;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;

public class SimpleLinearRegressionRules extends MathRule
{
    public static void isValid(UnifeatureTrainingSet trainingSet)
    {
        TrainingSetRules.isValid(trainingSet);
    }


    public static void isValid(SimpleLinearRegression simpleLinearRegression)
    {
        Assert.notNull(simpleLinearRegression, "The simpleLinearRegression input cannor be null.");
        isValid(simpleLinearRegression.getTrainingSet());
    }
}