package com.orion.math.number.fraction.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.fraction.Fraction;

public class FractionCompareToAnotherTask extends Orion
{
    public static int run(Fraction fraction, Fraction other)
    {

        if(other == null)
        {
            return -1;
        }
        else if(fraction.getValue().compareTo(other.getValue()) < 0)
        {
            return -1;
        }
        else if(fraction.getValue().compareTo(other.getValue()) == 0)
        {
            return 0;
        }
        else if(fraction.getValue().compareTo(other.getValue()) > 0)
        {
            return 1;
        }

        return 0;
    }
}