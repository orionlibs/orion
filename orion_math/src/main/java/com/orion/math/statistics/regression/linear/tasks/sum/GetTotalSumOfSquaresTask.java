package com.orion.math.statistics.regression.linear.tasks.sum;

import com.orion.core.abstraction.Orion;
import com.orion.math.error.ErrorService;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.regression.linear.multiple.MultipleLinearRegression;
import com.orion.math.statistics.regression.linear.simple.SimpleLinearRegression;
import java.util.stream.IntStream;

public class GetTotalSumOfSquaresTask extends Orion
{
    public static ANumber run(SimpleLinearRegression regression)
    {
        ANumber averageOfYValues = regression.getAverageOfYValues();
        ANumber sum = ANumber.of(0);
        IntStream.range(0, regression.getNumberOfValues())
                        .forEach(i -> sum.add(ErrorService.getErrorSquared(regression.getY(i), averageOfYValues)));
        return sum;
    }


    public static ANumber run(MultipleLinearRegression regression)
    {
        ANumber averageOfYValues = regression.getAverageOfYValues();
        ANumber sum = ANumber.of(0);
        IntStream.range(0, regression.getNumberOfValues())
                        .forEach(i -> sum.add(ErrorService.getErrorSquared(regression.getYForIndex(i), averageOfYValues)));
        return sum;
    }
}