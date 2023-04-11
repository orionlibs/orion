package com.orion.math.polynomial;

import com.orion.core.tuple.Quadruple;
import com.orion.math.number.ANumber;

public class QuarticPolynomial extends Polynomial
{
    public QuarticPolynomial(ANumber[] coefficients)
    {
        PolynomialRules.isValidQuarticPolynomial(coefficients);
        setCoefficients(coefficients);
        setDegree(4);
    }


    public static QuarticPolynomial of(ANumber[] coefficients)
    {
        return new QuarticPolynomial(coefficients);
    }


    public Quadruple<ANumber, ANumber, ANumber, ANumber> getRoots()
    {
        return PolynomialService.getRootsOfQuarticPolynomial(this);
    }
}