package com.orion.math.number.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.InvalidNumberException;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import com.orion.math.number.services.NumberService;
import java.math.BigDecimal;
import java.math.MathContext;

public class SaveStringNumberValuesTask extends Orion
{
    public void run(ANumber x, String realValue, String imaginaryValue)
    {
        NumberRules.isNotNull(x);
        boolean isValidRealNumber = NumberService.isValidNumber(realValue);
        boolean isValidImaginaryNumber = NumberService.isValidNumber(imaginaryValue);
        x.setValidNumber(isValidRealNumber && isValidImaginaryNumber);

        if(isValidRealNumber && isValidImaginaryNumber)
        {
            BigDecimal realValueTemp = new BigDecimal(realValue, MathContext.UNLIMITED);
            BigDecimal imaginaryValueTemp = new BigDecimal(imaginaryValue, MathContext.UNLIMITED);
            x.setRealValue(realValueTemp.stripTrailingZeros());
            x.setPrecision(0);

            if(imaginaryValue.isEmpty())
            {
                x.setImaginaryValue(BigDecimal.ZERO);
            }
            else
            {
                x.setImaginaryValue(imaginaryValueTemp.stripTrailingZeros());
            }

        }
        else
        {

            if(realValue != null)
            {
                throw new InvalidNumberException("The provided value is invalid and cannot create a number out of it.");
            }
            else
            {
                x.setRealValueAsNull();
                x.setImaginaryValueAsNull();
            }

        }

    }


    public void run(ANumber x, String realValue, String imaginaryValue, int precision)
    {
        NumberRules.isNotNull(x);
        boolean isValidRealNumber = NumberService.isValidNumber(realValue);
        boolean isValidImaginaryNumber = NumberService.isValidNumber(imaginaryValue);
        x.setValidNumber(isValidRealNumber && isValidImaginaryNumber);

        if(isValidRealNumber && isValidImaginaryNumber)
        {
            MathContext mathContext = new MathContext(precision);
            BigDecimal realValueTemp = new BigDecimal(realValue, mathContext);
            BigDecimal imaginaryValueTemp = new BigDecimal(imaginaryValue, mathContext);
            x.setRealValue(realValueTemp.stripTrailingZeros());
            x.setPrecision(Precision.getValidPrecision(realValueTemp.scale(), imaginaryValueTemp.scale()));
            x.applyPrecision();

            if(imaginaryValue.isEmpty())
            {
                x.setImaginaryValue(BigDecimal.ZERO);
            }
            else
            {
                x.setImaginaryValue(imaginaryValueTemp.stripTrailingZeros());
                x.applyPrecision();
            }

        }
        else
        {

            if(realValue != null)
            {
                throw new InvalidNumberException("The provided value is invalid and cannot create a number out of it.");
            }
            else
            {
                x.setRealValueAsNull();
                x.setImaginaryValueAsNull();
            }

        }

    }
}