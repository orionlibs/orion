package com.orion.math.statistics.regression.linear.simple.tasks.error;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.StatisticsService;
import com.orion.math.statistics.regression.linear.simple.SimpleLinearRegression;

public class GetStandardErrorOfInterceptInSimpleLinearRegressionTask extends Orion
{
    public static ANumber run(SimpleLinearRegression simpleLinearRegression)
    {
        Assert.notNull(simpleLinearRegression, "The given SimpleLinearRegression input cannot be null.");
        ANumber variance = simpleLinearRegression.getVarianceOfXValues();
        ANumber oneOverN = simpleLinearRegression.getNumberOfValuesAsNumber().reciprocateGET();
        ANumber sumOfSquaredErrors = StatisticsService.getSumOfSquaredDifferencesFromTheMean(simpleLinearRegression.getXValuesAsVector());
        ANumber averageSquared = simpleLinearRegression.getAverageOfXValues().squareGET();
        oneOverN.add(averageSquared.divideGET(sumOfSquaredErrors));
        variance.multiply(oneOverN);
        return variance.getSquareRoot();
    }
}