package com.orion.math.polynomial.spline;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.PolynomialRules;

public class PolynomialSplineRules extends MathRule
{
    public static void isValuewithinInterval(PolynomialSpline polynomialSpline, ANumber x)
    {
        NumberRules.isNotNull(x);
        Assert.isFalse(Numbers.isNotBetween(x, polynomialSpline.getIntervalMinimum(), polynomialSpline.getIntervalMaximum()), "Value is not within the PolynomialSpline interval.");
    }


    public static void isValid(Polynomial[] polynomials, Vector knots)
    {
        PolynomialRules.areValid(polynomials);
        VectorRules.isValid(knots);
    }


    public static void isValid(PolynomialSpline polynomialSpline)
    {
        Assert.notNull(polynomialSpline, "The polynomialSpline input cannot be null.");
        isValid(polynomialSpline.getPolynomials(), polynomialSpline.getKnots());
    }
}