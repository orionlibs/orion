package com.orion.math.geometry.trigonometry.tasks.getangle;

import com.orion.core.abstraction.Orion;
import com.orion.math.constant.Constants;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;

public class GetArccosineAsRadiansTask extends Orion
{
    public static ANumber run(ANumber x, int precision)
    {
        NumberRules.isNotNull(x);

        if(x.isNaN())
        {
            return ANumber.of(0);
        }
        else
        {
            NumberRules.isBetween(x, -1, 1);

            if(x.isZero())
            {
                return Constants.halfPI;
            }
            else if(x.isOne())
            {
                return ANumber.of(0);
            }
            else if(x.equal(0.5))
            {
                return Constants.PI.getValue().divideGET(3);
            }

            if(precision <= Precision.precision)
            {
                return ANumber.of(Math.acos(x.applyPrecisionGET(precision).get().doubleValue()));
            }
            else
            {
                ANumber halfPi = Constants.PI.getValue().halfGET();
                return halfPi.subtractGET(run(x, precision));
            }

        }

    }
}