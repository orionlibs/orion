package com.orion.math.number.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import com.orion.math.number.services.NumberService;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class MultiplyNumbersGETTask extends Orion
{
    public ANumber run(ANumber x, List<?> numbers, boolean checkForNullNumbers)
    {
        NumberRules.isNotNull(x);

        if(checkForNullNumbers)
        {
            NumberRules.areNotNull(numbers);
        }

        ANumber temp = x.getCopy();
        List<ANumber> numbersTemp = NumberService.getAsNumberList(numbers);

        for(ANumber y : numbersTemp)
        {
            temp = run(temp, (ANumber)y);
        }

        return temp;
    }


    public ANumber run(ANumber x, List<?> numbers, int precision, boolean checkForNullNumbers)
    {
        ANumber temp = run(x, numbers, checkForNullNumbers);
        temp.applyPrecision(precision);
        return temp;
    }


    public ANumber run(ANumber x, ANumber y)
    {
        ANumber newNumber = x.getCopy();
        int precision = Precision.getValidPrecisionForMultiplicationOrDivision(x, y);
        BigDecimal realValue1 = x.get();
        BigDecimal realValue2 = y.get();
        BigDecimal imaginaryValue1 = x.getImaginaryValue();
        BigDecimal imaginaryValue2 = y.getImaginaryValue();
        BigDecimal newRealValue = realValue1.multiply(realValue2, new MathContext(precision)).subtract(imaginaryValue1.multiply(imaginaryValue2, new MathContext(precision))).stripTrailingZeros();
        BigDecimal EPS = Precision.getEPS(precision);

        if(newRealValue.compareTo(EPS) < 0)
        {
            newNumber.setRealValue(newRealValue.setScale(precision, RoundingMode.HALF_EVEN));
        }
        else
        {
            newNumber.setRealValue(newRealValue);
        }

        BigDecimal newImaginaryValue = realValue1.multiply(imaginaryValue2, new MathContext(precision)).add(imaginaryValue1.multiply(realValue2, new MathContext(precision))).stripTrailingZeros();

        if(newImaginaryValue.compareTo(EPS) < 0)
        {
            newNumber.setImaginaryValue(newImaginaryValue.setScale(precision, RoundingMode.HALF_EVEN));
        }
        else
        {
            newNumber.setImaginaryValue(newImaginaryValue);
        }

        newNumber.trimZeros();
        return newNumber;
    }


    public ANumber run(ANumber x, ANumber y, int precision)
    {
        ANumber newNumber = run(x, y);
        newNumber.applyPrecision(precision);
        return newNumber;
    }


    public ANumber run(ANumber x, Number y, int precision)
    {
        return run(x, ANumber.of(y), precision);
    }


    public ANumber run(ANumber x, Number y)
    {
        return run(x, ANumber.of(y));
    }
}