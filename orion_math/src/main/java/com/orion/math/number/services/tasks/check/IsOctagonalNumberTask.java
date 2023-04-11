package com.orion.math.number.services.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import java.math.BigInteger;

public class IsOctagonalNumberTask extends Orion
{
    public static boolean run(ANumber x)
    {
        NumberRules.isNotNull(x);
        BigInteger discriminant = x.getAsInteger().multiply(BigInteger.valueOf(12)).add(BigInteger.valueOf(4));
        ANumber squareRootOfDiscriminant = ANumber.of(discriminant).getSquareRoot();

        if(Numbers.hasIntegerValue(squareRootOfDiscriminant))
        {
            ANumber termIndex = squareRootOfDiscriminant.addGET(2).divideGET(6);
            return Numbers.hasIntegerValue(termIndex);
        }

        return false;
    }
}