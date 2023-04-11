package com.orion.math.number.services.tasks.convert;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import java.math.BigDecimal;

public class TrimZerosInNumberTask extends Orion
{
    public static void run(ANumber x)
    {
        NumberRules.isNotNull(x);
        BigDecimal realValue = x.get().stripTrailingZeros();
        BigDecimal imaginaryValue = x.getImaginaryValue().stripTrailingZeros();
        x.setNewValues(realValue, imaginaryValue, Precision.getValidPrecision(realValue, imaginaryValue));
    }
}