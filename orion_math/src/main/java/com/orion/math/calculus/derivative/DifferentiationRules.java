package com.orion.math.calculus.derivative;

import com.orion.math.MathRule;
import com.orion.math.number.Numbers;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.PolynomialRules;

public class DifferentiationRules extends MathRule
{
    public static void isValid(int orderOfDerivative)
    {

        if(Numbers.hasNotNaturalNumberValue(orderOfDerivative))
        {
            throw new InvalidOrderOfDerivativeException("Order of derivative is not a natural number.");
        }

    }


    public static void isValid(Polynomial polynomial, int orderOfDerivative)
    {
        PolynomialRules.isValid(polynomial);

        if(Numbers.hasNotNaturalNumberValue(orderOfDerivative))
        {
            throw new InvalidOrderOfDerivativeException("Order of derivative is not a natural number.");
        }
        else if(orderOfDerivative > polynomial.getDegree())
        {
            throw new InvalidOrderOfDerivativeException("Order of derivative is greater than the polynomial's degree.");
        }

    }
}