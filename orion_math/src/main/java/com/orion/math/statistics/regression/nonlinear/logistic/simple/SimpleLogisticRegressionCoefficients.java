package com.orion.math.statistics.regression.nonlinear.logistic.simple;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;

public class SimpleLogisticRegressionCoefficients extends Orion
{
    private ANumber intercept;
    private ANumber slope;


    public SimpleLogisticRegressionCoefficients(ANumber intercept, ANumber slope)
    {
        this.intercept = intercept;
        this.slope = slope;
    }


    public static SimpleLogisticRegressionCoefficients of(ANumber intercept, ANumber slope)
    {
        return new SimpleLogisticRegressionCoefficients(intercept, slope);
    }


    public ANumber getIntercept()
    {
        return this.intercept;
    }


    public ANumber getSlope()
    {
        return this.slope;
    }
}