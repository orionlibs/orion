package com.orion.math.number.fraction;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import java.math.BigDecimal;

public class FractionRules extends MathRule
{
    public static void isValid(Fraction fraction)
    {
        Assert.notNull(fraction, "The given fraction input cannot be null.");
        isValid(fraction.getNumerator(), fraction.getDenominator());
    }


    public static void isValid(BigDecimal x)
    {
        Assert.notNull(x, "Cannot convert null number to a fraction.");
    }


    public static void isValidDenominator(BigDecimal x)
    {
        Assert.notNull(x, "Cannot convert null number to a fraction.");
        Assert.isNotZero(x, "Cannot create fraction with denominator=0.");
    }


    public static void isValid(BigDecimal numerator, BigDecimal denominator)
    {
        Assert.notNull(numerator, "Cannot create fraction with null numerator.");
        Assert.notNull(denominator, "Cannot create fraction with null denominator.");
        Assert.isNotZero(denominator, "Cannot create fraction with denominator=0.");
    }


    public static void isValid(Number numerator, Number denominator)
    {
        Assert.notNull(numerator, "Cannot create fraction with null numerator.");
        Assert.notNull(denominator, "Cannot create fraction with null denominator.");
        Assert.isNotZero(denominator, "Cannot create fraction with denominator=0.");
    }
}