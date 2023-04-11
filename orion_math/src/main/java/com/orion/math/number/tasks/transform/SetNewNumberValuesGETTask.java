package com.orion.math.number.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import java.math.BigDecimal;

public class SetNewNumberValuesGETTask extends Orion
{
    public ANumber run(ANumber x, Number realValue, Number imaginaryValue, int precision)
    {
        NumberRules.isNotNull(x);
        ANumber newNumber = x.resetGET();
        newNumber.setRealValue(new BigDecimal(realValue.toString()));
        newNumber.setImaginaryValue(new BigDecimal(imaginaryValue.toString()));
        newNumber.setPrecision(Precision.getValidPrecision(precision));
        newNumber.applyPrecision();
        return newNumber;
    }
}