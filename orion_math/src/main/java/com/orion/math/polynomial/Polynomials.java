package com.orion.math.polynomial;

import com.orion.math.MathRule;
import com.orion.math.number.ANumber;

public class Polynomials extends MathRule
{
    public static boolean isValid(ANumber[] coefficients)
    {
        return coefficients != null && coefficients.length > 0;
    }


    public static boolean isValid(Polynomial polynomial)
    {
        return polynomial != null && isValid(polynomial.getCoefficients());
    }


    public static boolean isNotValid(Polynomial polynomial)
    {
        return !isValid(polynomial);
    }
}