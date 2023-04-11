package com.orion.math.geometry.trigonometry.tasks.getangle;

import com.orion.core.abstraction.Orion;
import com.orion.math.constant.Constants;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GetArcsineAsRadiansTask extends Orion
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
            NumberRules.isBetween(x, -1, 1);

            if(x.isZero())
            {
                return ANumber.of(0);
            }
            else if(x.isOne())
            {
                return Constants.halfPI;
            }
            else if(x.equal(0.5))
            {
                return Constants.PI.getValue().divideGET(6);
            }

            if(precision <= Precision.precision)
            {
                return ANumber.of(Math.asin(x.applyPrecisionGET(precision).get().doubleValue()));
            }
            else
            {
                return calculateArcsine(x, precision);
            }

        }

    }


    private static ANumber calculateArcsine(ANumber x, int precision)
    {
        BigDecimal result = x.getAsDecimalCopy();
        int sp1 = precision + 1;
        int i = 3;
        BigDecimal power = x.getAsDecimalCopy();
        BigDecimal term;
        BigDecimal fac1 = BigDecimal.valueOf(2);
        BigDecimal tolerance = Precision.getEPS(sp1);
        BigDecimal xValue = x.get();

        do
        {
            power = power.multiply(xValue).multiply(xValue).multiply(BigDecimal.valueOf(i - 2L))
                            .setScale(precision, RoundingMode.HALF_EVEN);
            BigDecimal fac = fac1.multiply(BigDecimal.valueOf(i));
            term = power.divide(fac, precision, RoundingMode.HALF_EVEN);
            result = result.add(term);
            fac1 = fac1.multiply(BigDecimal.valueOf(i + 1L));
            i += 2;
        }
        while(term.compareTo(tolerance) > 0);

        return ANumber.ofPrecision(result, precision);
    }
}