package com.orion.math.statistics.regression.linear;

import com.orion.core.abstraction.OrionService;
import com.orion.core.exception.Assert;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.regression.linear.multiple.MultipleLinearRegression;
import com.orion.math.statistics.regression.linear.simple.SimpleLinearRegression;
import com.orion.math.statistics.regression.linear.tasks.GetDurbinWatsonStatisticTask;
import com.orion.math.statistics.regression.linear.tasks.GetRegressionSumOfSquaresTask;
import com.orion.math.statistics.regression.linear.tasks.sum.GetResidualSumOfSquaresTask;
import com.orion.math.statistics.regression.linear.tasks.sum.GetTotalSumOfSquaresTask;

public class LinearRegressionService extends OrionService
{
    public static ANumber getTotalSumOfSquares(SimpleLinearRegression regression)
    {
        return GetTotalSumOfSquaresTask.run(regression);
    }


    public static ANumber getTotalSumOfSquares(MultipleLinearRegression regression)
    {
        return GetTotalSumOfSquaresTask.run(regression);
    }


    public static ANumber getResidualSumOfSquares(SimpleLinearRegression regression)
    {
        return GetResidualSumOfSquaresTask.run(regression);
    }


    public static ANumber getRegressionSumOfSquares(SimpleLinearRegression regression)
    {
        return GetRegressionSumOfSquaresTask.run(regression);
    }


    public static ANumber getResidualSumOfSquares(MultipleLinearRegression regression)
    {
        return GetResidualSumOfSquaresTask.run(regression);
    }


    public static ANumber getErrorSumOfSquares(SimpleLinearRegression regression)
    {
        return getResidualSumOfSquares(regression);
    }


    public static ANumber getStandardErrorOfEstimate(SimpleLinearRegression regression)
    {
        Assert.notNull(regression, "The given SimpleLinearRegression input cannot be null.");
        return regression.getErrorSumOfSquares().divideGET(regression.getNumberOfValues() - 2);
    }


    public static ANumber getResidual(SimpleLinearRegression regression, int index)
    {
        Assert.notNull(regression, "The given SimpleLinearRegression input cannot be null.");
        return regression.getYOfIndex(index).subtractGET(regression.getY(regression.getX(index)));
    }


    public static ANumber getDurbinWatsonStatistic(SimpleLinearRegression regression)
    {
        return GetDurbinWatsonStatisticTask.run(regression);
    }
}