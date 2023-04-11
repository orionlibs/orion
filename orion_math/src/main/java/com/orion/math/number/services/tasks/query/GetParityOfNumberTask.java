package com.orion.math.number.services.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetParityOfNumberTask extends Orion
{
    public static boolean run(ANumber x)
    {
        NumberRules.hasNaturalNumberValue(x);
        boolean parity = false;
        int y = x.getAsInt();

        while(y != 0)
        {
            parity = !parity;
            y = y & (y - 1);
        }

        return parity;
    }
}