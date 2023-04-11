package com.orion.math.number.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;
import java.math.BigDecimal;
import java.math.BigInteger;

public class DoesNumberHaveDecimalValueTask extends Orion
{
    public static boolean run(Object x)
    {

        if(x instanceof BigInteger)
        {
            return false;
        }
        else if(x instanceof BigDecimal)
        {
            BigDecimal temp = (BigDecimal)x;

            if(temp.compareTo(new BigDecimal(temp.toBigInteger())) != 0)
            {
                return true;
            }

        }
        else if(x instanceof Number)
        {
            BigDecimal temp = new BigDecimal(((Number)x).toString());

            if(temp.compareTo(new BigDecimal(temp.toBigInteger())) != 0)
            {
                return true;
            }

        }
        else if(x instanceof ANumber)
        {
            ANumber temp = (ANumber)x;

            if(Numbers.isBigInteger(temp.get()) && Numbers.isBigInteger(temp.getImaginaryValue()))
            {
                return false;
            }
            else if(Numbers.isBigDecimal(temp.get()))
            {
                BigDecimal temp1 = temp.get();
                BigDecimal temp2 = temp.getImaginaryValue();

                if(temp1.compareTo(new BigDecimal(temp1.toBigInteger())) != 0
                                || temp2.compareTo(new BigDecimal(temp2.toBigInteger())) != 0)
                {
                    return true;
                }

            }

        }

        return false;
    }
}