package com.orion.math.polynomial.spline;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.spline.tasks.GetValueForPolynomialSplineTask;

public class PolynomialSplineService extends OrionService
{
    public static ANumber getValueFor(PolynomialSpline polynomial, ANumber x)
    {
        return GetValueForPolynomialSplineTask.run(polynomial, x);
    }
}