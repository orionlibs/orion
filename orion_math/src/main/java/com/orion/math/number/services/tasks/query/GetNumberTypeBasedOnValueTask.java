package com.orion.math.number.services.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.NumberRules;
import com.orion.math.number.NumberType;
import com.orion.math.number.Numbers;
import java.math.BigInteger;

public class GetNumberTypeBasedOnValueTask extends Orion
{
    public static NumberType run(Number x)
    {
        NumberRules.isNotNull(x);

        if(Numbers.hasIntegerValue(x))
        {
            BigInteger temp = new BigInteger(x.toString());

            if(Numbers.isPositive(temp))
            {
                return NumberType.NaturalNumber;
            }
            else
            {
                return NumberType.IntegerNumber;
            }

        }
        else
        {
            return NumberType.RealNumber;
        }

    }
}