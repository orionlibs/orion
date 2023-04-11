package com.orion.math.number.arithmetic.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;

public class GetAbsoluteValueOfNumberTask extends Orion
{
    public static ANumber run(ANumber x)
    {
        NumberRules.isNotNull(x);

        if(Numbers.isZero(x.get()))
        {
            return ANumber.of(x.getImaginaryValue().abs());
        }
        else if(Numbers.isZero(x.getImaginaryValue()))
        {
            return ANumber.of(x.get().abs());
        }
        else
        {
            return x.getModulus();
        }

    }
}