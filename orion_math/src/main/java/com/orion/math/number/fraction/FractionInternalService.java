package com.orion.math.number.fraction;

import com.orion.math.MathObject;
import com.orion.math.number.NumberRules;
import com.orion.math.number.fraction.tasks.FractionCompareToAnotherTask;
import com.orion.math.number.fraction.tasks.GetFractionEqualsTask;
import com.orion.math.number.fraction.tasks.GetFractionHashCodeTask;
import com.orion.math.number.fraction.tasks.GetGCDOfFractionTask;
import java.math.BigDecimal;

class FractionInternalService implements MathObject
{
    static boolean equals(Fraction fraction, Object object)
    {
        return GetFractionEqualsTask.run(fraction, object);
    }


    static int hashCode(Fraction fraction)
    {
        return GetFractionHashCodeTask.run(fraction);
    }


    static int compareTo(Fraction x, Fraction y)
    {
        return FractionCompareToAnotherTask.run(x, y);
    }


    void reciprocate(Fraction fraction)
    {
        fraction.setNumerator(new BigDecimal(fraction.getDenominator().toString()));
        fraction.setDenominator(new BigDecimal(fraction.getNumerator().toString()));
        BigDecimal gcd = getGCD(fraction);

        if(gcd.compareTo(BigDecimal.ONE) > 0)
        {
            fraction.setNumerator(fraction.getNumerator().divide(gcd));
            fraction.setDenominator(fraction.getDenominator().divide(gcd));
        }

    }


    BigDecimal getGCD(Fraction fraction)
    {
        return GetGCDOfFractionTask.run(fraction);
    }


    BigDecimal getGCD(Fraction fraction, BigDecimal numeratorTemp, BigDecimal denominatorTemp)
    {
        return GetGCDOfFractionTask.run(fraction, numeratorTemp, denominatorTemp);
    }


    void addFraction(Fraction fraction1, Fraction fraction2)
    {
        FractionRules.isValid(fraction2);
        fraction2.simplifyFraction();
        BigDecimal numeratorTemp = (fraction1.getNumerator().multiply(fraction2.getDenominator())).add(fraction2.getNumerator().multiply(fraction1.getDenominator()));
        BigDecimal denominatorTemp = fraction2.getDenominator().multiply(fraction1.getDenominator());
        simplifyFraction(fraction1, numeratorTemp, denominatorTemp);
    }


    void subtractFraction(Fraction fraction1, Fraction fraction2)
    {
        FractionRules.isValid(fraction2);
        fraction2.simplifyFraction();
        BigDecimal numeratorTemp = (fraction1.getNumerator().multiply(fraction2.getDenominator())).subtract(fraction2.getNumerator().multiply(fraction1.getDenominator()));
        BigDecimal denominatorTemp = fraction2.getDenominator().multiply(fraction1.getDenominator());
        simplifyFraction(fraction1, numeratorTemp, denominatorTemp);
    }


    void multiply(Fraction fraction, Number x)
    {
        NumberRules.isNotNull(x);
        BigDecimal numeratorTemp = fraction.getNumerator().multiply(new BigDecimal(x.toString()));
        BigDecimal denominatorTemp = fraction.getDenominator().multiply(new BigDecimal(x.toString()));
        simplifyFraction(fraction, numeratorTemp, denominatorTemp);
    }


    void simplifyFraction(Fraction fraction)
    {
        BigDecimal gcd = getGCD(fraction);

        if(gcd.compareTo(BigDecimal.ONE) > 0)
        {
            fraction.setNumerator(fraction.getNumerator().divide(gcd));
            fraction.setDenominator(fraction.getDenominator().divide(gcd));
        }

    }


    void simplifyFraction(Fraction fraction, BigDecimal numeratorTemp, BigDecimal denominatorTemp)
    {
        FractionRules.isValid(numeratorTemp, denominatorTemp);
        BigDecimal gcd = getGCD(fraction, numeratorTemp, denominatorTemp);

        if(gcd.compareTo(BigDecimal.ONE) > 0)
        {
            fraction.setNumerator(numeratorTemp.divide(gcd));
            fraction.setDenominator(denominatorTemp.divide(gcd));
        }

    }
}