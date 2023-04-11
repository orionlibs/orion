package com.orion.math.statistics.regression.linear.multiple;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;

public class MultipleLinearRegressionCoefficients extends Orion
{
    private ANumber intercept;
    private Vector slopes;


    public MultipleLinearRegressionCoefficients(ANumber intercept, Vector slopes)
    {
        this.intercept = intercept;
        this.slopes = slopes;
    }


    public static MultipleLinearRegressionCoefficients of(ANumber intercept, Vector slopes)
    {
        return new MultipleLinearRegressionCoefficients(intercept, slopes);
    }


    public ANumber getIntercept()
    {
        return this.intercept;
    }


    public Vector getSlopes()
    {
        return this.slopes;
    }
}