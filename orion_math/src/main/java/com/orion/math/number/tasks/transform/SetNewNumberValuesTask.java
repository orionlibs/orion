package com.orion.math.number.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.InvalidNumberException;
import com.orion.math.number.NumberRules;
import java.math.BigDecimal;

public class SetNewNumberValuesTask extends Orion
{
    public void run(ANumber x, Number realValue, Number imaginaryValue)
    {
        NumberRules.isNotNull(x);
        BigDecimal realValueTemp = null;
        BigDecimal imaginaryValueTemp = null;

        try
        {
            realValueTemp = new BigDecimal(realValue.toString());
            imaginaryValueTemp = new BigDecimal(imaginaryValue.toString());
        }
        catch(NumberFormatException e)
        {
            throw new InvalidNumberException("The provided value is invalid and cannot create a number out of it.");
        }

        x.reset();
        x.setRealValue(realValueTemp);
        x.setImaginaryValue(imaginaryValueTemp);
    }


    public void run(ANumber x, Number realValue, Number imaginaryValue, int precision)
    {
        run(x, realValue, imaginaryValue);
        x.setPrecision(precision);
        x.applyPrecision();
    }
}