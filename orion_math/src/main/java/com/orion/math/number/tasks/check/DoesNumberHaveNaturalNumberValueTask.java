package com.orion.math.number.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;
import java.math.BigDecimal;
import java.math.BigInteger;

public class DoesNumberHaveNaturalNumberValueTask extends Orion
{
    public static boolean run(Object x)
    {

        if(Numbers.hasIntegerValue(x))
        {

            if(x instanceof BigInteger && Numbers.isPositive((BigInteger)x))
            {
                return true;
            }
            else if(x instanceof BigDecimal)
            {

                if(Numbers.isPositive((BigDecimal)x))
                {
                    return true;
                }

            }
            else if(x instanceof Number)
            {
                BigDecimal temp = new BigDecimal(((Number)x).toString());

                if(Numbers.isPositive(temp))
                {
                    return true;
                }

            }
            else if(x instanceof ANumber)
            {
                ANumber temp = (ANumber)x;

                if(Numbers.isPositive(temp.get()))
                {
                    return true;
                }

            }

            return false;
        }
        else
        {
            return false;
        }

    }
}