package com.orion.math.number.arithmetic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import java.math.BigInteger;

public class GetFactorialTask extends Orion
{
    public static ANumber run(ANumber n)
    {
        NumberRules.isNonNegative(n);
        BigInteger factorial = BigInteger.ONE;

        for(BigInteger i = BigInteger.valueOf(2); Numbers.isLessThanOrEqual(i, n); i = i.add(BigInteger.ONE))
        {
            factorial = factorial.multiply(i);
        }

        return ANumber.of(factorial);
    }
}