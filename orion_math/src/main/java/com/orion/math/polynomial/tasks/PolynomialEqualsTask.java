package com.orion.math.polynomial.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.PolynomialRules;
import java.util.Arrays;

public class PolynomialEqualsTask extends Orion
{
    public static boolean run(Polynomial x, Object y)
    {
        PolynomialRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Polynomial other = (Polynomial)y;
            boolean degreesAreEqual = x.getDegree() == other.getDegree();
            boolean coefficientsAreEqual = Arrays.equals(x.getCoefficients(), other.getCoefficients());
            return degreesAreEqual && coefficientsAreEqual;
        }

    }
}