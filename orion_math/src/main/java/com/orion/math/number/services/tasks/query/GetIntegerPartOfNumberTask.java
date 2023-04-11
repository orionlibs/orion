package com.orion.math.number.services.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GetIntegerPartOfNumberTask extends Orion
{
    public static Number run(Number x)
    {
        NumberRules.isNotNull(x);

        if(Numbers.isBigInteger(x))
        {
            return x;
        }
        else if(Numbers.isBigDecimal(x))
        {
            return ((BigDecimal)x).setScale(0, RoundingMode.DOWN);
        }

        return null;
    }
}