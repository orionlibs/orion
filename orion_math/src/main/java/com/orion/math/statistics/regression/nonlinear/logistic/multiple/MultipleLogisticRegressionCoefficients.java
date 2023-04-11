package com.orion.math.statistics.regression.nonlinear.logistic.multiple;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;

public class MultipleLogisticRegressionCoefficients extends Orion
{
    private ANumber intercept;
    private Vector slopes;


    public MultipleLogisticRegressionCoefficients(ANumber intercept, Vector slopes)
    {
        this.intercept = intercept;
        this.slopes = slopes;
    }


    public static MultipleLogisticRegressionCoefficients of(ANumber intercept, Vector slopes)
    {
        return new MultipleLogisticRegressionCoefficients(intercept, slopes);
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