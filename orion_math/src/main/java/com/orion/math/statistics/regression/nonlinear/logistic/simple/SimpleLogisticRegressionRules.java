package com.orion.math.statistics.regression.nonlinear.logistic.simple;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.statistics.trainingset.TrainingSetRules;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;

public class SimpleLogisticRegressionRules extends MathRule
{
    public static void isValid(UnifeatureTrainingSet trainingSet, Vector probabilitiesNeededToFindIntercept, Vector probabilitiesNeededToFindSlope)
    {
        isValid(trainingSet);
        VectorRules.isValid(probabilitiesNeededToFindIntercept);
        Assert.isLessThanOrEqualTo(probabilitiesNeededToFindIntercept.getDimensions(), trainingSet.getSize(), "Number of probabilities needed to find intercept for SimpleLogisticRegression is more than the training set size.");
        VectorRules.isValid(probabilitiesNeededToFindSlope);
        Assert.isLessThanOrEqualTo(probabilitiesNeededToFindSlope.getDimensions(), trainingSet.getSize(), "Number of probabilities needed to find slope for SimpleLogisticRegression is more than the training set size.");
    }


    public static void isValid(UnifeatureTrainingSet trainingSet)
    {
        TrainingSetRules.isValid(trainingSet);
    }


    public static void isValid(SimpleLogisticRegression simpleLogisticRegression)
    {
        Assert.notNull(simpleLogisticRegression, "The simpleLogisticRegression input cannot be null.");
        isValid(simpleLogisticRegression.getTrainingSet());
    }
}