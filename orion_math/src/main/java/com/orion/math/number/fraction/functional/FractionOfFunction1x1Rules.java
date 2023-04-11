package com.orion.math.number.fraction.functional;

import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.math.MathRule;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;

public class FractionOfFunction1x1Rules extends MathRule
{
    public static void isValid(FractionOfFunction1x1 fraction)
    {
        Assert.notNull(fraction, "The given fraction input cannot be null.");
        isValid(fraction.getNumerator(), fraction.getDenominator());
    }


    public static void isValid(Function1x1<ANumber, ANumber> numerator, Function1x1<ANumber, ANumber> denominator)
    {
        Assert.notNull(numerator, "Cannot create fraction with null numerator.");
        Assert.notNull(denominator, "Cannot create fraction with null denominator.");

        if(denominator.isZeroFunction())
        {
            throw new InvalidArgumentException("Cannot create fraction with denominator=0.");
        }

    }
}