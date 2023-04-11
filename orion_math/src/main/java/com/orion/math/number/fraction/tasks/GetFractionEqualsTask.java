package com.orion.math.number.fraction.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.fraction.Fraction;

public class GetFractionEqualsTask extends Orion
{
    public static boolean run(Fraction fraction, Object object)
    {

        if(object == null || object.getClass() != fraction.getClass())
        {
            return false;
        }
        else
        {
            Fraction otherFraction = (Fraction)object;

            if(fraction.getNumerator().compareTo(otherFraction.getNumerator()) == 0
                            && fraction.getDenominator().compareTo(otherFraction.getDenominator()) == 0)
            {
                return true;
            }

        }

        return false;
    }
}