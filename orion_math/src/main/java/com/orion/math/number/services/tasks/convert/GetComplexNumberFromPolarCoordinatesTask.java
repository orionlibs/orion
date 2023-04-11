package com.orion.math.number.services.tasks.convert;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.math.BigDecimal;

public class GetComplexNumberFromPolarCoordinatesTask extends Orion
{
    public static ANumber run(ANumber length, ANumber angle)
    {
        NumberRules.isNotNull(angle);
        NumberRules.isNonNegative(length);
        BigDecimal realValue = length.multiplyGET(angle.getCosine()).get();
        BigDecimal imaginaryValue = length.multiplyGET(angle.getSine()).get();
        return ANumber.of(realValue, imaginaryValue);
    }
}