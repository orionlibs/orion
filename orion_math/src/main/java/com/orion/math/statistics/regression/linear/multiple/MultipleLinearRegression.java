package com.orion.math.statistics.regression.linear.multiple;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.average.AverageService;
import com.orion.math.statistics.StatisticsService;
import com.orion.math.statistics.regression.linear.LinearRegressionService;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleLinearRegression extends Orion
{
    private MultifeatureTrainingSet trainingSet;
    private ANumber intercept;
    private Vector slopes;


    public MultipleLinearRegression(MultifeatureTrainingSet trainingSet)
    {
        MultipleLinearRegressionRules.isValid(trainingSet);
        this.trainingSet = MultipleLinearRegressionInternalService.prepend1InXValues(trainingSet);
        MultipleLinearRegressionCoefficients coefficients = MultipleLinearRegressionInternalService.getInterceptAndSlopes(trainingSet);
        this.intercept = coefficients.getIntercept();
        this.slopes = coefficients.getSlopes();
    }


    public static MultipleLinearRegression of(MultifeatureTrainingSet trainingSet)
    {
        return new MultipleLinearRegression(trainingSet);
    }


    public ANumber getY(Vector xValues)
    {
        return MultipleLinearRegressionInternalService.getY(this, xValues);
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


    public boolean isThereNoRelationshipBetweenXVectorsAndY()
    {
        return MultipleLinearRegressionInternalService.isThereNoRelationshipBetweenXVectorsAndY(this);
    }


    public boolean isThereNoRelationshipBetweenXVectorsAndY(int precision)
    {
        return MultipleLinearRegressionInternalService.isThereNoRelationshipBetweenXVectorsAndY(this, precision);
    }


    public boolean testNullHypothesis()
    {
        return isThereNoRelationshipBetweenXVectorsAndY();
    }


    public boolean testNullHypothesis(int precision)
    {
        return isThereNoRelationshipBetweenXVectorsAndY(precision);
    }


    public boolean isThereSomeRelationshipBetweenXVectorsAndY()
    {
        return MultipleLinearRegressionInternalService.isThereSomeRelationshipBetweenXVectorsAndY(this);
    }


    public boolean isThereSomeRelationshipBetweenXVectorsAndY(int precision)
    {
        return MultipleLinearRegressionInternalService.isThereSomeRelationshipBetweenXVectorsAndY(this, precision);
    }


    public boolean testAlternativeHypothesis()
    {
        return isThereSomeRelationshipBetweenXVectorsAndY();
    }


    public boolean testAlternativeHypothesis(int precision)
    {
        return isThereSomeRelationshipBetweenXVectorsAndY(precision);
    }


    public int getNumberOfFeatures()
    {
        return getXVector(0).getDimensions();
    }


    public ANumber getNumberOfFeaturesAsNumber()
    {
        return ANumber.of(getNumberOfFeatures());
    }


    public ANumber getFStatistic()
    {
        ANumber totalSumOfSquares = LinearRegressionService.getTotalSumOfSquares(this);
        ANumber residualSumOfSquares = LinearRegressionService.getResidualSumOfSquares(this);
        ANumber p = getNumberOfFeaturesAsNumber();
        ANumber fStatistic = totalSumOfSquares.subtractGET(residualSumOfSquares).divideGET(p);
        return fStatistic.divideGET(residualSumOfSquares.divideGET(getNumberOfValuesAsNumber().subtractGET(p).subtractOneGET()));
    }


    public ANumber getResidualStandardError()
    {
        return MultipleLinearRegressionInternalService.getResidualStandardError(this);
    }


    public ANumber getCoefficientOfDetermination()
    {
        return ANumber.of(1).subtractGET(LinearRegressionService.getResidualSumOfSquares(this).divideGET(LinearRegressionService.getTotalSumOfSquares(this)));
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