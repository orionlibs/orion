package com.orion.math.primenumber;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.services.NumberService;
import com.orion.math.streams.NumberStream;
import java.util.List;

public class PrimeNumberService extends OrionService
{
    public static boolean isPrimeNumber(ANumber x)
    {
        NumberRules.isPositive(x);
        NumberRules.hasIntegerValue(x);
        return x.getAbsoluteValue().getAsInteger().isProbablePrime(30);
    }


    public static boolean areRelativePrimeNumbers(ANumber x, ANumber y)
    {
        return NumberService.getGreatestCommonDivisor(x, y).equal(ANumber.of(1));
    }


    public static List<ANumber> getPrimeNumbersBelow(ANumber x)
    {
        NumberRules.isPositive(x);
        return NumberStream.of(ANumber.of(2), x.addOneGET().getAbsoluteValue())
                        .filter(i -> i.isPrime()).getAsList();
    }
}