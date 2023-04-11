package com.orion.math.number.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.Numbers;
import java.math.BigDecimal;
import java.math.BigInteger;

public class IsNumberMinusOneTask extends Orion
{
    public static boolean run(Number x)
    {

        if(Numbers.isBigInteger(x))
        {
            return ((BigInteger)x).compareTo(BigInteger.valueOf(-1)) == 0;
        }
        else if(Numbers.isBigDecimal(x))
        {
            return ((BigDecimal)x).compareTo(BigDecimal.valueOf(-1)) == 0;
        }

        return false;
    }
}