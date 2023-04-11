package com.orion.math.polynomial.spline.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.polynomial.spline.PolynomialSpline;
import com.orion.math.polynomial.spline.PolynomialSplineRules;
import java.util.Arrays;

public class PolynomialSplineHashCodeTask extends Orion
{
    public static int run(PolynomialSpline x)
    {
        PolynomialSplineRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + Arrays.hashCode(x.getPolynomials());
        return defaultPrimeNumberForHashing * hash + x.getKnots().hashCode();
    }
}