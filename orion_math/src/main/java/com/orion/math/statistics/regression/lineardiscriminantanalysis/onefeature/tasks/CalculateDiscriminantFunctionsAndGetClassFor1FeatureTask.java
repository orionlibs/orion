package com.orion.math.statistics.regression.lineardiscriminantanalysis.onefeature.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.statistics.regression.lineardiscriminantanalysis.onefeature.LinearDiscriminantAnalysis1FeatureRegression;

public class CalculateDiscriminantFunctionsAndGetClassFor1FeatureTask extends Orion
{
    public static ANumber run(LinearDiscriminantAnalysis1FeatureRegression regression, ANumber x)
    {
        NumberRules.isNotNull(x);
        ANumber varianceAverage = regression.getWeightedAverageOfDataPointsVariancesForEachClass();
        ANumber maximum = ANumber.ofMin();
        ANumber classForX = ANumber.ofMin();

        for(int i = 0; i < regression.getNumberOfClasses(); i++)
        {
            ANumber average = regression.getAverageOfDataPointsForEachClass(i);
            ANumber a = x.multiplyGET(average).divideGET(varianceAverage);
            a.subtract(average.squareGET().divideGET(varianceAverage.doubleGET()));
            a.add(regression.getProbabilityOfClass(i).getNeperianLogarithm());

            if(a.isGreaterThan(maximum))
            {
                maximum = a;
                classForX = regression.getClassForIndex(i);
            }

        }

        return classForX;
    }
}