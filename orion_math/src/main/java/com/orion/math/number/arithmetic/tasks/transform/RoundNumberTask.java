package com.orion.math.number.arithmetic.tasks.transform;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import java.math.MathContext;
import java.math.RoundingMode;

public class RoundNumberTask extends OrionService
{
    private static final RoundingMode roundingMode = RoundingMode.HALF_EVEN;


    public static ANumber run(ANumber x)
    {
        return run(x, Precision.precision, roundingMode);
    }


    public static ANumber run(ANumber x, int precision)
    {
        return run(x, precision, roundingMode);
    }


    public static ANumber run(ANumber x, RoundingMode roundingMode)
    {
        return run(x, Precision.precision, roundingMode);
    }


    public static ANumber run(ANumber x, int precision, RoundingMode roundingMode)
    {
        NumberRules.isNotNull(x);
        precision = Precision.getValidPrecision(precision, x.getPrecision());
        MathContext context = (roundingMode != null) ? new MathContext(precision, roundingMode) : new MathContext(precision, roundingMode);
        return ANumber.of(x.get().round(context), x.getImaginaryValue().round(context));
    }
}