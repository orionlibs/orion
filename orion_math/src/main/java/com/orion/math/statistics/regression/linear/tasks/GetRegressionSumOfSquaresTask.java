package com.orion.math.statistics.regression.linear.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.error.ErrorService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.regression.linear.simple.SimpleLinearRegression;
import java.util.stream.IntStream;

public class GetRegressionSumOfSquaresTask extends Orion
{
    public static ANumber run(SimpleLinearRegression regression)
    {
        Vector xValues = regression.getXValuesAsVector();
        ANumber averageOfYValues = regression.getAverageOfYValues();
        Vector approximateYValues = Vector.of(xValues.getDimensions());
        IntStream.range(0, xValues.getDimensions())
                        .forEach(i -> approximateYValues.set(i, regression.getY(xValues.get(i))));
        return ErrorService.getSumOfSquaredErrors(averageOfYValues, approximateYValues);
    }
}