package com.orion.math.number.arithmetic.tasks;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.number.precision.Precision;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GetIntegralRootTask extends OrionService
{
    private static final RoundingMode roundingMode = RoundingMode.HALF_EVEN;


    public static ANumber run(ANumber x, ANumber index, int precision)
    {
        return run(x.getAsDecimalCopy(), index, precision);
    }


    private static ANumber run(BigDecimal x, ANumber index, int precision)
    {
        NumberRules.isPositive(x);
        int sp1 = precision + 1;
        BigDecimal n = x;
        BigDecimal i = index.get();
        BigDecimal im1 = i.subtract(BigDecimal.ONE);
        BigDecimal tolerance = Precision.getEPS(sp1);
        BigDecimal xPrev = BigDecimal.ZERO;
        x = x.divide(i, precision, roundingMode);

        do
        {
            BigDecimal xToIm1 = x.pow(im1.intValue());
            xToIm1.setScale(sp1, roundingMode);
            BigDecimal xToI = x.multiply(xToIm1).setScale(sp1, roundingMode);
            BigDecimal numerator = n.add(im1.multiply(xToI)).setScale(sp1, roundingMode);
            BigDecimal denominator = i.multiply(xToIm1).setScale(sp1, roundingMode);
            xPrev = x;
            x = numerator.divide(denominator, sp1, RoundingMode.DOWN);
        }
        while(Numbers.isGreaterThan(x.subtract(xPrev).abs(), tolerance));

        return ANumber.of(x);
    }
}