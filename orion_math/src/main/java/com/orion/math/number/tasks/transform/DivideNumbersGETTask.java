package com.orion.math.number.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class DivideNumbersGETTask extends Orion
{
    public ANumber run(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        ANumber newNumber = x.getCopy();
        int precision = Precision.getValidPrecisionForMultiplicationOrDivision(x, y);
        x.trimZeros();
        y.trimZeros();

        if(y.isZero())
        {

            if(x.isNegative())
            {
                return ANumber.ofMin();
            }
            else
            {
                return ANumber.ofMax();
            }

        }

        BigDecimal realValue1 = x.getAsDecimalCopy();
        BigDecimal realValue2 = y.getAsDecimalCopy();
        BigDecimal imaginaryValue1 = x.getImaginaryValueCopy();
        BigDecimal imaginaryValue2 = y.getImaginaryValueCopy();
        MathContext mathContext = new MathContext(precision, RoundingMode.HALF_EVEN);

        if(x.isComplexNumber() || y.isComplexNumber())
        {
            ANumber numberForModulus = x.getCopy();
            numberForModulus.applyPrecision(precision);
            numberForModulus.setRealValue(realValue2);
            numberForModulus.setImaginaryValue(imaginaryValue2);
            BigDecimal ac = realValue1.multiply(realValue2, mathContext);
            BigDecimal bd = imaginaryValue1.multiply(imaginaryValue2, mathContext);
            BigDecimal modulus = numberForModulus.getModulusAsDecimal();

            if(modulus.compareTo(BigDecimal.ONE) < 0)
            {
                modulus = modulus.pow(2, new MathContext(modulus.scale() + precision, RoundingMode.HALF_EVEN));
            }
            else
            {
                modulus = modulus.pow(2, mathContext);
            }

            try
            {
                newNumber.setRealValue(ac.add(bd).divide(modulus, mathContext));
            }
            catch(ArithmeticException e)
            {
                newNumber.setRealValue(BigDecimal.ZERO);
            }

            BigDecimal bc = realValue2.multiply(imaginaryValue1, mathContext);
            BigDecimal ad = realValue1.multiply(imaginaryValue2, mathContext);

            try
            {
                newNumber.setImaginaryValue(bc.subtract(ad).divide(modulus, mathContext));
            }
            catch(ArithmeticException e)
            {
                newNumber.setImaginaryValue(BigDecimal.ZERO);
            }

        }
        else
        {
            newNumber.setImaginaryValue(BigDecimal.ZERO);

            try
            {
                newNumber.setRealValue(realValue1.divide(realValue2, mathContext));
            }
            catch(ArithmeticException e)
            {
                throw e;
            }

        }

        newNumber.trimZeros();
        return newNumber;
    }


    public ANumber run(ANumber x, Number y)
    {
        NumberRules.areNotNull(x, y);
        return run(x, ANumber.of(y));
    }
}