package com.orion.math.number.fraction.functional;

import com.orion.math.MathObject;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

class FractionOfFunction1x1InternalService implements MathObject
{
    void reciprocate(FractionOfFunction1x1 fraction)
    {
        Function1x1<ANumber, ANumber> denominator = fraction.getDenominator();
        Function1x1<ANumber, ANumber> numerator = fraction.getNumerator();
        fraction.setNumerator(denominator);
        fraction.setDenominator(numerator);
    }


    void addFraction(FractionOfFunction1x1 fraction1, FractionOfFunction1x1 fraction2)
    {
        FractionOfFunction1x1Rules.isValid(fraction2);
        Function1x1<ANumber, ANumber> numeratorTemp = (fraction1.getNumerator().multiply(fraction2.getDenominator())).add(fraction2.getNumerator().multiply(fraction1.getDenominator()));
        Function1x1<ANumber, ANumber> denominatorTemp = fraction2.getDenominator().multiply(fraction1.getDenominator());
        fraction1.setNumerator(numeratorTemp);
        fraction1.setDenominator(denominatorTemp);
    }


    void subtractFraction(FractionOfFunction1x1 fraction1, FractionOfFunction1x1 fraction2)
    {
        FractionOfFunction1x1Rules.isValid(fraction2);
        Function1x1<ANumber, ANumber> numeratorTemp = (fraction1.getNumerator().multiply(fraction2.getDenominator())).subtract(fraction2.getNumerator().multiply(fraction1.getDenominator()));
        Function1x1<ANumber, ANumber> denominatorTemp = fraction2.getDenominator().multiply(fraction1.getDenominator());
        fraction1.setNumerator(numeratorTemp);
        fraction1.setDenominator(denominatorTemp);
    }


    void multiply(FractionOfFunction1x1 fraction, Number x)
    {
        NumberRules.isNotNull(x);
        Function1x1<ANumber, ANumber> numeratorTemp = fraction.getNumerator().multiply(ANumber.of(x));
        Function1x1<ANumber, ANumber> denominatorTemp = fraction.getDenominator().multiply(ANumber.of(x));
        fraction.setNumerator(numeratorTemp);
        fraction.setDenominator(denominatorTemp);
    }
}