package com.orion.math.number.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.math.BigDecimal;

public class NumberCompareToTask extends Orion
{
    public static int run(ANumber x, ANumber y)
    {
        NumberRules.isNotNull(x);

        if(y == null)
        {
            return 0;
        }
        else
        {

            if(x.isComplexNumber() || y.isComplexNumber())
            {
                BigDecimal thisModulus = x.getModulusAsDecimal();
                BigDecimal otherNumberModulus = y.getModulusAsDecimal();
                return thisModulus.compareTo(otherNumberModulus);
            }
            else if(x.isNegativeInfiniteNumber() && !y.isNegativeInfiniteNumber())
            {
                return -1;
            }
            else if(x.isPositiveInfiniteNumber() && !y.isPositiveInfiniteNumber())
            {
                return 1;
            }
            else
            {
                return x.get().compareTo(y.get());
            }

        }

    }


    public static int run(ANumber x, Number y)
    {
        NumberRules.isNotNull(x);
        return run(x, ANumber.of(y));
    }
}