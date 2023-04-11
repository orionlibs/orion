package com.orion.math.statistics.regression.linear.simple;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;

public class SimpleLinearRegressionCoefficients extends Orion
{
    private ANumber intercept;
    private ANumber slope;


    public SimpleLinearRegressionCoefficients(ANumber intercept, ANumber slope)
    {
        this.intercept = intercept;
        this.slope = slope;
    }


    public static SimpleLinearRegressionCoefficients of(ANumber intercept, ANumber slope)
    {
        return new SimpleLinearRegressionCoefficients(intercept, slope);
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