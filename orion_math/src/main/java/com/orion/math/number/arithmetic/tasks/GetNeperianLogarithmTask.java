package com.orion.math.number.arithmetic.tasks;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.precision.Precision;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GetNeperianLogarithmTask extends OrionService
{
    public static ANumber run(ANumber x, int precision)
    {
        NumberRules.isPositive(x);
        return run(x.get(), precision);
    }


    private static ANumber run(BigDecimal x, int precision)
    {

        if(Numbers.isOne(x))
        {
            return ANumber.of(0);
        }
        else
        {

            if(precision <= Precision.precision)
            {
                return ANumber.of(Math.log(x.doubleValue()));
            }
            else
            {
                int integerPart = x.toPlainString().length() - x.scale() - 1;

                if(integerPart < 3)
                {
                    return ANumber.of(getNeperianLogarithmUsingNewtonMethod(x, precision));
                }
                else
                {
                    BigDecimal root = GetIntegralRootTask.run(ANumber.of(x), ANumber.of(integerPart), precision).get();
                    BigDecimal lnRoot = getNeperianLogarithmUsingNewtonMethod(root, precision);
                    BigDecimal temp = BigDecimal.valueOf(integerPart).multiply(lnRoot).setScale(precision, RoundingMode.HALF_EVEN);
                    return ANumber.of(temp);
                }

            }

        }

    }


    private static BigDecimal getNeperianLogarithmUsingNewtonMethod(BigDecimal x, int precision)
    {
        int sp1 = precision + 1;
        BigDecimal n = new BigDecimal(x.toPlainString());
        BigDecimal term = BigDecimal.ZERO;
        BigDecimal tolerance = Precision.getEPS(sp1);

        do
        {
            BigDecimal eToX = ArithmeticService.getEToThePowerOf(ANumber.of(x), sp1).get();
            term = eToX.subtract(n).divide(eToX, sp1, RoundingMode.DOWN);
            x = x.subtract(term);
        }
        while(term.compareTo(tolerance) > 0);

        return x.setScale(precision, RoundingMode.HALF_EVEN);
    }
}