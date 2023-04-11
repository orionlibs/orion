package com.orion.math.number.services.tasks.convert;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.number.fraction.Fraction;
import com.orion.math.number.services.NumberService;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class ConvertNumberToFractionTask extends Orion
{
    public static Fraction run(Number x)
    {
        NumberRules.isNotNull(x);
        BigDecimal temp = BigDecimal.ZERO;

        if(Numbers.isBigInteger(x))
        {
            temp = new BigDecimal((BigInteger)x, MathContext.UNLIMITED);
        }
        else if(Numbers.isBigDecimal(x))
        {
            temp = new BigDecimal(x.toString(), MathContext.UNLIMITED);
        }

        int numberOfDecimalDigits = NumberService.getNumberOfDecimalDigits(temp);
        BigInteger newNumerator = BigInteger.ONE;
        BigInteger newDenominator = BigInteger.ONE;

        for(int i = 0; i < numberOfDecimalDigits; i++)
        {
            temp = temp.scaleByPowerOfTen(1);
            newDenominator = newDenominator.multiply(BigInteger.TEN);
        }

        newNumerator = temp.round(MathContext.UNLIMITED).toBigInteger();
        BigInteger greatestCommonDivisor = newNumerator.gcd(newDenominator);
        BigDecimal newNumerator2 = new BigDecimal(newNumerator, MathContext.UNLIMITED).divide(new BigDecimal(greatestCommonDivisor, MathContext.UNLIMITED));
        BigDecimal newDenominator2 = new BigDecimal(newDenominator, MathContext.UNLIMITED).divide(new BigDecimal(greatestCommonDivisor, MathContext.UNLIMITED));
        return new Fraction(newNumerator2, newDenominator2);
    }


    public static Fraction run(Number x, int precision)
    {
        Fraction fraction = run(x);
        fraction.getNumerator().setScale(precision);
        fraction.getDenominator().setScale(precision);
        return fraction;
    }


    public static Fraction run(ANumber x)
    {
        NumberRules.isNotNull(x);
        return run(x.get());
    }


    public static Fraction run(ANumber x, int precision)
    {
        Fraction fraction = run(x);
        fraction.getNumerator().setScale(precision);
        fraction.getDenominator().setScale(precision);
        return fraction;
    }
}