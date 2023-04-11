package com.orion.math.number.services.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.NumberType;
import com.orion.math.number.Numbers;
import java.math.BigDecimal;

public class PrintNumberTask extends Orion
{
    public static String run(ANumber x)
    {
        NumberRules.isNotNull(x);
        BigDecimal realValue = x.get();
        BigDecimal imaginaryValue = x.getImaginaryValue();

        if(x.getNumberType().is(NumberType.ComplexNumber))
        {

            if(realValue == null || imaginaryValue == null)
            {
                return "NaN";
            }
            else
            {

                if(Numbers.isNegative(imaginaryValue))
                {
                    return realValue.toPlainString() + " - " + imaginaryValue.negate().toPlainString() + "i";
                }
                else
                {
                    return realValue.toPlainString() + " + " + imaginaryValue.toPlainString() + "i";
                }

            }

        }
        else
        {

            if(realValue == null)
            {
                return "NaN";
            }
            else
            {
                return realValue.toPlainString();
            }

        }

    }
}