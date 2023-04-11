package com.orion.math.number.fraction.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.fraction.Fraction;

public class GetFractionHashCodeTask extends Orion
{
    public static int run(Fraction fraction)
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = (int)(defaultPrimeNumberForHashing * hash + fraction.getNumerator().doubleValue());
        hash = (int)(defaultPrimeNumberForHashing * hash + fraction.getDenominator().doubleValue());
        return hash;
    }
}