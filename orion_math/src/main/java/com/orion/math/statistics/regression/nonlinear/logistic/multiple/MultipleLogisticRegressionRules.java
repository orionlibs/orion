package com.orion.math.statistics.regression.nonlinear.logistic.multiple;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;
import com.orion.math.statistics.trainingset.TrainingSetRules;
import java.util.List;

public class MultipleLogisticRegressionRules extends MathRule
{
    public static void doSizesMatch(Vector slopes, Vector xValues)
    {
        VectorRules.isValid(slopes);
        VectorRules.isValid(xValues);
        Assert.areEqual(slopes.getDimensions(), xValues.getDimensions(), "Slopes/xValues for MultipleLogisticRegression sizes do not match.");
    }


    public static void isValid(MultifeatureTrainingSet trainingSet, Vector probabilitiesNeededToFindIntercept, List<Vector> probabilitiesNeededToFindSlopes)
    {
        isValid(trainingSet);
        VectorRules.isValid(probabilitiesNeededToFindIntercept);
        Assert.isLessThanOrEqualTo(probabilitiesNeededToFindIntercept.getDimensions(), trainingSet.getSize(), "Number of probabilities needed to find intercept for MultipleLogisticRegression is more than the training set size.");
    }


    public static void isValid(MultifeatureTrainingSet trainingSet)
    {
        TrainingSetRules.isValid(trainingSet);
    }


    public static void isValid(MultipleLogisticRegression multipleLogisticRegression)
    {
        Assert.notNull(multipleLogisticRegression, "The multipleLogisticRegression input cannot be null.");
        isValid(multipleLogisticRegression.getTrainingSet());
    }
}