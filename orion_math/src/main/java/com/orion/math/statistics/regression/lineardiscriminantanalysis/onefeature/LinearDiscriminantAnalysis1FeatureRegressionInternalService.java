package com.orion.math.statistics.regression.lineardiscriminantanalysis.onefeature;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.regression.lineardiscriminantanalysis.onefeature.tasks.CalculateDiscriminantFunctionsAndGetClassFor1FeatureTask;
import com.orion.math.statistics.regression.lineardiscriminantanalysis.onefeature.tasks.InitialiseParametersForLinearDiscriminantAnalysis1FeatureRegression;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;

class LinearDiscriminantAnalysis1FeatureRegressionInternalService extends OrionService
{
    public static LinearDiscriminantAnalysis1FeatureRegressionParameters initialiseParameters(UnifeatureTrainingSet trainingSet)
    {
        return InitialiseParametersForLinearDiscriminantAnalysis1FeatureRegression.run(trainingSet);
    }


    public static ANumber getY(LinearDiscriminantAnalysis1FeatureRegression regression, ANumber x)
    {
        return CalculateDiscriminantFunctionsAndGetClassFor1FeatureTask.run(regression, x);
    }
}