package com.orion.math.statistics.regression.linear.multiple;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;
import com.orion.math.statistics.regression.linear.LinearRegressionService;
import com.orion.math.statistics.regression.linear.multiple.tasks.GetInterceptAndSlopesForMultipleLinearRegressionTask;
import com.orion.math.statistics.regression.linear.multiple.tasks.GetYForMultipleLinearRegressionTask;
import com.orion.math.statistics.regression.linear.multiple.tasks.Prepend1InXValuesOfMultifeatureTrainingSetTask;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;

class MultipleLinearRegressionInternalService extends OrionService
{
    public static MultipleLinearRegressionCoefficients getInterceptAndSlopes(MultifeatureTrainingSet trainingSet)
    {
        return GetInterceptAndSlopesForMultipleLinearRegressionTask.run(trainingSet);
    }


    public static MultifeatureTrainingSet prepend1InXValues(MultifeatureTrainingSet trainingSet)
    {
        return Prepend1InXValuesOfMultifeatureTrainingSetTask.run(trainingSet);
    }


    public static ANumber getY(MultipleLinearRegression regression, Vector xValues)
    {
        return GetYForMultipleLinearRegressionTask.run(regression, xValues);
    }


    public static boolean isThereNoRelationshipBetweenXVectorsAndY(MultipleLinearRegression regression)
    {
        return isThereNoRelationshipBetweenXVectorsAndY(regression, Precision.precision);
    }


    public static boolean isThereNoRelationshipBetweenXVectorsAndY(MultipleLinearRegression regression, int precision)
    {
        Vector slopes = regression.getSlopes().getCopy();
        slopes.forAll(slope -> slope.applyPrecision(precision));
        return !slopes.findAny((ANumber slope) -> slope.isNotZero());
    }


    public static boolean isThereSomeRelationshipBetweenXVectorsAndY(MultipleLinearRegression regression)
    {
        return isThereSomeRelationshipBetweenXVectorsAndY(regression, Precision.precision);
    }


    public static boolean isThereSomeRelationshipBetweenXVectorsAndY(MultipleLinearRegression regression, int precision)
    {
        Vector slopes = regression.getSlopes().getCopy();
        slopes.forAll(slope -> slope.applyPrecision(precision));
        return slopes.findAny((ANumber slope) -> slope.isNotZero());
    }


    public static ANumber getResidualStandardError(MultipleLinearRegression regression)
    {
        ANumber RSS = LinearRegressionService.getResidualSumOfSquares(regression);
        ANumber x = ANumber.of(regression.getNumberOfValues() - regression.getNumberOfFeatures() - 1);
        ANumber RSE = RSS.multiplyGET(x.reciprocateGET());
        return RSE.getSquareRoot();
    }
}