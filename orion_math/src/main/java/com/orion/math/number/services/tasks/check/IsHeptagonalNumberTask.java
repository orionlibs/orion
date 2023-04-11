package com.orion.math.number.services.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import java.math.BigInteger;

public class IsHeptagonalNumberTask extends Orion
{
    public static boolean run(ANumber x)
    {
        NumberRules.isNotNull(x);
        BigInteger discriminant = x.getAsInteger().multiply(BigInteger.valueOf(40)).add(BigInteger.valueOf(9));
        ANumber squareRootOfDiscriminant = ANumber.of(discriminant).getSquareRoot();

        if(Numbers.hasIntegerValue(squareRootOfDiscriminant))
        {
            ANumber termIndex = squareRootOfDiscriminant.addGET(3).divideGET(10);
            return Numbers.hasIntegerValue(termIndex);
        }

        return false;
    }
}