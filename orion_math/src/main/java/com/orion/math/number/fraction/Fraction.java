package com.orion.math.number.fraction;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.number.ANumber;
import com.orion.math.number.services.NumberService;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Fraction extends Orion implements MathObject, Cloneable, Comparable<Fraction>
{
    private BigDecimal numerator;
    private BigDecimal denominator;


    public Fraction(BigDecimal x)
    {
        buildFractionFromBigDecimal(x);
    }


    public Fraction(BigDecimal numerator, BigDecimal denominator)
    {
        buildFractionFromNumeratorAndDenominator(numerator, denominator);
    }


    public Fraction(Number numerator, Number denominator)
    {
        FractionRules.isValid(numerator, denominator);
        BigDecimal numeratorTemp = new BigDecimal(numerator.toString());
        BigDecimal denominatorTemp = new BigDecimal(denominator.toString());
        buildFractionFromNumeratorAndDenominator(numeratorTemp, denominatorTemp);
    }


    public static Fraction of(BigDecimal numerator, BigDecimal denominator)
    {
        return new Fraction(numerator, denominator);
    }


    public static Fraction of(Number numerator, Number denominator)
    {
        return new Fraction(numerator, denominator);
    }


    public static Fraction of(ANumber numerator, ANumber denominator)
    {
        return new Fraction(numerator.get(), denominator.get());
    }


    public static Fraction of(BigDecimal x)
    {
        return new Fraction(x);
    }


    private void buildFractionFromBigDecimal(BigDecimal x)
    {
        FractionRules.isValid(x);
        int numberOfDecimalDigits = NumberService.getNumberOfDecimalDigits(x);
        int denom = 1;
        BigDecimal xCopy = new BigDecimal(x.toPlainString());

        for(int i = 0; i < numberOfDecimalDigits; i++)
        {
            xCopy = xCopy.multiply(BigDecimal.TEN);
            denom *= 10;
        }

        int num = xCopy.round(MathContext.UNLIMITED).intValue();
        int greatestCommonDivisor = BigInteger.valueOf(num).gcd(BigInteger.valueOf(denom)).intValue();
        this.numerator = BigDecimal.valueOf(num / greatestCommonDivisor);
        this.denominator = BigDecimal.valueOf(denom / greatestCommonDivisor);
        FractionRules.isValidDenominator(xCopy);
    }


    private void buildFractionFromNumeratorAndDenominator(BigDecimal numerator, BigDecimal denominator)
    {
        FractionRules.isValid(numerator, denominator);
        this.numerator = numerator;
        this.denominator = denominator;
        BigDecimal gcd = getGCD();

        if(gcd.compareTo(BigDecimal.ONE) > 0)
        {
            this.numerator = this.numerator.divide(gcd);
            this.denominator = this.denominator.divide(gcd);
        }

    }


    public void reciprocate()
    {
        new FractionInternalService().reciprocate(this);
    }


    public Fraction reciprocateGET()
    {
        Fraction copy = getCopy();
        copy.reciprocate();
        return copy;
    }


    public void negate()
    {
        this.numerator = numerator.negate();
    }


    public Fraction negateGET()
    {
        Fraction copy = getCopy();
        copy.negate();
        return copy;
    }


    private BigDecimal getGCD()
    {
        return new FractionInternalService().getGCD(this);
    }


    public void addFraction(Fraction fraction)
    {
        new FractionInternalService().addFraction(this, fraction);
    }


    public void subtractFraction(Fraction fraction)
    {
        new FractionInternalService().subtractFraction(this, fraction);
    }


    public void multiply(Number x)
    {
        new FractionInternalService().multiply(this, x);
    }


    public Fraction multiplyGET(Number x)
    {
        Fraction copy = getCopy();
        copy.multiply(x);
        return copy;
    }


    public void simplifyFraction()
    {
        new FractionInternalService().simplifyFraction(this);
    }


    public BigDecimal getValue()
    {
        return numerator.divide(denominator);
    }


    public double getValueAsDouble()
    {
        return getValue().doubleValue();
    }


    public String print()
    {
        return getNumerator().toString() + " / " + getDenominator().toString();
    }


    @Override
    public int hashCode()
    {
        return FractionInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return FractionInternalService.equals(this, object);
    }


    @Override
    public int compareTo(Fraction other)
    {
        return FractionInternalService.compareTo(this, other);
    }


    @Override
    public Fraction clone() throws CloneNotSupportedException
    {
        return (Fraction)CloningService.clone(this);
    }


    public Fraction getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    public BigDecimal getNumerator()
    {
        return this.numerator;
    }


    public ANumber getNumeratorAsNumber()
    {
        return ANumber.of(this.numerator);
    }


    public BigDecimal getDenominator()
    {
        return this.denominator;
    }


    public ANumber getDenominatorAsNumber()
    {
        return ANumber.of(this.denominator);
    }


    void setNumerator(BigDecimal numerator)
    {
        this.numerator = numerator;
    }


    void setDenominator(BigDecimal denominator)
    {
        this.denominator = denominator;
    }
}