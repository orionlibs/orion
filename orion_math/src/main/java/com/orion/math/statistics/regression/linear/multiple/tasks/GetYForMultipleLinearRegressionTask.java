package com.orion.math.statistics.regression.linear.multiple.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.regression.linear.multiple.MultipleLinearRegression;
import com.orion.math.statistics.regression.linear.multiple.MultipleLinearRegressionRules;
import java.util.stream.IntStream;

public class GetYForMultipleLinearRegressionTask extends Orion
{
    public static ANumber run(MultipleLinearRegression regression, Vector xValues)
    {
        MultipleLinearRegressionRules.doSizesMatch(regression, xValues);
        ANumber y = regression.getIntercept();
        IntStream.range(0, regression.getSlopes().getDimensions())
                        .forEach(i -> y.add(regression.getSlope(i).multiplyGET(xValues.get(i))));
        return y;
    }
}