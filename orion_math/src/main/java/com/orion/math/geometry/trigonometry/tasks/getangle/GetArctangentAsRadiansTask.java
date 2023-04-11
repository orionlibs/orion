package com.orion.math.geometry.trigonometry.tasks.getangle;

import com.orion.core.abstraction.Orion;
import com.orion.math.constant.Constants;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.number.precision.Precision;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GetArctangentAsRadiansTask extends Orion
{
    public static ANumber run(ANumber x, int precision)
    {
        NumberRules.isNotNull(x);

        if(x.isNaN())
        {
            return ANumber.of(0);
        }
        else
        {

            if(precision <= Precision.precision)
            {
                return ANumber.of(Math.atan(x.applyPrecisionGET(precision).get().doubleValue()));
            }
            else
            {
                return calculateArctangent(x, precision);
            }

        }

    }


    private static ANumber calculateArctangent(ANumber x, int precision)
    {
        int sp1 = precision + 1;
        int i = 3;
        BigDecimal term;
        boolean usePlusSign = false;
        BigDecimal tolerance = Precision.getEPS(sp1);
        BigDecimal power = x.getAsDecimalCopy();
        BigDecimal xValue = x.get();

        if(Numbers.isBetweenExclusive(x, -1, 1))
        {
            BigDecimal result = x.getAsDecimalCopy();

            do
            {
                power = power.multiply(xValue).multiply(xValue)
                                .setScale(precision, RoundingMode.HALF_EVEN);
                term = power.divide(BigDecimal.valueOf(i), precision, RoundingMode.HALF_EVEN);
                result = (usePlusSign) ? result.add(term) : result.subtract(term);
                i += 2;
                usePlusSign = !usePlusSign;
            }
            while(term.compareTo(tolerance) > 0);

            return ANumber.ofPrecision(result, precision);
        }
        else
        {
            ANumber halfPi = Constants.PI.getValue().halfGET();

            if(Numbers.isLessThanOrEqual(x, ANumber.of(-1)))
            {
                halfPi.negate();
            }

            BigDecimal result = halfPi.get().subtract(BigDecimal.ONE.divide(x.get()));

            do
            {
                power = power.multiply(xValue).multiply(xValue)
                                .setScale(precision, RoundingMode.HALF_EVEN);
                term = BigDecimal.ONE.divide(power.multiply(BigDecimal.valueOf(i)), precision, RoundingMode.HALF_EVEN);
                result = (usePlusSign) ? result.add(term) : result.subtract(term);
                i += 2;
                usePlusSign = !usePlusSign;
            }
            while(term.compareTo(tolerance) > 0);

            return ANumber.ofPrecision(result, precision);
        }

    }
}