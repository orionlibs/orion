package com.orion.math.statistics.regression.linear.simple;

import com.orion.core.abstraction.OrionService;
import com.orion.core.exception.Assert;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;
import com.orion.math.statistics.StatisticsService;
import com.orion.math.statistics.regression.linear.LinearRegressionService;
import com.orion.math.statistics.regression.linear.simple.tasks.GetInterceptAndSlopeForSimpleLinearRegressionTask;
import com.orion.math.statistics.regression.linear.simple.tasks.GetLeverageStatisticForIndexInSimpleLinearRegressionTask;
import com.orion.math.statistics.regression.linear.simple.tasks.error.GetStandardErrorOfInterceptInSimpleLinearRegressionTask;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;

class SimpleLinearRegressionInternalService extends OrionService
{
    public static SimpleLinearRegressionCoefficients getInterceptAndSlope(UnifeatureTrainingSet trainingSet)
    {
        return GetInterceptAndSlopeForSimpleLinearRegressionTask.run(trainingSet);
    }


    public static ANumber getStandardErrorOfIntercept(SimpleLinearRegression regression)
    {
        return GetStandardErrorOfInterceptInSimpleLinearRegressionTask.run(regression);
    }


    public static ANumber getStandardErrorOfSlope(SimpleLinearRegression regression)
    {
        Assert.notNull(regression, "The given SimpleLinearRegression input cannot be null.");
        ANumber variance = regression.getVarianceOfXValues();
        ANumber sumOfSquaredErrors = StatisticsService.getSumOfSquaredDifferencesFromTheMean(regression.getXValuesAsVector());
        return variance.divideGET(sumOfSquaredErrors).getSquareRoot();
    }


    public static ANumber getResidualStandardError(SimpleLinearRegression regression)
    {
        return LinearRegressionService.getResidualSumOfSquares(regression).divideGET(regression.getNumberOfValues() - 2).getSquareRoot();
    }


    public static Interval get95PercentConfidenceIntervalForIntercept(SimpleLinearRegression regression)
    {
        ANumber twoStandardErrorOfIntercept = regression.getStandardErrorOfIntercept().doubleGET();
        ANumber leftEndpoint = regression.getIntercept().subtractGET(twoStandardErrorOfIntercept);
        ANumber rightEndpoint = regression.getIntercept().addGET(twoStandardErrorOfIntercept);
        return Interval.of(leftEndpoint, rightEndpoint);
    }


    public static Interval get95PercentConfidenceIntervalForSlope(SimpleLinearRegression regression)
    {
        ANumber twoStandardErrorOfSlope = regression.getStandardErrorOfSlope().doubleGET();
        ANumber leftEndpoint = regression.getSlope().subtractGET(twoStandardErrorOfSlope);
        ANumber rightEndpoint = regression.getSlope().addGET(twoStandardErrorOfSlope);
        return Interval.of(leftEndpoint, rightEndpoint);
    }


    public static ANumber getLeverageStatisticForIndex(SimpleLinearRegression regression, int index)
    {
        return GetLeverageStatisticForIndexInSimpleLinearRegressionTask.run(regression, index);
    }
}