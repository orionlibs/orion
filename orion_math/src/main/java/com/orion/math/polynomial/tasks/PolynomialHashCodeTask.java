package com.orion.math.polynomial.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.PolynomialRules;
import java.util.Arrays;

public class PolynomialHashCodeTask extends Orion
{
    public static int run(Polynomial x)
    {
        PolynomialRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        Number temp = x.getDegree();
        hash = defaultPrimeNumberForHashing * hash + temp.hashCode();
        ANumber[] temp1 = x.getCoefficients();
        return defaultPrimeNumberForHashing * hash + Arrays.hashCode(temp1);
    }
}