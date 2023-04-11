package com.orion.math.statistics.regression.linear.simple;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;
import com.orion.math.number.average.AverageService;
import com.orion.math.number.interval.Interval;
import com.orion.math.statistics.StatisticsService;
import com.orion.math.statistics.regression.linear.LinearRegressionService;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleLinearRegression extends Orion
{
    private UnifeatureTrainingSet trainingSet;
    private ANumber intercept;
    private ANumber slope;
    private Line line;


    public SimpleLinearRegression(UnifeatureTrainingSet trainingSet)
    {
        SimpleLinearRegressionRules.isValid(trainingSet);
        this.trainingSet = trainingSet;
        SimpleLinearRegressionCoefficients coefficients = SimpleLinearRegressionInternalService.getInterceptAndSlope(trainingSet);
        this.intercept = coefficients.getIntercept();
        this.slope = coefficients.getSlope();
        this.line = Line.of(slope, intercept);
    }


    public static SimpleLinearRegression of(UnifeatureTrainingSet trainingSet)
    {
        return new SimpleLinearRegression(trainingSet);
    }


    public ANumber getY(ANumber x)
    {
        return getLine().getYUsingSlopeForm(x);
    }


    public ANumber getY(Number x)
    {
        return getY(ANumber.of(x));
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


    public ANumber getStandardError()
    {
        return getVarianceOfXValues();
    }


    public ANumber getStandardErrorOfEstimate()
    {
        return LinearRegressionService.getStandardErrorOfEstimate(this);
    }


    public ANumber getVarianceOfYValues()
    {
        return StatisticsService.getPopulationVariance(getYValuesAsVector());
    }


    public ANumber getStandardDeviationOfXValues()
    {
        return StatisticsService.getSampleStandardDeviation(getXValuesAsVector());
    }


    public ANumber getStandardDeviationOfYValues()
    {
        return StatisticsService.getSampleStandardDeviation(getYValuesAsVector());
    }


    public ANumber getStandardErrorOfIntercept()
    {
        return SimpleLinearRegressionInternalService.getStandardErrorOfIntercept(this);
    }


    public ANumber getStandardErrorOfSlope()
    {
        return SimpleLinearRegressionInternalService.getStandardErrorOfSlope(this);
    }


    public ANumber getResidualSumOfSquares()
    {
        return LinearRegressionService.getResidualSumOfSquares(this);
    }


    public ANumber getRegressionSumOfSquares()
    {
        return LinearRegressionService.getRegressionSumOfSquares(this);
    }


    public ANumber getTotalSumOfSquares()
    {
        return LinearRegressionService.getTotalSumOfSquares(this);
    }


    public ANumber getResidualStandardError()
    {
        return SimpleLinearRegressionInternalService.getResidualStandardError(this);
    }


    public ANumber getErrorSumOfSquares()
    {
        return LinearRegressionService.getErrorSumOfSquares(this);
    }


    public Interval get95PercentConfidenceIntervalForIntercept()
    {
        return SimpleLinearRegressionInternalService.get95PercentConfidenceIntervalForIntercept(this);
    }


    public Interval get95PercentConfidenceIntervalForSlope()
    {
        return SimpleLinearRegressionInternalService.get95PercentConfidenceIntervalForSlope(this);
    }


    public boolean isThereNoRelationshipBetweenXAndY()
    {
        return getSlope().applyPrecisionGET().isZero();
    }


    public boolean isThereNoRelationshipBetweenXAndY(int precision)
    {
        return getSlope().applyPrecisionGET(precision).isZero();
    }


    public boolean testNullHypothesis()
    {
        return isThereNoRelationshipBetweenXAndY();
    }


    public boolean testNullHypothesis(int precision)
    {
        return isThereNoRelationshipBetweenXAndY(precision);
    }


    public boolean isThereSomeRelationshipBetweenXAndY()
    {
        return getSlope().applyPrecisionGET().isNotZero();
    }


    public boolean isThereSomeRelationshipBetweenXAndY(int precision)
    {
        return getSlope().applyPrecisionGET(precision).isNotZero();
    }


    public boolean testAlternativeHypothesis()
    {
        return isThereSomeRelationshipBetweenXAndY();
    }


    public boolean testAlternativeHypothesis(int precision)
    {
        return isThereSomeRelationshipBetweenXAndY(precision);
    }


    public ANumber getTStatistic()
    {
        return getSlope().divideGET(getStandardErrorOfSlope());
    }


    public ANumber getRSquaredStatistic()
    {
        return ANumber.of(1).subtractGET(getResidualSumOfSquares().divideGET(getTotalSumOfSquares()));
    }


    public ANumber getProportionOfVariabilityThatCanBeExplainedByThisRegression()
    {
        return getRSquaredStatistic();
    }


    public boolean doesRegressionExplainMuchOfTheVariabilityInTheOutput()
    {
        return Numbers.isBetween(getRSquaredStatistic(), 0.9, 1);
    }


    public boolean doesRegressionNotExplainMuchOfTheVariabilityInTheOutput()
    {
        return getRSquaredStatistic().isLessThanOrEqual(0.1);
    }


    public ANumber getLeverageStatisticForIndex(int index)
    {
        return SimpleLinearRegressionInternalService.getLeverageStatisticForIndex(this, index);
    }


    public ANumber getCoefficientOfDetermination()
    {
        return getRegressionSumOfSquares().divideGET(getTotalSumOfSquares());
    }


    public ANumber getResidual(int index)
    {
        return LinearRegressionService.getResidual(this, index);
    }


    public ANumber getDurbinWatsonStatistic()
    {
        return LinearRegressionService.getDurbinWatsonStatistic(this);
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


    public Line getLine()
    {
        return this.line;
    }
}