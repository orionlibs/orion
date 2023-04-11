package com.orion.math.error;

import com.orion.core.abstraction.OrionService;
import com.orion.math.error.tasks.GetSumOfSquaredErrorsTask;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.statistics.StatisticsService;

public class ErrorService extends OrionService
{
    public static ANumber getError(ANumber realValue, ANumber approximateValue)
    {
        NumberRules.areNotNull(realValue, approximateValue);
        return approximateValue.subtractGET(realValue);
    }


    public static ANumber getError(Number realValue, Number approximateValue)
    {
        NumberRules.areNotNull(realValue, approximateValue);
        return getError(ANumber.of(realValue), ANumber.of(approximateValue));
    }


    public static ANumber getErrorSquared(ANumber realValue, ANumber approximateValue)
    {
        NumberRules.areNotNull(realValue, approximateValue);
        return approximateValue.subtractGET(realValue).squareGET();
    }


    public static ANumber getErrorSquared(Number realValue, Number approximateValue)
    {
        NumberRules.areNotNull(realValue, approximateValue);
        return getErrorSquared(ANumber.of(realValue), ANumber.of(approximateValue));
    }


    public static ANumber getSumOfSquaredErrors(Vector realValues, Vector approximateValues)
    {
        return GetSumOfSquaredErrorsTask.run(realValues, approximateValues);
    }


    public static ANumber getSumOfSquaredErrors(ANumber x, Vector approximateValues)
    {
        return GetSumOfSquaredErrorsTask.run(x, approximateValues);
    }


    public static ANumber getAbsoluteError(ANumber realValue, ANumber approximateValue)
    {
        NumberRules.areNotNull(realValue, approximateValue);
        return getError(realValue, approximateValue).getAbsoluteValue();
    }


    public static ANumber getAbsoluteError(Number realValue, Number approximateValue)
    {
        NumberRules.areNotNull(realValue, approximateValue);
        return getAbsoluteError(ANumber.of(realValue), ANumber.of(approximateValue));
    }


    public static ANumber getRelativeError(ANumber realValue, ANumber approximateValue)
    {
        NumberRules.areNotNull(realValue, approximateValue);
        return ANumber.of(1).subtractGET(approximateValue.divideGET(realValue)).getAbsoluteValue();
    }


    public static ANumber getRelativeError(Number realValue, Number approximateValue)
    {
        NumberRules.areNotNull(realValue, approximateValue);
        return getRelativeError(ANumber.of(realValue), ANumber.of(approximateValue));
    }


    public static ANumber getPercentError(ANumber realValue, ANumber approximateValue)
    {
        return getRelativeError(realValue, approximateValue).multiplyGET(100);
    }


    public static ANumber getPercentError(Number realValue, Number approximateValue)
    {
        NumberRules.areNotNull(realValue, approximateValue);
        return getPercentError(ANumber.of(realValue), ANumber.of(approximateValue));
    }


    public static ANumber getMeanSquaredError(Vector realValues, Vector approximateValues)
    {
        return StatisticsService.getExpectedValueOfSquaredDifferences(realValues, approximateValues);
    }
}