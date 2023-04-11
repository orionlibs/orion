package com.orion.math.number.fraction.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.fraction.Fraction;
import com.orion.math.number.fraction.FractionRules;
import com.orion.math.number.services.NumberService;
import java.math.BigDecimal;

public class GetGCDOfFractionTask extends Orion
{
    public static BigDecimal run(Fraction fraction)
    {
        int numberOfDecimalDigitsOfNumerator = NumberService.getNumberOfDecimalDigits(fraction.getNumerator());
        int numberOfDecimalDigitsOfDenominator = NumberService.getNumberOfDecimalDigits(fraction.getDenominator());
        int numberOfDecimalDigitsToUse = Math.max(numberOfDecimalDigitsOfNumerator, numberOfDecimalDigitsOfDenominator);
        BigDecimal numeratorTemp = fraction.getNumerator().multiply(BigDecimal.TEN.pow(numberOfDecimalDigitsToUse));
        BigDecimal denominatorTemp = fraction.getDenominator().multiply(BigDecimal.TEN.pow(numberOfDecimalDigitsToUse));
        return new BigDecimal(numeratorTemp.toBigInteger().gcd(denominatorTemp.toBigInteger()));
    }


    public static BigDecimal run(Fraction fraction, BigDecimal numeratorTemp, BigDecimal denominatorTemp)
    {
        FractionRules.isValid(numeratorTemp, denominatorTemp);
        int numberOfDecimalDigitsOfNumerator = NumberService.getNumberOfDecimalDigits(numeratorTemp);
        int numberOfDecimalDigitsOfDenominator = NumberService.getNumberOfDecimalDigits(denominatorTemp);
        int numberOfDecimalDigitsToUse = Math.max(numberOfDecimalDigitsOfNumerator, numberOfDecimalDigitsOfDenominator);
        BigDecimal numeratorTemp2 = fraction.getNumerator().multiply(BigDecimal.TEN.pow(numberOfDecimalDigitsToUse));
        BigDecimal denominatorTemp2 = fraction.getDenominator().multiply(BigDecimal.TEN.pow(numberOfDecimalDigitsToUse));
        return new BigDecimal(numeratorTemp2.toBigInteger().gcd(denominatorTemp2.toBigInteger()));
    }
}