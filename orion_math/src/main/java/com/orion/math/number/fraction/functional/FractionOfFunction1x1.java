package com.orion.math.number.fraction.functional;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;

public class FractionOfFunction1x1 extends Orion implements MathObject, Cloneable
{
    private Function1x1<ANumber, ANumber> numerator;
    private Function1x1<ANumber, ANumber> denominator;


    public FractionOfFunction1x1(Function1x1<ANumber, ANumber> numerator, Function1x1<ANumber, ANumber> denominator)
    {
        FractionOfFunction1x1Rules.isValid(numerator, denominator);
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public static FractionOfFunction1x1 of(Function1x1<ANumber, ANumber> numerator, Function1x1<ANumber, ANumber> denominator)
    {
        return new FractionOfFunction1x1(numerator, denominator);
    }


    public void reciprocate()
    {
        new FractionOfFunction1x1InternalService().reciprocate(this);
    }


    public FractionOfFunction1x1 reciprocateGET()
    {
        FractionOfFunction1x1 copy = getCopy();
        copy.reciprocate();
        return copy;
    }


    public void negate()
    {
        this.numerator = numerator.negate();
    }


    public FractionOfFunction1x1 negateGET()
    {
        FractionOfFunction1x1 copy = getCopy();
        copy.negate();
        return copy;
    }


    public void addFraction(FractionOfFunction1x1 fraction)
    {
        new FractionOfFunction1x1InternalService().addFraction(this, fraction);
    }


    public void subtractFraction(FractionOfFunction1x1 fraction)
    {
        new FractionOfFunction1x1InternalService().subtractFraction(this, fraction);
    }


    public void multiply(Number x)
    {
        new FractionOfFunction1x1InternalService().multiply(this, x);
    }


    public FractionOfFunction1x1 multiplyGET(Number x)
    {
        FractionOfFunction1x1 copy = getCopy();
        copy.multiply(x);
        return copy;
    }


    public ANumber getValue(ANumber x)
    {
        return numerator.run(x).divideGET(denominator.run(x));
    }


    public double getValueAsDouble(ANumber x)
    {
        return getValue(x).getAsDouble();
    }


    @Override
    public FractionOfFunction1x1 clone() throws CloneNotSupportedException
    {
        return (FractionOfFunction1x1)CloningService.clone(this);
    }


    public FractionOfFunction1x1 getCopy()
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


    public Function1x1<ANumber, ANumber> getNumerator()
    {
        return this.numerator;
    }


    public Function1x1<ANumber, ANumber> getDenominator()
    {
        return this.denominator;
    }


    void setNumerator(Function1x1<ANumber, ANumber> numerator)
    {
        this.numerator = numerator;
    }


    void setDenominator(Function1x1<ANumber, ANumber> denominator)
    {
        this.denominator = denominator;
    }
}