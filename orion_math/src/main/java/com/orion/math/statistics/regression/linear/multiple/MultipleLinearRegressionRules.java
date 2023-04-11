package com.orion.math.statistics.regression.linear.multiple;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;
import com.orion.math.statistics.trainingset.TrainingSetRules;

public class MultipleLinearRegressionRules extends MathRule
{
    public static void isValid(MultifeatureTrainingSet trainingSet)
    {
        TrainingSetRules.isValid(trainingSet);
    }


    public static void isValid(MultipleLinearRegression multipleLinearRegression)
    {
        Assert.notNull(multipleLinearRegression, "The multipleLinearRegression input cannor be null.");
        isValid(multipleLinearRegression.getTrainingSet());
    }


    public static void doSizesMatch(MultipleLinearRegression multipleLinearRegression, Vector xValues)
    {
        isValid(multipleLinearRegression);
        VectorRules.doVectorSizesMatch(xValues, multipleLinearRegression.getSlopes());
    }
}