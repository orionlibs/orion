package com.orion.math.number.arithmetic.tasks;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.number.InvalidNumberException;
import com.orion.math.number.Numbers;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GetEToThePowerOfTask extends OrionService
{
    private static final RoundingMode roundingMode = RoundingMode.HALF_EVEN;


    public static ANumber run(ANumber x, int precision)
    {

        if(Numbers.isZero(x))
        {
            return ANumber.of(1);
        }
        else if(Numbers.isNegative(x))
        {
            return run(x.negateGET(), precision).reciprocateGET();
        }
        else
        {
            BigDecimal realValue = x.getAsDecimalCopy();
            BigDecimal xWhole = x.getIntegerPart().getAsDecimalCopy();

            if(Numbers.isZero(xWhole))
            {
                return ANumber.of(getEToThePowerOfUsingTaylorSeres(realValue, precision));
            }

            BigDecimal xFraction = realValue.subtract(xWhole);
            BigDecimal z = BigDecimal.ONE.add(xFraction.divide(xWhole, precision, roundingMode));
            BigDecimal t = getEToThePowerOfUsingTaylorSeres(z, precision);
            BigDecimal maxLong = BigDecimal.valueOf(Long.MAX_VALUE);
            BigDecimal result = BigDecimal.ONE;

            while(Numbers.isGreaterThanOrEqual(xWhole, maxLong))
            {
                t = t.pow(Integer.MAX_VALUE).setScale(precision, roundingMode);
                result = result.multiply(t).setScale(precision, roundingMode);
                xWhole = xWhole.subtract(maxLong);
            }

            if(xWhole.longValue() > 999_999_999)
            {

                try
                {
                    t = BigDecimal.valueOf(Math.exp(xWhole.doubleValue())).setScale(precision, roundingMode);
                }
                catch(NumberFormatException e)
                {
                    throw new InvalidNumberException("The exponent is too big and the result is infinity/NaN.");
                }

            }
            else
            {
                t = t.pow(xWhole.intValue()).setScale(precision, roundingMode);
            }

            return ANumber.of(result.multiply(t).setScale(precision, roundingMode));
        }

    }


    private static BigDecimal getEToThePowerOfUsingTaylorSeres(BigDecimal x, int precision)
    {
        BigDecimal factorial = BigDecimal.ONE;
        BigDecimal xPower = new BigDecimal(x.toPlainString());
        BigDecimal sumPrev = BigDecimal.ZERO;
        BigDecimal sum = x.add(BigDecimal.ONE);
        int i = 2;

        do
        {
            xPower = xPower.multiply(x).setScale(precision, roundingMode);
            factorial = factorial.multiply(BigDecimal.valueOf(i));
            BigDecimal term = xPower.divide(factorial, precision, roundingMode);
            sumPrev = sum;
            sum = sum.add(term);
            ++i;
        }
        while(Numbers.notEqual(sum, sumPrev));

        return sum;
    }
}