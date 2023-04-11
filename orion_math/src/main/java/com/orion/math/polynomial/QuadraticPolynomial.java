package com.orion.math.polynomial;

import com.orion.core.tuple.Pair;
import com.orion.math.number.ANumber;

public class QuadraticPolynomial extends Polynomial
{
    public QuadraticPolynomial(ANumber[] coefficients)
    {
        PolynomialRules.isValidQuadraticPolynomial(coefficients);
        setCoefficients(coefficients);
        setDegree(2);
    }


    public static QuadraticPolynomial of(ANumber[] coefficients)
    {
        return new QuadraticPolynomial(coefficients);
    }


    public Pair<ANumber, ANumber> getRoots()
    {
        return PolynomialService.getRootsOfQuadraticPolynomial(this);
    }
}