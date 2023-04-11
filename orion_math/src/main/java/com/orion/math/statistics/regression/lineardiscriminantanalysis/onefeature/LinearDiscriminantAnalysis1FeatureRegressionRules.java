package com.orion.math.statistics.regression.lineardiscriminantanalysis.onefeature;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.statistics.trainingset.TrainingSetRules;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;

public class LinearDiscriminantAnalysis1FeatureRegressionRules extends MathRule
{
    public static void isValid(UnifeatureTrainingSet trainingSet)
    {
        TrainingSetRules.isValid(trainingSet);
    }


    public static void isValid(LinearDiscriminantAnalysis1FeatureRegression regression)
    {
        Assert.notNull(regression, "The LinearDiscriminantAnalysis1FeatureRegression input cannor be null.");
        isValid(regression.getTrainingSet());
    }
}