package com.orion.math.statistics.regression.linear.tasks.sum;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.math.error.ErrorService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.regression.linear.multiple.MultipleLinearRegression;
import com.orion.math.statistics.regression.linear.simple.SimpleLinearRegression;
import java.util.stream.IntStream;

public class GetResidualSumOfSquaresTask extends Orion
{
    public static ANumber run(SimpleLinearRegression regression)
    {
        Assert.notNull(regression, "The given SimpleLinearRegression input cannot be null.");
        Vector xValues = regression.getXValuesAsVector();
        Vector yValues = regression.getYValuesAsVector();
        Vector approximateYValues = Vector.of(xValues.getDimensions());
        IntStream.range(0, xValues.getDimensions())
                        .forEach(i -> approximateYValues.set(i, regression.getY(xValues.get(i))));
        return ErrorService.getSumOfSquaredErrors(yValues, approximateYValues);
    }


    public static ANumber run(MultipleLinearRegression regression)
    {
        Assert.notNull(regression, "The given SimpleLinearRegression input cannot be null.");
        Vector[] xVectors = regression.getXVectorsAsArray();
        Vector yValues = regression.getYValuesAsVector();
        Vector approximateYValues = Vector.of(regression.getNumberOfValues());
        IntStream.range(0, regression.getNumberOfValues())
                        .forEach(i -> approximateYValues.set(i, regression.getY(xVectors[i])));
        return ErrorService.getSumOfSquaredErrors(yValues, approximateYValues);
    }
}