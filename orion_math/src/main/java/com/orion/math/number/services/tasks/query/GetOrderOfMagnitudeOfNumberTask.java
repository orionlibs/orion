package com.orion.math.number.services.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetOrderOfMagnitudeOfNumberTask extends Orion
{
    public static ANumber run(ANumber x)
    {
        NumberRules.isNotNull(x);
        ANumber y = x.getAbsoluteValue();

        if(y.isLessThan(10))
        {
            return ANumber.of(0);
        }
        else if(y.equal(10))
        {
            return ANumber.of(1);
        }
        else
        {
            int powerOfTen = 0;

            while(y.isGreaterThan(10))
            {
                y.divide(10);
                ++powerOfTen;
            }

            return ANumber.of(powerOfTen);
        }

    }
}