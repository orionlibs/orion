package com.orion.math.statistics.regression.linear.simple.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.error.ErrorService;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.regression.linear.simple.SimpleLinearRegression;
import java.util.stream.IntStream;

public class GetLeverageStatisticForIndexInSimpleLinearRegressionTask extends Orion
{
    public static ANumber run(SimpleLinearRegression regression, int index)
    {
        ANumber oneOverN = ANumber.of(1).divideGET(regression.getNumberOfValues());
        ANumber averageOfXValues = regression.getAverageOfXValues();
        ANumber errorSquared = ErrorService.getErrorSquared(regression.getX(index), averageOfXValues);
        ANumber sum = ANumber.of(0);
        IntStream.range(0, regression.getNumberOfValues())
                        .forEach(i -> sum.add(ErrorService.getErrorSquared(regression.getX(i), averageOfXValues)));
        return oneOverN.addGET(errorSquared.divideGET(sum));
    }
}