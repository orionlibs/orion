package com.orion.math.number.arithmetic.tasks;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.number.precision.Precision;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GetNthRootOfNumberTask extends OrionService
{
    public static ANumber run(ANumber x, int n, int precision)
    {
        NumberRules.isNonNegative(x);
        NumberRules.isPositive(n);

        if(precision <= Precision.precision && n == 2)
        {
            return ANumber.of(Math.sqrt(x.get().doubleValue()));
        }
        else
        {
            precision = Precision.getValidPrecision(precision);
            ANumber result = ANumber.of(calculate(x, n, precision));
            result.applyPrecision(precision);
            return result;
        }

    }


    private static BigDecimal calculate(ANumber x, int n, int precision)
    {

        if(Numbers.isZero(x))
        {
            return BigDecimal.ZERO;
        }

        BigDecimal temp = x.getAsDecimalCopy();
        BigDecimal p = BigDecimal.valueOf(0.1).movePointLeft(precision);
        BigDecimal yPrev = temp;
        BigDecimal y = temp.divide(BigDecimal.valueOf(n), precision, RoundingMode.HALF_EVEN);

        while(Numbers.isGreaterThan(y.subtract(yPrev).abs(), p))
        {
            yPrev = y;
            y = BigDecimal.valueOf(n - 1.0).multiply(y).add(temp.divide(y.pow(n - 1), precision, RoundingMode.HALF_EVEN)).divide(new BigDecimal(n), precision, RoundingMode.HALF_EVEN);
        }

        return y;
    }
}