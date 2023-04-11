package com.orion.math.polynomial.spline;

import com.orion.math.MathObject;
import com.orion.math.polynomial.spline.tasks.PolynomialSplineEqualsTask;
import com.orion.math.polynomial.spline.tasks.PolynomialSplineHashCodeTask;

class PolynomialSplineInternalService implements MathObject
{
    static boolean equals(PolynomialSpline x, Object y)
    {
        return PolynomialSplineEqualsTask.run(x, y);
    }


    static int hashCode(PolynomialSpline x)
    {
        return PolynomialSplineHashCodeTask.run(x);
    }
}