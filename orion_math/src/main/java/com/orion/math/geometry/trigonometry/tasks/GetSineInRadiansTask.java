package com.orion.math.geometry.trigonometry.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.constant.Constants;
import com.orion.math.geometry.trigonometry.TrigonometryService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class GetSineInRadiansTask extends Orion
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
            x = TrigonometryService.normaliseRadians(x);

            if(precision <= Precision.precision)
            {
                return ANumber.of(Math.sin(x.applyPrecisionGET(precision).get().doubleValue()));
            }
            else
            {
                return calculateSineUsingTaylorSeries(x.getCopy(), Constants.PI.doubleIt().get(), precision);
            }

        }

    }


    private static ANumber calculateSineUsingTaylorSeries(ANumber x, BigDecimal twoPi, int precision)
    {
        BigDecimal y = x.get();
        BigDecimal sineNormalizePoint = BigDecimal.valueOf(500);

        if(y.signum() == 0)
        {
            return ANumber.of(0);
        }
        else if(y.abs().compareTo(sineNormalizePoint) >= 0)
        {
            y = y.remainder(twoPi, new MathContext(precision + 1));
        }

        if(y.signum() == -1)
        {
            return calculateSineUsingTaylor(y.negate(), precision).negateGET();
        }
        else
        {
            return calculateSineUsingTaylor(y, precision);
        }

    }


    private static ANumber calculateSineUsingTaylor(BigDecimal x, int precision)
    {
        int sp1 = precision + 1;
        int i = 3;
        boolean addFlag = false;
        BigDecimal power = x;
        BigDecimal result = x;
        BigDecimal fac = new BigDecimal(6);
        BigDecimal term;
        BigDecimal tolerance = Precision.getEPS(precision + 1);

        do
        {
            power = power.multiply(x).multiply(x).setScale(sp1, RoundingMode.HALF_EVEN);
            term = power.divide(fac, sp1, RoundingMode.HALF_EVEN);
            result = addFlag ? result.add(term) : result.subtract(term);
            i += 2;
            fac = fac.multiply(BigDecimal.valueOf(i - 1L)).multiply(BigDecimal.valueOf(i));
            addFlag = !addFlag;
        }
        while(term.compareTo(tolerance) > 0);

        return ANumber.ofPrecision(result, precision);
    }
}