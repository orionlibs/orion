package com.orion.math.polynomial.spline.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.polynomial.spline.PolynomialSpline;
import com.orion.math.polynomial.spline.PolynomialSplineRules;
import java.util.Arrays;

public class PolynomialSplineEqualsTask extends Orion
{
    public static boolean run(PolynomialSpline x, Object y)
    {
        PolynomialSplineRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            PolynomialSpline other = (PolynomialSpline)y;
            return Arrays.equals(x.getPolynomials(), other.getPolynomials())
                            && x.getKnots().equals(other.getKnots());
        }

    }
}