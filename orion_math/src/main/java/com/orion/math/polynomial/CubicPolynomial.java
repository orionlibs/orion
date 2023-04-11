package com.orion.math.polynomial;

import com.orion.core.tuple.Triple;
import com.orion.math.number.ANumber;

public class CubicPolynomial extends Polynomial
{
    public CubicPolynomial(ANumber[] coefficients)
    {
        PolynomialRules.isValidCubicPolynomial(coefficients);
        setCoefficients(coefficients);
        setDegree(3);
    }


    public static CubicPolynomial of(ANumber[] coefficients)
    {
        return new CubicPolynomial(coefficients);
    }


    public Triple<ANumber, ANumber, ANumber> getRoots()
    {
        return PolynomialService.getRootsOfCubicPolynomial(this);
    }
}