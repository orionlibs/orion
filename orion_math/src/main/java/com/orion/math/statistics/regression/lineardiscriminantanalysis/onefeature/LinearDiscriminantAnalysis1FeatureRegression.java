package com.orion.math.statistics.regression.lineardiscriminantanalysis.onefeature;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.average.AverageService;
import com.orion.math.statistics.StatisticsService;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;
import java.util.List;
import java.util.stream.Collectors;

public class LinearDiscriminantAnalysis1FeatureRegression extends Orion
{
    private UnifeatureTrainingSet trainingSet;
    private List<ANumber> averagesOfDataPointsForEachClass;
    private ANumber weightedAverageOfDataPointsVariancesForEachClass;
    private List<ANumber> probabilityOfEachClass;


    public LinearDiscriminantAnalysis1FeatureRegression(UnifeatureTrainingSet trainingSet)
    {
        LinearDiscriminantAnalysis1FeatureRegressionRules.isValid(trainingSet);
        this.trainingSet = trainingSet;
        LinearDiscriminantAnalysis1FeatureRegressionParameters parameters = LinearDiscriminantAnalysis1FeatureRegressionInternalService.initialiseParameters(trainingSet);
        this.averagesOfDataPointsForEachClass = parameters.getAveragesOfDataPointsForEachClass();
        this.weightedAverageOfDataPointsVariancesForEachClass = parameters.getWeightedAverageOfDataPointsVariancesForEachClass();
        this.probabilityOfEachClass = parameters.getProbabilityOfEachClass();
    }


    public static LinearDiscriminantAnalysis1FeatureRegression of(UnifeatureTrainingSet trainingSet)
    {
        return new LinearDiscriminantAnalysis1FeatureRegression(trainingSet);
    }


    public ANumber getY(ANumber x)
    {
        return LinearDiscriminantAnalysis1FeatureRegressionInternalService.getY(this, x);
    }


    public List<ANumber> getClasses()
    {
        return getTrainingSet().getClasses();
    }


    public int getNumberOfClasses()
    {
        return getClasses().size();
    }


    public ANumber getAverageOfDataPointsForEachClass(int index)
    {
        return getAveragesOfDataPointsForEachClass().get(index);
    }


    public ANumber getProbabilityOfClass(int index)
    {
        return getProbabilityOfEachClass().get(index);
    }


    public ANumber getClassForIndex(int index)
    {
        return getClasses().get(index);
    }


    public List<ANumber> getXValuesAsList()
    {
        return trainingSet.getTrainingSet().stream().map(pair -> pair.getFirst()).collect(Collectors.toList());
    }


    public OrionList<ANumber> getXValuesAsOrionList()
    {
        return OrionArrayList.<ANumber>of(getXValuesAsList());
    }


    public ANumber[] getXValuesAsArray()
    {
        return getXValuesAsOrionList().getAsArray();
    }


    public Vector getXValuesAsVector()
    {
        return Vector.of(getXValuesAsOrionList());
    }


    public List<ANumber> getYValuesAsList()
    {
        return trainingSet.getTrainingSet().stream().map(pair -> pair.getSecond()).collect(Collectors.toList());
    }


    public OrionList<ANumber> getYValuesAsOrionList()
    {
        return OrionArrayList.<ANumber>of(getYValuesAsList());
    }


    public ANumber[] getYValuesAsArray()
    {
        return getYValuesAsOrionList().getAsArray();
    }


    public Vector getYValuesAsVector()
    {
        return Vector.of(getYValuesAsOrionList());
    }


    public ANumber getAverageOfXValues()
    {
        return AverageService.getArithmeticAverage(getXValuesAsList());
    }


    public ANumber getAverageOfYValues()
    {
        return AverageService.getArithmeticAverage(getYValuesAsList());
    }


    public ANumber getVarianceOfXValues()
    {
        return StatisticsService.getPopulationVariance(getXValuesAsVector());
    }


    public int getNumberOfValues()
    {
        return getTrainingSet().getSize();
    }


    public ANumber getNumberOfValuesAsNumber()
    {
        return ANumber.of(getNumberOfValues());
    }


    public UnifeatureTrainingSet getTrainingSet()
    {
        return this.trainingSet;
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