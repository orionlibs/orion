package com.orion.math.polynomial;

import com.orion.math.number.ANumber;

public class LinearPolynomial extends Polynomial
{
    public LinearPolynomial(ANumber[] coefficients)
    {
        PolynomialRules.isValidLinearPolynomial(coefficients);
        setCoefficients(coefficients);
        setDegree(1);
    }


    public static LinearPolynomial of(ANumber[] coefficients)
    {
        return new LinearPolynomial(coefficients);
    }


    public ANumber getRoot()
    {
        return PolynomialService.getRootOfLinearPolynomial(this);
    }
}