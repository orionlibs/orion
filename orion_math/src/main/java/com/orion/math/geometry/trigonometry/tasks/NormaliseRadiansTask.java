package com.orion.math.geometry.trigonometry.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.constant.Constants;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class NormaliseRadiansTask extends Orion
{
    public static ANumber run(ANumber x)
    {
        NumberRules.isNotNull(x);

        if(x.isNaN())
        {
            return ANumber.of(0);
        }
        else
        {
            ANumber twoPi = Constants.PI.doubleIt();

            if(x.getAbsoluteValue().isGreaterThan(twoPi))
            {
                return x.getRemainderOfDivision(twoPi);
            }

            return x;
        }

    }
}