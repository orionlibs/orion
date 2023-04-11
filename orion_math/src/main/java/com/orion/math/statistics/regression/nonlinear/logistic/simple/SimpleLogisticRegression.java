package com.orion.math.statistics.regression.nonlinear.logistic.simple;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.average.AverageService;
import com.orion.math.statistics.StatisticsService;
import com.orion.math.statistics.regression.nonlinear.logistic.simple.function.LogisticForSimpleRegressionFunction;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleLogisticRegression extends Orion
{
    private UnifeatureTrainingSet trainingSet;
    private ANumber intercept;
    private ANumber slope;


    public SimpleLogisticRegression(UnifeatureTrainingSet trainingSet, Vector probabilitiesNeededToFindIntercept, Vector probabilitiesNeededToFindSlope)
    {
        SimpleLogisticRegressionRules.isValid(trainingSet, probabilitiesNeededToFindIntercept, probabilitiesNeededToFindSlope);
        this.trainingSet = trainingSet;
        SimpleLogisticRegressionCoefficients coefficients = SimpleLogisticRegressionInternalService.getInterceptAndSlope(probabilitiesNeededToFindIntercept, probabilitiesNeededToFindSlope);
        this.intercept = coefficients.getIntercept();
        this.slope = coefficients.getSlope();
    }


    public static SimpleLogisticRegression of(UnifeatureTrainingSet trainingSet, Vector probabilitiesNeededToFindIntercept, Vector probabilitiesNeededToFindSlope)
    {
        return new SimpleLogisticRegression(trainingSet, probabilitiesNeededToFindIntercept, probabilitiesNeededToFindSlope);
    }


    public ANumber getY(ANumber x)
    {
        return LogisticForSimpleRegressionFunction.run(intercept, slope, x);
    }


    public ANumber getY(Number x)
    {
        return LogisticForSimpleRegressionFunction.run(intercept, slope, ANumber.of(x));
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


    public ANumber getVarianceOfYValues()
    {
        return StatisticsService.getPopulationVariance(getYValuesAsVector());
    }


    public ANumber getStandardDeviationOfXValues()
    {
        return StatisticsService.getSampleStandardDeviation(getXValuesAsVector());
    }


    public int getNumberOfValues()
    {
        return getTrainingSet().getSize();
    }


    public ANumber getNumberOfValuesAsNumber()
    {
        return ANumber.of(getNumberOfValues());
    }


    public ANumber getX(int index)
    {
        return getTrainingSet().get(index).getFirst();
    }


    public ANumber getYOfIndex(int index)
    {
        return getTrainingSet().get(index).getSecond();
    }


    public Pair<ANumber, ANumber> get(int index)
    {
        return getTrainingSet().get(index);
    }


    public UnifeatureTrainingSet getTrainingSet()
    {
        return this.trainingSet;
    }


    public ANumber getIntercept()
    {
        return this.intercept;
    }


    public ANumber getSlope()
    {
        return this.slope;
    }
}