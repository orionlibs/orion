package com.orion.math.statistics.regression.lineardiscriminantanalysis.onefeature;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import java.util.List;

public class LinearDiscriminantAnalysis1FeatureRegressionParameters extends Orion
{
    private List<ANumber> averagesOfDataPointsForEachClass;
    private ANumber weightedAverageOfDataPointsVariancesForEachClass;
    private List<ANumber> probabilityOfEachClass;


    public LinearDiscriminantAnalysis1FeatureRegressionParameters(List<ANumber> averagesOfDataPointsForEachClass, ANumber weightedAverageOfDataPointsVariancesForEachClass, List<ANumber> probabilityOfEachClass)
    {
        this.averagesOfDataPointsForEachClass = averagesOfDataPointsForEachClass;
        this.weightedAverageOfDataPointsVariancesForEachClass = weightedAverageOfDataPointsVariancesForEachClass;
        this.probabilityOfEachClass = probabilityOfEachClass;
    }


    public static LinearDiscriminantAnalysis1FeatureRegressionParameters of(List<ANumber> averagesOfDataPointsForEachClass, ANumber weightedAverageOfDataPointsVariancesForEachClass, List<ANumber> probabilityOfEachClass)
    {
        return new LinearDiscriminantAnalysis1FeatureRegressionParameters(averagesOfDataPointsForEachClass, weightedAverageOfDataPointsVariancesForEachClass, probabilityOfEachClass);
    }


    public List<ANumber> getAveragesOfDataPointsForEachClass()
    {
        return this.averagesOfDataPointsForEachClass;
    }


    public ANumber getWeightedAverageOfDataPointsVariancesForEachClass()
    {
        return this.weightedAverageOfDataPointsVariancesForEachClass;
    }


    public List<ANumber> getProbabilityOfEachClass()
    {
        return this.probabilityOfEachClass;
    }
}