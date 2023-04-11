package com.orion.math.statistics.regression.linear.simple.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.math.number.ANumber;
import com.orion.math.number.average.AverageService;
import com.orion.math.statistics.regression.linear.simple.SimpleLinearRegressionCoefficients;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;
import java.util.List;
import java.util.stream.Collectors;

public class GetInterceptAndSlopeForSimpleLinearRegressionTask extends Orion
{
    public static SimpleLinearRegressionCoefficients run(UnifeatureTrainingSet trainingSet)
    {
        Assert.notNull(trainingSet, "The given UnifeatureTrainingSet input cannot be null.");
        List<ANumber> xValues = trainingSet.getTrainingSet().stream().map(pair -> pair.getFirst()).collect(Collectors.toList());
        List<ANumber> yValues = trainingSet.getTrainingSet().stream().map(pair -> pair.getSecond()).collect(Collectors.toList());
        ANumber averageOfXValues = AverageService.getArithmeticAverage(xValues);
        ANumber averageOfYValues = AverageService.getArithmeticAverage(yValues);
        ANumber slope = ANumber.of(0);
        ANumber xDifferenceSquared = ANumber.of(0);

        for(int i = 0; i < xValues.size(); i++)
        {
            ANumber xDifference = xValues.get(i).subtractGET(averageOfXValues);
            slope.add(xDifference.multiplyGET(yValues.get(i).subtractGET(averageOfYValues)));
            xDifferenceSquared.add(xDifference.squareGET());
        }

        slope.divide(xDifferenceSquared);
        ANumber intercept = averageOfYValues.subtractGET(slope.multiplyGET(averageOfXValues));
        return SimpleLinearRegressionCoefficients.of(intercept, slope);
    }
}