package com.orion.math.geometry.trigonometry.tasks.hyperbolic;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.Functions;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;

public class GetHyperbolicCosineInRadiansTask extends Orion
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
                return ANumber.of(Math.cosh(x.applyPrecisionGET(precision).get().doubleValue()));
            }
            else
            {
                ANumber eToTheX = Functions.exp.run(x);
                return eToTheX.addGET(eToTheX.reciprocateGET()).halfGET(precision);
            }

        }

    }
}