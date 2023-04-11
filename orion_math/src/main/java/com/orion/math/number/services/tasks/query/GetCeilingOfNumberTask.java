package com.orion.math.number.services.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import java.math.RoundingMode;

public class GetCeilingOfNumberTask extends Orion
{
    public static ANumber run(ANumber x)
    {
        NumberRules.isNotNull(x);

        if(x.getPrecision() <= Precision.precision)
        {
            return ANumber.of(Math.ceil(x.get().doubleValue()));
        }
        else
        {
            return ANumber.of(x.getAsDecimalCopy().setScale(0, RoundingMode.CEILING));
        }

    }
}