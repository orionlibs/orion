package com.orion.math.number.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.NumberType;
import com.orion.math.number.Numbers;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class ExponentiateNumberGETTask extends Orion
{
    public ANumber run(ANumber base, ANumber exponent)
    {
        NumberRules.areNotNull(base, exponent);
        ANumber newNumber = null;

        if(base.getNumberType().is(NumberType.NegativeInfinityNumber)
                        || base.getNumberType().is(NumberType.PositiveInfinityNumber))
        {
            return base.getCopy();
        }
        else if(exponent.getNumberType().is(NumberType.NegativeInfinityNumber)
                        || exponent.getNumberType().is(NumberType.PositiveInfinityNumber))
        {
            newNumber = base.getCopy();
            newNumber.reset();
            newNumber.setRealValue(BigDecimal.ZERO);
            newNumber.setValidNumber(true);
            return newNumber;
        }

        newNumber = base.getCopy();

        if(Numbers.isZero(exponent))
        {
            return ANumber.of(1);
        }
        else if(Numbers.isOne(exponent))
        {
            return newNumber;
        }
        else
        {

            if(base.getNumberType().is(NumberType.ComplexNumber))
            {

                if(Numbers.hasIntegerValue(exponent.get()))
                {
                    BigDecimal temp1 = base.get();
                    BigInteger temp2 = exponent.getAsInteger();
                    newNumber.setRealValue(temp1.pow(temp2.intValue()).setScale(0, RoundingMode.HALF_EVEN));
                }
                else if(Numbers.isBigDecimal(exponent.get()))
                {
                    BigDecimal temp1 = base.get();
                    BigDecimal temp2 = exponent.get();
                    ANumber log = (ANumber)ArithmeticService.getNeperianLogarithm(ANumber.of(temp1), 0);
                    BigDecimal log1 = log.get();
                    ANumber z = (ANumber)ArithmeticService.getEToThePowerOf(ANumber.of(log1.multiply(temp2)), 0);
                    BigDecimal z1 = z.get();
                    newNumber.setRealValue(z1);
                }

                if(Numbers.hasIntegerValue(exponent.getImaginaryValue()))
                {
                    BigDecimal temp1 = base.getImaginaryValue();

                    if(Numbers.isNotZero(temp1))
                    {
                        BigInteger temp2 = exponent.getImaginaryValueAsBigInteger();
                        newNumber.setImaginaryValue(temp1.pow(temp2.intValue()).setScale(0, RoundingMode.HALF_EVEN));
                    }

                }
                else if(Numbers.isBigDecimal(exponent.getImaginaryValue()))
                {
                    BigDecimal temp1 = base.getImaginaryValue();

                    if(Numbers.isNotZero(temp1))
                    {
                        BigDecimal temp2 = exponent.getImaginaryValue();
                        ANumber log = (ANumber)ArithmeticService.getNeperianLogarithm(ANumber.of(temp1), 0);
                        BigDecimal log1 = log.get();
                        ANumber z = (ANumber)ArithmeticService.getEToThePowerOf(ANumber.of(log1.multiply(temp2)), 0);
                        BigDecimal z1 = z.get();
                        newNumber.setImaginaryValue(z1);
                    }

                }

            }
            else
            {

                if(Numbers.isPositive(exponent))
                {

                    for(BigInteger i = BigInteger.ONE; Numbers.isLessThan(i, exponent); i = i.add(BigInteger.ONE))
                    {
                        newNumber = base.multiplyGET(newNumber);
                    }

                }
                else if(Numbers.isNegative(exponent))
                {
                    ANumber newNumberDenominator = base.getCopy();

                    for(BigInteger i = BigInteger.ONE; Numbers.isLessThan(i, exponent.negateGET().getAsInteger()); i = i.add(BigInteger.ONE))
                    {
                        newNumberDenominator = base.multiplyGET(newNumberDenominator);
                    }

                    newNumber.reset();
                    newNumber.setRealValue(BigDecimal.ONE);
                    newNumber.divide(newNumberDenominator);
                }

            }

        }

        return newNumber;
    }


    public ANumber run(ANumber base, Number exponent)
    {
        NumberRules.areNotNull(base, exponent);
        return run(base, ANumber.of(exponent));
    }
}