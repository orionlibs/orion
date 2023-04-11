package com.orion.math.statistics.regression.nonlinear.logistic.multiple;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.average.AverageService;
import com.orion.math.statistics.StatisticsService;
import com.orion.math.statistics.regression.nonlinear.logistic.multiple.function.LogisticForMultipleRegressionFunction;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleLogisticRegression extends Orion
{
    private MultifeatureTrainingSet trainingSet;
    private ANumber intercept;
    private Vector slopes;


    public MultipleLogisticRegression(MultifeatureTrainingSet trainingSet, Vector probabilitiesNeededToFindIntercept, List<Vector> probabilitiesNeededToFindSlopes)
    {
        MultipleLogisticRegressionRules.isValid(trainingSet, probabilitiesNeededToFindIntercept, probabilitiesNeededToFindSlopes);
        this.trainingSet = trainingSet;
        MultipleLogisticRegressionCoefficients coefficients = MultipleLogisticRegressionInternalService.getInterceptAndSlope(probabilitiesNeededToFindIntercept, probabilitiesNeededToFindSlopes);
        this.intercept = coefficients.getIntercept();
        this.slopes = coefficients.getSlopes();
    }


    public static MultipleLogisticRegression of(MultifeatureTrainingSet trainingSet, Vector probabilitiesNeededToFindIntercept, List<Vector> probabilitiesNeededToFindSlopes)
    {
        return new MultipleLogisticRegression(trainingSet, probabilitiesNeededToFindIntercept, probabilitiesNeededToFindSlopes);
    }


    public ANumber getY(Vector values)
    {
        return LogisticForMultipleRegressionFunction.run(intercept, slopes, values);
    }


    public ANumber getSlope(int index)
    {
        return getSlopes().get(index);
    }


    public List<Vector> getXVectorsAsList()
    {
        return trainingSet.getTrainingSet().stream().map(pair -> pair.getFirst()).collect(Collectors.toList());
    }


    public OrionList<Vector> getXVectorsAsOrionList()
    {
        return OrionArrayList.<Vector>of(getXVectorsAsList());
    }


    public Vector[] getXVectorsAsArray()
    {
        return getXVectorsAsOrionList().getAsArray();
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


    public ANumber getAverageOfYValues()
    {
        return AverageService.getArithmeticAverage(getYValuesAsList());
    }


    public ANumber getVarianceOfYValues()
    {
        return StatisticsService.getPopulationVariance(getYValuesAsVector());
    }


    public ANumber getStandardDeviationOfYValues()
    {
        return StatisticsService.getSampleStandardDeviation(getYValuesAsVector());
    }


    public int getNumberOfValues()
    {
        return getTrainingSet().getSize();
    }


    public ANumber getNumberOfValuesAsNumber()
    {
        return ANumber.of(getNumberOfValues());
    }


    public Vector getXVector(int index)
    {
        return getTrainingSet().get(index).getFirst();
    }


    public ANumber getYForIndex(int index)
    {
        return getTrainingSet().get(index).getSecond();
    }


    public Pair<Vector, ANumber> get(int index)
    {
        return getTrainingSet().get(index);
    }


    public int getNumberOfFeatures()
    {
        return getXVector(0).getDimensions();
    }


    public ANumber getNumberOfFeaturesAsNumber()
    {
        return ANumber.of(getNumberOfFeatures());
    }


    public MultifeatureTrainingSet getTrainingSet()
    {
        return this.trainingSet;
    }


    public ANumber getIntercept()
    {
        return this.intercept;
    }


    public Vector getSlopes()
    {
        return this.slopes;
    }
}