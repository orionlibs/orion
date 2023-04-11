package com.orion.math.polynomial;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import java.util.Arrays;
import java.util.List;

public class PolynomialRules extends MathRule
{
    public static void isValidDegree(Polynomial polynomial, int degree)
    {
        isValid(polynomial);
        Assert.isNonNegative(degree, "Degree is not within the range.");
    }


    public static void isNotZero(Polynomial polynomial)
    {
        isValid(polynomial);
        Assert.isFalse(PolynomialService.isZero(polynomial), "Polynomial is zero.");
    }


    public static void doDegreesMatch(Polynomial polynomial1, Polynomial polynomial2)
    {
        isValid(polynomial1);
        isValid(polynomial2);
        Assert.areEqual(polynomial1.getDegree(), polynomial2.getDegree(), "Polynomial degrees do not match.");
    }


    public static void doDegreesMatch(Polynomial polynomial1, Polynomial[] polynomials)
    {
        isValid(polynomial1);
        areValid(polynomials);

        for(int i = 0; i < polynomials.length; i++)
        {
            Assert.areEqual(polynomial1.getDegree(), polynomials[i].getDegree(), "Polynomial degrees do not match.");
        }

    }


    public static void doDegreesMatch(Polynomial polynomial1, List<Polynomial> polynomials)
    {
        isValid(polynomial1);
        areValid(polynomials);

        for(int i = 0; i < polynomials.size(); i++)
        {
            Assert.areEqual(polynomial1.getDegree(), polynomials.get(i).getDegree(), "Polynomial degrees do not match.");
        }

    }


    public static void isValid(ANumber[] coefficients)
    {
        Assert.notEmpty(coefficients, "Polynomial component(s) is/are empty.");
    }


    public static void isValid(Vector coefficients)
    {
        Assert.notNull(coefficients, "Polynomial component(s) is/are empty.");
        Assert.isFalse(coefficients.isEmpty(), "Polynomial component(s) is/are empty.");
    }


    public static void isValid(List<ANumber> coefficients)
    {
        Assert.notNull(coefficients, "Polynomial component(s) is/are empty.");
        Assert.isFalse(coefficients.isEmpty(), "Polynomial component(s) is/are empty.");
    }


    public static void isValidLinearPolynomial(ANumber[] coefficients)
    {
        isValid(coefficients);
        Assert.areEqual(coefficients.length, 2, "Linear polynomial has to have 2 components.");
    }


    public static void isValidQuadraticPolynomial(ANumber[] coefficients)
    {
        isValid(coefficients);
        Assert.areEqual(coefficients.length, 3, "Quadratic polynomial has to have 3 components.");
    }


    public static void isValidCubicPolynomial(ANumber[] coefficients)
    {
        isValid(coefficients);
        Assert.areEqual(coefficients.length, 4, "Cubic polynomial has to have 4 components.");
    }


    public static void isValidQuarticPolynomial(ANumber[] coefficients)
    {
        isValid(coefficients);
        Assert.areEqual(coefficients.length, 5, "Quartic polynomial has to have 5 components.");
    }


    public static void isValid(Polynomial polynomial)
    {
        Assert.notNull(polynomial, "The polynomial input cannot be null.");
        isValid(polynomial.getCoefficients());
    }


    public static void areValid(Polynomial... polynomials)
    {
        Assert.notNull(polynomials, "The polynomial input cannot be null.");
        Arrays.stream(polynomials).forEach(p -> isValid(p));
    }


    public static void areValid(List<Polynomial> polynomials)
    {
        Assert.notNull(polynomials, "The polynomial input cannot be null.");
        polynomials.stream().forEach(p -> isValid(p));
    }
}