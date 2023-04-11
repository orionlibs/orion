package com.orion.math.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;

public class RationalFunction extends Orion
{
    private PolynomialFunction numerator;
    private PolynomialFunction denominator;


    public RationalFunction(PolynomialFunction numerator, PolynomialFunction denominator)
    {
        FunctionRules.isValid(numerator, denominator);
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public static RationalFunction of(PolynomialFunction numerator, PolynomialFunction denominator)
    {
        return new RationalFunction(numerator, denominator);
    }


    public ANumber run(ANumber value)
    {
        return getNumerator().run(value).divideGET(getDenominator().run(value));
    }


    public RationalFunction differentiate()
    {
        return RationalFunction.of(PolynomialFunction.of(getNumerator().differentiate()), PolynomialFunction.of(getDenominator().differentiate()));
    }


    public RationalFunction differentiate(int orderOfDerivative)
    {
        return RationalFunction.of(PolynomialFunction.of(getNumerator().differentiate(orderOfDerivative)), PolynomialFunction.of(getDenominator().differentiate(orderOfDerivative)));
    }


    public ANumber differentiate(ANumber x)
    {
        return getNumerator().differentiate(x).divideGET(getDenominator().differentiate(x));
    }


    public ANumber differentiate(ANumber x, int orderOfDerivative)
    {
        return getNumerator().differentiate(x, orderOfDerivative).divideGET(getDenominator().differentiate(x, orderOfDerivative));
    }


    public RationalFunction integrate()
    {
        return RationalFunction.of(PolynomialFunction.of(getNumerator().integrate()), PolynomialFunction.of(getDenominator().integrate()));
    }


    public ANumber integrate(Interval integrationInterval)
    {
        return getNumerator().integrate(integrationInterval).divideGET(getDenominator().integrate(integrationInterval));
    }


    public PolynomialFunction getNumerator()
    {
        return this.numerator;
    }


    public PolynomialFunction getDenominator()
    {
        return this.denominator;
    }
}